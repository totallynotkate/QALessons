import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static final String LOGIN_URL = "https://secure.filelocker.com/login";

    protected static WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(LOGIN_URL);
    }

    @AfterMethod
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }

    @AfterSuite
    public void afterClass() {
        driver.quit();
    }

}
