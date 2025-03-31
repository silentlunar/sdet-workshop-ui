package tests;

import helpers.CustomerNameHelper;
import helpers.PropertyProvider;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CustomersPage;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

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
        List<String> initialList = page.getListCustomers();
        page.clickSortCustomers(PropertyProvider.get("type.sort"));
        List<String> sortedList = page.getListCustomers();

        boolean isSorted = !initialList.equals(sortedList);
        assertTrue(isSorted, "Список покупателей должен измениться после сортировки");

        String nameToDelete = CustomerNameHelper.selectNameForDeletion(page.getListCustomers());
        page.deleteName(nameToDelete);

        List<String> currentList = page.getListCustomers();
        assertFalse(currentList.contains(nameToDelete), "Имя покупателя должно быть удалено из списка");
    }
}