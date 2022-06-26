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

        for (ExtractLog logs: this.extracts) {

            Paragraph l;
            if(logs.getSender_receiver() != null){

                switch (logs.getTypeOp()){

                    case TRANSFER_SENT -> {
                        l = new Paragraph(
                                "Data:  " + logs.getDate() + "   " +
                                        "Hora:  " + logs.getHours() + "   " +
                                        "Op:  " + logs.getTypeOp().getOperation() + "   " +
                                        "Valor:  " + NumberFormat.getCurrencyInstance(ptBr).format(logs.getValue()) + "   " +
                                        "Dest:  " + logs.getSender_receiver()
                        );
                        l.setAlignment(Element.ALIGN_LEFT);
                        this.document.add(l);
                    }

                    case TRANSFER_RECEIVED -> {
                        l = new Paragraph(
                                "Data:  " + logs.getDate() + "   " +
                                        "Hora:  " + logs.getHours() + "   " +
                                        "Op:  " + logs.getTypeOp().getOperation() + "   " +
                                        "Valor:  " + NumberFormat.getCurrencyInstance(ptBr).format(logs.getValue()) + "   "  +
                                        "Rem:  " + logs.getSender_receiver()
                        );
                        l.setAlignment(Element.ALIGN_LEFT);
                        this.document.add(l);
                    }
                }

            } else {

                l = new Paragraph(
                        "Data:  " + logs.getDate() + "   " +
                                "Hora:  " + logs.getHours() + "   " +
                                "Op:  " + logs.getTypeOp().getOperation() + "     " +
                                "Valor:  " + NumberFormat.getCurrencyInstance(ptBr).format(logs.getValue())
                );
                l.setAlignment(Element.ALIGN_LEFT);
                this.document.add(l);
            }
        }

        this.document.add(new Paragraph(" "));
        this.document.add(new Paragraph(" "));

        Font f = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
        Paragraph balance = new Paragraph();
        balance.setAlignment(Element.ALIGN_RIGHT);
        balance.add(new Chunk(
                "Saldo:  " + NumberFormat.getCurrencyInstance(ptBr).format(this.account.getBalance()),f
        ));
        this.document.add(balance);

        this.document.add(new Paragraph(" "));
        this.document.add(new Paragraph(" "));


    }
    public void body2() throws DocumentException {

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
            table.addCell(c);
        });

        this.account.getHistLogs().forEach(fill -> {

            if(fill.getSender_receiver() != null){

                switch (fill.getTypeOp()){
                    case TRANSFER_SENT -> {
                        table.addCell(new PdfPCell(new Phrase(fill.getDate())));
                        table.addCell(new PdfPCell(new Phrase(fill.getHours())));
                        table.addCell(new PdfPCell(new Phrase(fill.getTypeOp().getOperation())));
                        table.addCell(new PdfPCell(new Phrase(
                                NumberFormat.getCurrencyInstance(ptBr).format(fill.getValue())
                        )));
                        table.addCell(new PdfPCell(new Phrase(fill.getSender_receiver(), ConstantsPDF.FONT_RED)));
                    }
                    case TRANSFER_RECEIVED -> {
                        table.addCell(new PdfPCell(new Phrase(fill.getDate())));
                        table.addCell(new PdfPCell(new Phrase(fill.getHours())));
                        table.addCell(new PdfPCell(new Phrase(fill.getTypeOp().getOperation())));
                        table.addCell(new PdfPCell(new Phrase(
                                NumberFormat.getCurrencyInstance(ptBr).format(fill.getValue())
                        )));
                        table.addCell(new PdfPCell(new Phrase(fill.getSender_receiver(), ConstantsPDF.FONT_BLUE)));
                    }
                }

            } else {

                table.addCell(new PdfPCell(new Phrase(fill.getDate())));
                table.addCell(new PdfPCell(new Phrase(fill.getHours())));
                table.addCell(new PdfPCell(new Phrase(fill.getTypeOp().getOperation())));
                table.addCell(new PdfPCell(new Phrase(
                        NumberFormat.getCurrencyInstance(ptBr).format(fill.getValue())
                )));
                table.addCell(new PdfPCell(new Phrase(" ")));
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
}
