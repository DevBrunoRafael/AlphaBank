package App.Entities.Accounts.BankStatement.PDF;

import com.itextpdf.text.*;

public class ConstantsPDF {

    // FONTES
    public static Font FONT_TITLE = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
    public static Font FONT_SUBTITLE_FIELD_I = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD);
    public static Font FONT_SUBTITLE_FILL_I = new Font(Font.FontFamily.HELVETICA, 13, Font.ITALIC);
    public static Font FONT_SUBTITLE_B = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD);

    public static Font FONT_CELL_HEADER = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
    public static Font FONT_CELL_BODY = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
    public static Font FONT_RED = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.RED.darker());
    public static Font FONT_BLUE = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLUE.darker());

    // DIRECTORIES
    public static final String IMAGE = "C:/Users/Bruno Rafael/Downloads/logo.png";

    StringBuilder str = new StringBuilder();

    public static final String FILE_PDF = "C:/Users/Bruno Rafael/IdeaProjects/AlphaBank/src/main/java" +
            "/App/Entities/Accounts/BankStatement/PDF/File/AlphaBank_Extrato.pdf";

    // TABLE
    public static final float BORDER_CELL = (float) 0.001;
}
