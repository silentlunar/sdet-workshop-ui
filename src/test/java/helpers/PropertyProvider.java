package helpers;

import lombok.SneakyThrows;

import java.io.InputStream;
import java.util.Properties;

/**
 * Поставщик свойств из файла конфигурации.
 */
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
                System.err.println("Файл конфигурации " + CONFIG_FILE + " не найден.");
                return;
            }
            properties.load(input);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}