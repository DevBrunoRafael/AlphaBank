package App.Components.SendingEmails;

import App.Components.SendingEmails.Models.EmailConfig;
import App.Components.SendingEmails.Models.MailMarketing;
import App.Private.EmailAccess;

import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class JavaMail {

    private String sender; // atualmente o EmailAccess.USER ocupa essa posição
    private static final String host = "smtp.gmail.com";

    public static void sendMail(){

        try {

            Message message = startShippingSettings();

            message.setFrom(new InternetAddress(EmailConfig.sender));

            Address[] recipients = InternetAddress
                    .parse(EmailConfig.recipient);

            message.setRecipients(Message.RecipientType.TO, recipients);
            message.setSubject(EmailConfig.subject);
            message.setText(EmailConfig.message);

            System.out.println("enviando ...");

            Transport.send(message); /*Método para enviar a mensagem criada*/

            System.out.println("Email enviado." + "\nVerifique sua caixa de entrada e spam.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void sendMailWithAttachment(){

        try {

            Message message = startShippingSettings();

            message.setFrom(new InternetAddress(EmailConfig.sender));

            message.setRecipient(Message.RecipientType.TO,
                    new InternetAddress(EmailConfig.recipient)
            );

            message.setSubject(EmailConfig.subject);

            Multipart multiPart = new MimeMultipart();
            MimeBodyPart attachmentPart = new MimeBodyPart();
            MimeBodyPart textPart = new MimeBodyPart();
            MimeBodyPart htmlText = new MimeBodyPart();

            try {

                attachmentPart.attachFile(EmailConfig.fileLocation);
                textPart.setText(EmailConfig.message);

                multiPart.addBodyPart(textPart);
                multiPart.addBodyPart(attachmentPart);

                htmlText.setContent(MailMarketing.model,"text/html");
                multiPart.addBodyPart(htmlText);

            } catch (IOException e) {
                e.printStackTrace();
            }

            message.setContent(multiPart);

            System.out.println("enviando ...");

            Transport.send(message);

            System.out.println("Mensagem enviada com sucesso!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


    private static MimeMessage startShippingSettings(){

        Properties props = System.getProperties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");


        Session session = Session.getDefaultInstance(
                props, new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(EmailAccess.USER, EmailAccess.PASSWORD);
                    }
                }

        );
        //session.setDebug(true); /* Ativa Debug da seção no terminal */

        return new MimeMessage(session);
    }
}