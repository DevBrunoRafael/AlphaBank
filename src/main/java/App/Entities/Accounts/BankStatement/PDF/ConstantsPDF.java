package App.Entities.Accounts.BankStatement.PDF;

import com.itextpdf.text.*;

public class ConstantsPDF {

    // BRINCAR COM A MANIPULAÇÃO DAS FONTES DEPOIS

    // FONTES
    public static Font FONT_TITLE = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
    public static Font FONT_SUBTITLE_I = new Font(Font.FontFamily.HELVETICA, 14, Font.ITALIC);
    public static Font FONT_SUBTITLE_B = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
    public static Font FONT_RED = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.RED);
    public static Font FONT_BLUE = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLUE);

    // DIRECTORIES

    public static final String IMAGE = "C:/Users/Bruno Rafael/Downloads/logo.png";
    public static final String FILE_PDF = "C:/Users/Bruno Rafael/IdeaProjects/AlphaBank/src/main/java" +
            "/App/Entities/Accounts/BankStatement/PDF/File/AlphaBank_Extrato.pdf";






    public static void jumpLine(int qtd){

    }

}
