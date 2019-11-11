package util;

import java.io.IOException;
import java.util.Properties;

public class PropertyRead {

    public static String readProperty(String property) {
        Properties properties = new Properties();

        try {
            properties.load(PropertyRead.class.getClassLoader().getResourceAsStream("dao.properties"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(property);
    }
}
