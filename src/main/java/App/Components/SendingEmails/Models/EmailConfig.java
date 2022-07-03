package App.Components.SendingEmails.Models;

import App.Components.GeneratePDFs.ConstantsPDF;
import App.Components.SendingEmails.Models.Private.EmailAccess;

import java.io.File;

public class EmailConfig {

    public static String sender = EmailAccess.USER;
    public static String recipient = "brunorafaeldls2016@gmail.com";
    public static String subject = "SEU EXTRATO BANCÁRIO CHEGOU!";
    public static String message = ""; // mail marketing sendo utilizado
    public static File fileLocation = new File(
            "C:/Users/Bruno Rafael/IdeaProjects/AlphaBank/src/main/java/"+
                    "App/Components/GeneratePDFs/File/Extrato.pdf"
    );

    // implementar id da conta no nome do pdf
}
