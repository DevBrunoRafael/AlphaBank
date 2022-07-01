package App.Components.SendingEmails.Models;

import App.Components.SendingEmails.Models.Private.EmailAccess;

import java.io.File;

public abstract class EmailConfig {

    public static String sender = EmailAccess.USER;
    public static String recipient = "brunorafaeldls2016@gmail.com";
    public static String subject = "SEU EXTRATO BANCÁRIO CHEGOU!";
    public static String message =
            """
            Agradecemos a preferência, para conhecer mais dos nossos
            serviços acesse: https://github.com/DevBrunoRafael

            
            Contato: 79998425258
            """;
    public static File fileLocation = new File(
            "C:/Users/Bruno Rafael/IdeaProjects/AlphaBank/src/main/java/"+
                    "App/Components/GeneratePDFs/File/Extrato(4).pdf"
    );

}
