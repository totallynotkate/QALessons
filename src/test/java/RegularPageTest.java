import framework.pageobject.pages.LoginPage;
import org.testng.annotations.BeforeMethod;

/**
 * Created by totallynotkate on 28.01.16.
 */
public class RegularPageTest extends BaseTest {
    private static final String LOGIN_URL = "https://secure.filelocker.com/login";

    @BeforeMethod
    @Override
    public void beforeMethod(){
        driver.get(LOGIN_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successfullyLoginAs(LoginTest.getLoginName(), LoginTest.getPassword());
    }
}
