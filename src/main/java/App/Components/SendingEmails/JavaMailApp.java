package App.Components.SendingEmails;

import App.Components.SendingEmails.Models.MailMarketing;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public abstract class JavaMailApp {

    private String sender; // atualmente o EmailAccess.USER ocupa essa posição
    private static final String host = "smtp.gmail.com";

    public static void sendMail(String recipient, String subject, String text){

        try {

            Message message = startShippingSettings();

            // Remetente
            message.setFrom(new InternetAddress(EmailAccess.USER));

            // lista de Destinatário(s)
            Address[] toUser = InternetAddress
                    .parse(recipient);


            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(subject); // Assunto
            message.setText(text); // mensagem

            System.out.println("enviando ...");

            Transport.send(message); /*Método para enviar a mensagem criada*/

            System.out.println("Email enviado." + "\nVerifique sua caixa de entrada e spam.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void sendMailWithAttachment(String recipient, String subject, String text){

        try {

            Message message = startShippingSettings();

            // remetente
            message.setFrom(new InternetAddress(EmailAccess.USER));

            // destinatário (1)
            message.setRecipient(Message.RecipientType.TO,
                    new InternetAddress(recipient)
            );

            message.setSubject(subject); // assunto (atribuir parâmetro na assinatura)

            Multipart multiPart = new MimeMultipart();
            MimeBodyPart attachmentPart = new MimeBodyPart(); // anexo
            MimeBodyPart textPart = new MimeBodyPart(); // texto
            MimeBodyPart htmlText = new MimeBodyPart(); // texto

            try {

                File f = new File("C:/Users/Bruno Rafael/IdeaProjects/AlphaBank/src/main/java/App/Components/GeneratePDFs/File/Extrato(4).pdf");

                attachmentPart.attachFile(f);
                textPart.setText(text); // mensagem

                multiPart.addBodyPart(textPart);
                multiPart.addBodyPart(attachmentPart);

                htmlText.setContent(MailMarketing.model,"text/html");
                multiPart.addBodyPart(htmlText);

            } catch (IOException e) {
                e.printStackTrace();
            }

            message.setContent(multiPart);

            System.out.println("enviando ...");

            Transport.send(message); // Enviar mensagem

            System.out.println("Mensagem enviada com sucesso!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


    private static MimeMessage startShippingSettings(/*String user, String password*/){

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