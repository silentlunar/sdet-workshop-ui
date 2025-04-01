package pages;

import helpers.Waiters;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Базовая страница для создания дополнительных страниц.
 */
public abstract class BasePage {
    protected WebDriver driver;
    protected final Waiters wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waiters(driver);
    }

    @Step("Нажатие на кнопку")
    public void click(WebElement webElement) {
        wait.waitForVisibility(webElement).click();
    }
}