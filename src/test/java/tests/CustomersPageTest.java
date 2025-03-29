package tests;

import helpers.CustomerNameHelper;
import helpers.PropertyProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CustomersPage;


public class CustomersPageTest extends BasePageTest {
    private CustomersPage page;

    @BeforeMethod
    public void setupPage() {
        page = new CustomersPage(driver);
    }

    @Test
    public void sortDeleteCustomers() {
        page.clickButtonCustomers();
        page.clickSortCustomers(PropertyProvider.get("type.sort"));
        page.deleteName(CustomerNameHelper.selectNameForDeletion(page.getListCustomers()));
    }
}