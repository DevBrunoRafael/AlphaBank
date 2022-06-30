package App.Components.GenaratePDFs;

import App.Support.Utilities;
import com.itextpdf.text.*;

public class ConstantsPDF {

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

    // DIRECTORIES
    public static final String IMAGE = "C:/Users/Bruno Rafael/Downloads/logo.png";


    // !!!!!! Modificar
    static String str = ("C:/Users/Bruno Rafael/IdeaProjects/AlphaBank/src/main/java" +
            "/App/Components/GenaratePDFs/File/Extrato(" + Utilities.CurrentTime().charAt(4) + ").pdf");

    public static final String FILE_PDF = str;
    // !!!!!! Modificar


    // TABLE
    public static final float BORDER_CELL = (float) 0.001;

}
