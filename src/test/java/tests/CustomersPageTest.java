package tests;

import helpers.CustomerNameHelper;
import helpers.PropertyProvider;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CustomersPage;

/**
 * Тест для сортировки и удаления покупателей.
 */
public class CustomersPageTest extends BasePageTest {
    private CustomersPage page;

    @BeforeMethod
    public void setupPage() {
        page = new CustomersPage(driver);
    }

    @Test
    @Step("Сортировка и удаление покупателей")
    public void sortDeleteCustomers() {
        page.clickButtonCustomers();
        page.clickSortCustomers(PropertyProvider.get("type.sort"));
        page.deleteName(CustomerNameHelper.selectNameForDeletion(page.getListCustomers()));
    }
}