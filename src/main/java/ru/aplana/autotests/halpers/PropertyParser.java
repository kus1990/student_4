package ru.aplana.autotests.halpers;

import java.io.IOException;
import java.util.Properties;

public class PropertyParser {
    public static final String PROPERTIES_FILE = "/applications.properties";

    public static String loadProperty(String name) {
        Properties props = new Properties();
        try {
            props.load(PropertyParser.class.getResourceAsStream(PROPERTIES_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value = "";
        if (name != null) {
            value = props.getProperty(name);
        }
        return value;
    }
}
