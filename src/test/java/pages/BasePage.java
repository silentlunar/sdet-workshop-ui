package pages;

import helpers.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Базовая страница для создания дополнительных страниц.
 */
public abstract class BasePage {
    protected WebDriver driver;
    protected final Wait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Wait(driver);
    }

    public void click(WebElement webElement) {
        wait.waitForVisibility(webElement).click();
    }
}
