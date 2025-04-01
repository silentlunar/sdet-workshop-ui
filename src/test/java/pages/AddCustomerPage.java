package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Класс - страница на которой можно добавить нового клиента.
 * Расширяет класс BasePage.
 */
public class AddCustomerPage extends BasePage {

    public AddCustomerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    private WebElement buttonAddCustomer;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    private WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @Step("Выбор в меню пункта Add Customer")
    public void clickAddCustomer() {
        click(buttonAddCustomer);
    }

    @Step("Заполнение поля First Name {firstName}")
    public AddCustomerPage fillFirstName(String firstName) {
        wait.waitForVisibility(this.firstName);
        this.firstName.sendKeys(firstName);
        return this;
    }

    @Step("Заполнение поля Last Name {lastName}")
    public AddCustomerPage fillLastName(String lastName) {
        this.lastName.sendKeys(lastName);
        return this;
    }

    @Step("Заполнение поля Post Code {postCode}")
    public AddCustomerPage fillPostCode(String postCode) {
        this.postCode.sendKeys(postCode);
        return this;
    }

    @Step("Нажатие на кнопку создания покупателя")
    public void clickSubmitButton() {
        click(submitButton);
    }
}