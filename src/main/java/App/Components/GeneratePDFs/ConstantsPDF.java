package App.Components.GeneratePDFs;

import com.itextpdf.text.*;

public abstract class ConstantsPDF {

    // FONTES
    public static Font FONT_TITLE = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
    public static Font FONT_SUBTITLE_FIELD_I = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD);
    public static Font FONT_SUBTITLE_FILL_I = new Font(Font.FontFamily.HELVETICA, 13, Font.NORMAL);
    public static Font FONT_SUBTITLE_B = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD);

    public static Font FONT_CELL_HEADER = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
    public static Font FONT_CELL_BODY = new Font(
            Font.FontFamily.HELVETICA, 10, Font.NORMAL, new BaseColor(60,60,60)
    );

    public static Font FONT_RED = new Font(
            Font.FontFamily.HELVETICA, 10, Font.NORMAL, new BaseColor(132,132,132)
    );
    public static Font FONT_BLUE = new Font(
            Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK.darker()
    );

    // TABLE
    public static float BORDER_CELL = (float) 0.001;

    // DIRECTORIES
    public static String IMAGE = "C:/Users/Bruno Rafael/IdeaProjects/AlphaBank/src/main/java/App/Assets/logo.png";

    public static String directory(String number){
        return "C:/Users/Bruno Rafael/IdeaProjects/AlphaBank/src/main/java" +
                "/App/Components/GeneratePDFs/File/Extrato acN°"+ number +".pdf";
    }



}
