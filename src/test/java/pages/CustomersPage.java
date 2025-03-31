package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс - страница со списком покупателем, с функционалом для сортироваки и удаления покупателей.
 * Расширяет класс BasePage.
 */
public class CustomersPage extends BasePage {
    public CustomersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    private WebElement buttonCustomers;

    @FindBy(xpath = "//a[@href=\"#\"]")
    private WebElement sortCustomers;

    @FindBy(xpath = "//tr[@class=\"ng-scope\"]/td[1]")
    private List<WebElement> customerNames;

    @FindBy(xpath = "//button[@ng-click=\"deleteCust(cust)\"]")
    private List<WebElement> deleteButton;

    public void clickButtonCustomers() {
        click(buttonCustomers);
    }

    public void clickSortCustomers(String typeSort) {
        if (typeSort.equals("asc")) {
            click(sortCustomers);
            click(sortCustomers);
        } else if (typeSort.equals("desc")) {
            click(sortCustomers);
        }
    }

    public List<String> getListCustomers() {
        return customerNames.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void deleteName(String targetName) {
        for (int i = 0; i < customerNames.size(); i++) {
            if (customerNames.get(i).getText().equals(targetName)) {
                wait.waitForVisibility(deleteButton.get(i));
                click(deleteButton.get(i));
                break;
            }
        }
    }
}
