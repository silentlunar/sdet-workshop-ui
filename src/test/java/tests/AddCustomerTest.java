package tests;

import helpers.DataGenerator;
import helpers.PropertyProvider;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddCustomerPage;

/**
 * Тест для создания нового покупателя.
 */
public class AddCustomerTest extends BasePageTest {
    private AddCustomerPage page;

    @BeforeMethod
    public void setupPage() {
        page = new AddCustomerPage(driver);
    }

    @Test
    @Step("Добавление нового покупателя")
    public void addNewCustomer() {
        page.clickAddCustomer();
        String postCode = DataGenerator.generatePostCode();
        DataGenerator.generateFirstName(postCode);
        page.fillFirstName(DataGenerator.generateFirstName(postCode));
        page.fillLastName(PropertyProvider.get("name.last"));
        page.fillPostCode(postCode);
        page.clickSubmitButton();
    }
}