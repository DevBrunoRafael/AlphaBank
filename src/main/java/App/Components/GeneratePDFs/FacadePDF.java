package App.Components.GeneratePDFs;

import App.Entities.Accounts.Account;
import com.itextpdf.text.DocumentException;

import java.io.IOException;

public class FacadePDF {

    public FacadePDF(Account account) throws DocumentException, IOException {
        buildExtractPDF(account);
    }

    public void buildExtractPDF(Account account) throws DocumentException, IOException {
        ExtractPDF extract = new ExtractPDF(account);
        extract.header();
        extract.body();
        extract.footer();
        extract.printOut();
    }
}
