package tests;

import helpers.CustomerNameHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CustomersPage;

import java.util.ArrayList;
import java.util.List;

public class CustomersPageTest extends BasePageTest {
    private CustomersPage page;
    private List<String> names;

    @BeforeClass
    public void setupPage() {
        page = new CustomersPage(driver);
        names = new ArrayList<>();
    }

    @Test
    public void sortCustomers() {
        page.clickButtonCustomers();
        names = page.clickSortCustomers();
        page.deleteName(CustomerNameHelper.selectNameForDeletion(names));
    }

//    @Test
//    public void deleteCustomer() {
//        page.deleteName(CustomerNameHelper.selectNameForDeletion(names));
//    }
}