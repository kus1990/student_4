package com.company.helpers;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by maximgugaev on 20.11.16.
 */
public class PropertyParser {
    public static final String PROPERTIES_FILE = "/applications.properties";

    private PropertyParser() {
    }

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
