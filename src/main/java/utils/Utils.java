package utils;

import app.AppContext;
import javafx.scene.Parent;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextInputControl;
import javafx.scene.text.Font;
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
                Font oldFont = l.getFont();
                l.setFont(Font.font(oldFont.getFamily(), ViewNavigator.scaleValue(oldFont.getSize())));
            } else if (node instanceof TextInputControl tic) {
                Font oldFont = tic.getFont();
                tic.setFont(Font.font(oldFont.getFamily(), ViewNavigator.scaleValue(oldFont.getSize())));
            }
        }
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
