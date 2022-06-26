package App.Entities.Accounts.BankStatement.PDF;

import App.Entities.Accounts.Account;
import App.Entities.Accounts.BankStatement.ExtractLog;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ExtractPDF implements ExtractBase{

    private final Document document = new Document();
    private final Account account;
    private final List<ExtractLog> extracts;

    public ExtractPDF(Account account, List<ExtractLog> extracts) {
        this.account = account;
        this.extracts = extracts;

        try{
            PdfWriter.getInstance(this.document, new FileOutputStream(
                    "C:/Users/Bruno Rafael/IdeaProjects/AlphaBank/src/main/java" +
                            "/App/Entities/Accounts/BankStatement/PDF/File/AlphaBank_Extrato.pdf"
            ));
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

        Image img = Image.getInstance("C:/Users/Bruno Rafael/Downloads/logo.png");
        img.setAlignment(Element.ALIGN_CENTER);
        this.document.add(img);

        this.document.add(new Paragraph(" "));
        this.document.add(new Paragraph(" "));
        this.document.add(new Paragraph(" "));

        Font f = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
        Paragraph title = new Paragraph();
        title.setAlignment(Element.ALIGN_CENTER);
        title.add(new Chunk("EXTRATO BANCÁRIO",f));
        this.document.add(title);

        this.document.add(new Paragraph(" "));
        this.document.add(new Paragraph(" "));

        Paragraph numAccount = new Paragraph();
        numAccount.setAlignment(Element.ALIGN_LEFT);
        numAccount.add(new Chunk("N° Conta:  " + this.account.getNumAccount()));

        Paragraph client = new Paragraph();
        client.setAlignment(Element.ALIGN_LEFT);
        client.add(new Chunk("Cliente:  " + this.account.getClient().getName()));

        this.document.add(numAccount);
        this.document.add(client);

    }

    @Override
    public void body() throws DocumentException {

        List<ExtractLog> writeLogs = this.extracts;

        this.document.add(new Paragraph(" "));
        this.document.add(new Paragraph(" "));

        for (ExtractLog logs: writeLogs) {
            Paragraph l = new Paragraph(
                    "Data:  " + logs.getDate() + "   " +
                            "Hora:  " + logs.getHours() + "   " +
                            "Op:  " + logs.getTypeOp() + "   " +
                            "Valor:  " + NumberFormat.getCurrencyInstance(ptBr).format(logs.getValue())
            );

            l.setAlignment(Element.ALIGN_CENTER);

            this.document.add(l);
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
    public void printOut() {
        if (this.document.isOpen()){
            this.document.close();
        }
    }
}
