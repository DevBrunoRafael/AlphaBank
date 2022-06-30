package App.Components.GenaratePDFs;

import App.Entities.Accounts.Account;
import App.Entities.Accounts.BankStatement.ExtractLog;
import App.Support.Utilities;
import com.itextpdf.text.*;
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
import java.util.*;
import java.util.List;

public class ExtractPDF implements StructurePDF {

    private final Document document = new Document();
    private final Account account;


    public ExtractPDF(Account account) {
        this.account = account;

        try{
            PdfWriter.getInstance(this.document, new FileOutputStream(ConstantsPDF.FILE_PDF));
            document.open();

        } catch (DocumentException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    Locale ptBr = new Locale("pt", "BR");

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
        title.add(
                new Chunk("EXTRATO BANCÁRIO",ConstantsPDF.FONT_TITLE)
        );
        this.document.add(title);


        this.document.add(new Paragraph(" "));
        this.document.add(new Paragraph(" "));

        
        Paragraph numAccount = new Paragraph();
        numAccount.setAlignment(Element.ALIGN_LEFT);
        numAccount.add(
                new Chunk("N° Conta: ", ConstantsPDF.FONT_SUBTITLE_FIELD_I)
        );
        numAccount.add(
                new Phrase(this.account.getNumAccount(), ConstantsPDF.FONT_SUBTITLE_FILL_I)
        );
        numAccount.add(
                new Chunk("    ")
        );
        numAccount.add(
                new Chunk("Tipo: ", ConstantsPDF.FONT_SUBTITLE_FIELD_I)
        );
        numAccount.add(
                new Phrase(typeChecker(this.account.getNumAccount()),ConstantsPDF.FONT_SUBTITLE_FILL_I)
        );

        Paragraph client = new Paragraph();
        client.setAlignment(Element.ALIGN_LEFT);
        client.add(
                new Chunk("Cliente: ", ConstantsPDF.FONT_SUBTITLE_FIELD_I)
        );
        client.add(
                new Phrase(this.account.getClient().getName(), ConstantsPDF.FONT_SUBTITLE_FILL_I)
        );

        this.document.add(numAccount);
        this.document.add(client);
    }

    @Override
    public void body() throws DocumentException {

        this.document.add(new Paragraph(" "));
        this.document.add(new Paragraph(" "));

        PdfPTable table = new PdfPTable(
                new float[]{0.15f, 0.15f, 0.25f, 0.2f, 0.3f}
        );

        table.setWidthPercentage(95f);

        List<String> columns = Arrays.asList(
                "Data",
                "Horário",
                "Operação",
                "Valor",
                "RD"
        );

        columns.forEach(field -> {
            PdfPCell cell = new PdfPCell(new Paragraph(
                    field.toUpperCase(),
                    ConstantsPDF.FONT_CELL_HEADER
            ));

            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GRAY.brighter());
            cell.setPaddingBottom(3.5f);
            table.addCell(cell);
        });

        this.account.getHistLogs().forEach(fill -> {

            if(fill.getSender_receiver() != null){

                switch (fill.getTypeOp()){
                    case TRANSFER_SENT -> {

                        fillWithSubtractionOfValues(table, fill);
                        PdfPCell cell;

                        cell = new PdfPCell(new Phrase(fill.getSender_receiver(), ConstantsPDF.FONT_RED));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setBorderWidth(ConstantsPDF.BORDER_CELL);
                        table.addCell(cell);
                    }
                    case TRANSFER_RECEIVED -> {

                        fillWithAddingValues(table, fill);
                        PdfPCell cell;

                        cell = new PdfPCell(new Phrase(fill.getSender_receiver(), ConstantsPDF.FONT_BLUE));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setBorderWidth(ConstantsPDF.BORDER_CELL);
                        table.addCell(cell);
                    }
                }
            }
            else {
                switch (fill.getTypeOp()){
                    case DEPOSIT -> {

                        fillWithAddingValues(table, fill);
                        PdfPCell cell = new PdfPCell(new Phrase(" "));
                        cell.setBorderWidth(ConstantsPDF.BORDER_CELL);
                        table.addCell(cell);

                    }
                    case WITHDRAW -> {

                        fillWithSubtractionOfValues(table, fill);
                        PdfPCell cell = new PdfPCell(new Phrase(" "));
                        cell.setBorderWidth(ConstantsPDF.BORDER_CELL);
                        table.addCell(cell);

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
                "__________________________________________" +
                        "_______________"
        );
        div.setAlignment(Element.ALIGN_CENTER);
        this.document.add(div);

        Paragraph date = new Paragraph();
        date.setAlignment(Element.ALIGN_CENTER);
        date.add(Utilities.CurrentDate());
        this.document.add(date);

    }

    @Override
    public void printOut() throws IOException {
        if (this.document.isOpen()){
            this.document.close();
            Desktop.getDesktop().open(new File(ConstantsPDF.FILE_PDF));
        }
    }


/*    auxiliary methods ================================================================================*/
    private void generateCells(PdfPTable table, ExtractLog fill) {
        PdfPCell cell = new PdfPCell(new Phrase(fill.getDate(),ConstantsPDF.FONT_CELL_BODY));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorderWidth(ConstantsPDF.BORDER_CELL);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(fill.getHours(), ConstantsPDF.FONT_CELL_BODY));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorderWidth(ConstantsPDF.BORDER_CELL);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(fill.getTypeOp().getOperation(),ConstantsPDF.FONT_CELL_BODY));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorderWidth(ConstantsPDF.BORDER_CELL);
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
        cell.setBorderWidth(ConstantsPDF.BORDER_CELL);
        table.addCell(cell);
    }

    private void fillWithSubtractionOfValues(PdfPTable table, ExtractLog fill) {
        generateCells(table, fill);
        PdfPCell cell;

        cell = new PdfPCell(new Phrase(
                "-" +
                NumberFormat.getCurrencyInstance(ptBr).format(fill.getValue()),
                ConstantsPDF.FONT_RED
        ));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorderWidth(ConstantsPDF.BORDER_CELL);
        table.addCell(cell);
    }
    private String typeChecker(String numAccount){
        return numAccount.charAt(9) == '3' ? "Poupança" : "Corrente";
    }


/*====================================================================================================*/

}
