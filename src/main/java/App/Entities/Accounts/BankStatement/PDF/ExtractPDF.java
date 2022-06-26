package App.Entities.Accounts.BankStatement.PDF;

import App.Entities.Accounts.Account;
import App.Entities.Accounts.BankStatement.ExtractLog;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ExtractPDF implements MethodsPDF {

    private final Document document = new Document();
    private final Account account;
    private final List<ExtractLog> extracts;

    public ExtractPDF(Account account, List<ExtractLog> extracts) {
        this.account = account;
        this.extracts = extracts;

        try{
            PdfWriter.getInstance(this.document, new FileOutputStream(ConstantsPDF.FILE_PDF));
            document.open();

        } catch (DocumentException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    Locale ptBr = new Locale("pt", "BR");
    Date current = new Date();
    String data = new SimpleDateFormat("dd/MM/yyyy").format(current);


    @Override
    public void header() throws DocumentException, IOException {

        Image img = Image.getInstance(ConstantsPDF.IMAGE);
        img.setAlignment(Element.ALIGN_CENTER);
        this.document.add(img);


        this.document.add(new Paragraph(" "));
        this.document.add(new Paragraph(" "));
        this.document.add(new Paragraph(" "));


        Paragraph title = new Paragraph();
        title.setAlignment(Element.ALIGN_CENTER);
        title.add(new Chunk("EXTRATO BANCÁRIO",ConstantsPDF.FONT_TITLE));
        this.document.add(title);

        
        this.document.add(new Paragraph(" "));
        this.document.add(new Paragraph(" "));

        
        Paragraph numAccount = new Paragraph();
        numAccount.setAlignment(Element.ALIGN_LEFT);
        numAccount.add(
                new Chunk("N° Conta:  " + this.account.getNumAccount(),ConstantsPDF.FONT_SUBTITLE_I)
        );


        Paragraph client = new Paragraph();
        client.setAlignment(Element.ALIGN_LEFT);
        client.add(
                new Chunk("Cliente:  " + this.account.getClient().getName(),ConstantsPDF.FONT_SUBTITLE_I)
        );

        // implementar tipo de conta com if ou switch // conta corrente ou poupança
        
        this.document.add(numAccount);
        this.document.add(client);

    }

    @Override
    public void body() throws DocumentException {

        this.document.add(new Paragraph(" "));
        this.document.add(new Paragraph(" "));

        List<String> columns = Arrays.asList(
                "Data",
                "Horário",
                "Operação",
                "Valor",
                "RD"
        );

        PdfPTable table = new PdfPTable(columns.size());
        columns.forEach(field -> {
            PdfPCell c = new PdfPCell(Paragraph.getInstance(field));
            c.setHorizontalAlignment(Element.ALIGN_CENTER);
            c.setVerticalAlignment(Element.ALIGN_JUSTIFIED);
            table.addCell(c);
        });

        this.account.getHistLogs().forEach(fill -> {

            if(fill.getSender_receiver() != null){

                switch (fill.getTypeOp()){
                    case TRANSFER_SENT -> {

                        fillWithSubtractionOfValues(table, fill);
                        PdfPCell cell;

                        cell = new PdfPCell(new Phrase(fill.getSender_receiver(), ConstantsPDF.FONT_RED));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(cell);

                    }
                    case TRANSFER_RECEIVED -> {

                        fillWithAddingValues(table, fill);
                        PdfPCell cell;

                        cell = new PdfPCell(new Phrase(fill.getSender_receiver(), ConstantsPDF.FONT_BLUE));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(cell);

                    }
                }

            } else {

                switch (fill.getTypeOp()){
                    case DEPOSIT ->{

                        fillWithAddingValues(table, fill);
                        table.addCell(new PdfPCell(new Phrase(" ")));

                    }
                    case WITHDRAW -> {

                        fillWithSubtractionOfValues(table, fill);
                        table.addCell(new PdfPCell(new Phrase(" ")));

                    }
                }
            }
        });
        this.document.add(table);



        this.document.add(new Paragraph(" "));
        this.document.add(new Paragraph(" "));


        Paragraph balance = new Paragraph();
        balance.setAlignment(Element.ALIGN_RIGHT);
        balance.add(new Chunk(
                "Saldo:  " + NumberFormat.getCurrencyInstance(ptBr).format(this.account.getBalance()),
                ConstantsPDF.FONT_SUBTITLE_B
        ));
        this.document.add(balance);


        this.document.add(new Paragraph(" "));
        this.document.add(new Paragraph(" "));


    }

    @Override
    public void footer() throws DocumentException {
        Paragraph div = new Paragraph(
                "-------------------------------------------------------------------------------------"
        );
        div.setAlignment(Element.ALIGN_CENTER);
        this.document.add(div);

        Paragraph date = new Paragraph();
        date.setAlignment(Element.ALIGN_CENTER);
        date.add(data);
        this.document.add(date);

    }
    @Override
    public void printOut() throws IOException {
        if (this.document.isOpen()){
            this.document.close();
            Desktop.getDesktop().open(new File(ConstantsPDF.FILE_PDF));
        }
    }


//  auxiliary methods ================================================================================
    private void generateCells(PdfPTable table, ExtractLog fill) {
        PdfPCell cell = new PdfPCell(new Phrase(fill.getDate()));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(fill.getHours()));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(fill.getTypeOp().getOperation()));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
    }

    private void fillWithAddingValues(PdfPTable table, ExtractLog fill) {
        generateCells(table, fill);
        PdfPCell cell;

        cell = new PdfPCell(new Phrase(
                NumberFormat.getCurrencyInstance(ptBr).format(fill.getValue()),
                ConstantsPDF.FONT_BLUE
        ));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
    }

    private void fillWithSubtractionOfValues(PdfPTable table, ExtractLog fill) {
        generateCells(table, fill);
        PdfPCell cell;

        cell = new PdfPCell(new Phrase(
                NumberFormat.getCurrencyInstance(ptBr).format(fill.getValue()),
                ConstantsPDF.FONT_RED
        ));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
    }
//====================================================================================================

}
