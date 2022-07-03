package App.Support;

import App.Entities.Accounts.TypeOperations;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static App.Entities.Accounts.TypeOperations.*;

public abstract class Utilities {

    public static final Date current = new Date();


    public static String CurrentDate(){
        return new SimpleDateFormat("dd/MM/yyyy").format(current);
    }
    public static String CurrentTime(){
        return new SimpleDateFormat("HH:mm:ss").format(current);
    }

    public static String generateId(int typeAccount) {

        StringBuilder text = new StringBuilder();
        text.append("1");

        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            text.append(random.nextInt(9));
        }

        switch (typeAccount){
            case 0 -> text.append("-03"); // saving
            case 1 -> text.append("-05");
        }

        return text.toString();
    }

    public static String TypeChecker(String numAccount){
        return numAccount.charAt(9) == '3' ? "Poupança" : "Corrente";
    }

    public static TypeOperations ConvertToEnumTypeOp(String op){

        TypeOperations tp = null;

        if (DEPOSIT.getOperation().equals(op)) tp = DEPOSIT;
        else if (WITHDRAW.getOperation().equals(op)) tp =  WITHDRAW;
        else if (TRANSFER_SENT.getOperation().equals(op)) tp = TRANSFER_SENT;
        else if (TRANSFER_RECEIVED.getOperation().equals(op)) tp = TRANSFER_RECEIVED;

        return tp;
    }

}
