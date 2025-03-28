package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> clickSortCustomers() {
        List<String> listName = new ArrayList<>();
        click(sortCustomers);
        click(sortCustomers);
        for (WebElement element : customerNames) {
            listName.add(element.getText());
        }
        return listName;
    }

    public void deleteName(String targetName) {
        for (int i = 0; i < customerNames.size(); i++) {
            if (customerNames.get(i).getText().equals(targetName)) {
                wait.waitForVisibility(deleteButton.get(i));
                deleteButton.get(i).click();
                break;
            }
        }
    }
}
