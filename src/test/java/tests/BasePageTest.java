package tests;

import helpers.PropertyProvider;
import helpers.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeSuite;


public abstract class BasePageTest {
    protected WebDriver driver;
    protected Wait wait;

    @BeforeSuite
    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PropertyProvider.get("web.url"));
        this.wait = new Wait(driver);
        wait.waitForPageLoad();
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
//            driver.quit();
        }
    }
}