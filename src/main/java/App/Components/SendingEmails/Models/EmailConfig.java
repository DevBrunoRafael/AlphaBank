package App.Components.SendingEmails.Models;

import App.Components.GeneratePDFs.ConstantsPDF;
import App.Private.EmailAccess;

import java.io.File;

public class EmailConfig {

    public static String sender = EmailAccess.USER;
    public static String recipient = "brunorafaeldls2016@gmail.com";
    public static String subject = "SEU EXTRATO BANCÁRIO CHEGOU!";
    public static String message = ""; // mail marketing sendo utilizado
    public static File fileLocation = new File(""); // definir após geração do pdf
}
