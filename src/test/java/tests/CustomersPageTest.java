package tests;

import helpers.CustomerNameHelper;
import helpers.CustomerSortHelper;
import helpers.PropertyProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CustomersPage;

import java.util.List;

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
    @Description("Сортировка и удаление покупателей")
    @Severity(SeverityLevel.NORMAL)
    @Step("Сортировка и удаление покупателей")
    public void sortDeleteCustomers() {
        sortCustomersStep();
        deleteCustomerStep();
    }

    @Step("Сортировка покупателей")
    private void sortCustomersStep() {
        page.clickButtonCustomers();
        page.clickSortCustomers(PropertyProvider.get("type.sort"));
        List<String> sortedList = page.getListCustomers();
        boolean isSorted = CustomerSortHelper.isListSorted(sortedList, PropertyProvider.get("type.sort"));
        Assert.assertTrue(isSorted, "Список покупателей должен быть отсортирован по типу " + PropertyProvider.get("type.sort"));
    }

    @Step("Удаление покупателя")
    private void deleteCustomerStep() {
        String nameToDelete = CustomerNameHelper.selectNameForDeletion(page.getListCustomers());
        page.deleteName(nameToDelete);

        List<String> currentList = page.getListCustomers();
        Assert.assertFalse(currentList.contains(nameToDelete), "Имя покупателя должно быть удалено из списка");
    }
}