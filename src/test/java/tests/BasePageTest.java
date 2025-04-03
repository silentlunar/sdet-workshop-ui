package tests;

import helpers.PropertyProvider;
import helpers.Waiters;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BasePageTest {
    protected WebDriver driver;
    protected Waiters wait;

    @BeforeClass
    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PropertyProvider.get("web.url"));
        this.wait = new Waiters(driver);
        wait.waitForPageLoad();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (driver != null) {
            driver.quit();
        }
    }
}