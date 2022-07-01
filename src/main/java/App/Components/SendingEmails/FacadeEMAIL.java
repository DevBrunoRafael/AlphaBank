package App.Components.SendingEmails;

public class FacadeEMAIL {

    public void submit(){
        JavaMail.sendMail();
    }
    public void submitAt(){
        JavaMail.sendMailWithAttachment();
    }

}
