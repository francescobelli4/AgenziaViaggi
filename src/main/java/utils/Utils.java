package utils;

import app.AppContext;
import javafx.scene.Parent;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextInputControl;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import views.ViewNavigator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

    private static boolean propsLoaded = false;
    private static final Properties props = new Properties();

    private Utils() {}

    private static void loadProps() throws IllegalStateException {
        if (propsLoaded) return;

        propsLoaded = true;

        InputStream input = AppContext.class.getResourceAsStream("/dbcred.properties");
        if (input == null) {
            throw new IllegalStateException("File properties non trovato.");
        }

        try {
            props.load(input);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String getProperty(String prop) throws IllegalStateException {
        loadProps();
        return props.getProperty(prop);
    }

    public static void scaleFonts(Parent parent) {
        for (var node : parent.getChildrenUnmodifiable()) {

            if (node instanceof Parent p) {
                scaleFonts(p);
            }

            if (node instanceof Labeled l) {
                l.setFont(getScaledFont(l.getFont()));
            } else if (node instanceof TextInputControl tic) {
                tic.setFont(getScaledFont(tic.getFont()));
            }
        }
    }

    private static Font getScaledFont(Font oldFont) {
        double newSize = ViewNavigator.scaleValue(oldFont.getSize());

        String style = oldFont.getStyle().toLowerCase();

        FontWeight weight = FontWeight.NORMAL;
        if (style.contains("bold")) {
            weight = FontWeight.BOLD;
        } else if (style.contains("black") || style.contains("heavy")) {
            weight = FontWeight.BLACK;
        } else if (style.contains("light")) {
            weight = FontWeight.LIGHT;
        }

        return Font.font(oldFont.getFamily(), weight, FontPosture.REGULAR, newSize);
    }

    //To be fast... https://stackoverflow.com/questions/8248277/how-to-determine-if-a-string-has-non-alphanumeric-characters
    private static boolean isAlphanumeric(String str) {
        return str.matches("[a-zA-Z0-9]+") || str.isEmpty();
    }

    public static TextFormatter<?> getTextFormatter(int maxLength, boolean onlyAlphanumeric) {
        return new TextFormatter<>(change -> {
            int len = change.getControlNewText().length();

            if (onlyAlphanumeric) {
                return len < maxLength && Utils.isAlphanumeric(change.getText()) ? change : null;
            } else {
                return len < maxLength ? change : null;
            }
        });
    }
}
