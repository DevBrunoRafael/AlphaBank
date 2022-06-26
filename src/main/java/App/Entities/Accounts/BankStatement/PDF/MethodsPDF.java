package App.Entities.Accounts.BankStatement.PDF;

import com.itextpdf.text.DocumentException;

import java.io.IOException;

public interface MethodsPDF {
    void header() throws DocumentException, IOException;
    void body() throws DocumentException;
    void footer() throws DocumentException;
    void printOut() throws IOException;
}
