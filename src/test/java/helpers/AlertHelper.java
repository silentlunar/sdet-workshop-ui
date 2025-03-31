package helpers;

import org.openqa.selenium.WebDriver;

/**
 * Класс-помощник для работы с алертами.
 */
public class AlertHelper {
    public static String getTextAlert(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }

    public static void closeAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }
}