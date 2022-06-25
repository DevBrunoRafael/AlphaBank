package App.Support;

import java.util.Random;

public class GenerateId {

    // Singleton =======================================================================================================
    private static GenerateId instance;
    private GenerateId(){
    }
    public static GenerateId getInstance() {
        if (instance == null)
            instance = new GenerateId();
        return instance;
    }
    // =================================================================================================================

    public String gerarId(int typeAccount) {
        StringBuilder text = new StringBuilder();
        text.append("1");

        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            text.append(random.nextInt(10));
        }

        switch (typeAccount){
            case 0 -> text.append("-03"); // saving
            case 1 -> text.append("-05");
        }

        return text.toString();
    }

}
