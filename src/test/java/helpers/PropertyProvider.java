package helpers;

import lombok.SneakyThrows;

import java.io.InputStream;
import java.util.Properties;

public class PropertyProvider {
    private static final String CONFIG_FILE = "conf.properties";
    private static final Properties properties = new Properties();

    static {
        loadProperties();
    }

    @SneakyThrows
    private static void loadProperties() {
        try (InputStream input = PropertyProvider.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                System.out.println("Sorry, unable to find " + CONFIG_FILE);
                return;
            }
            properties.load(input);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
