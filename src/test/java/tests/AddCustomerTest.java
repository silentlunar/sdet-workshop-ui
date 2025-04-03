package tests;

import helpers.AlertHelper;
import helpers.DataGenerator;
import helpers.PropertyProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.Assert;
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
    @Description("Добавление нового покупателя")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Добавление нового покупателя")
    public void addNewCustomer() {
        addCustomerStep();
        verifyAlert();
    }

    @Step("Шаг добавления покупателя")
    private void addCustomerStep() {
        page.clickAddCustomer();
        String postCode = DataGenerator.generatePostCode();
        String firstName = DataGenerator.generateFirstName(postCode);

        page.fillFirstName(firstName)
                .fillLastName(PropertyProvider.get("name.last"))
                .fillPostCode(postCode)
                .clickSubmitButton();
    }

    @Step("Проверка алерта")
    private void verifyAlert() {
        String alertText = AlertHelper.getTextAlert(driver);
        Assert.assertTrue(alertText.contains("Customer added successfully with customer"), "Текст алерта не соответствует ожидаемому");
        AlertHelper.closeAlert(driver);
    }
}