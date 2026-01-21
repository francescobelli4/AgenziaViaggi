package utils;

import app.AppContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

    private static final Properties props = new Properties();

    private Utils() {}

    static {
        InputStream input = AppContext.class.getResourceAsStream("/dbcred.properties");
        try {
            props.load(input);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String getProperty(String prop) {
        return props.getProperty(prop);
    }
}
