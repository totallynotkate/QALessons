import framework.pageobject.pages.HomePage;
import framework.pageobject.pages.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends BaseTest {
    private static final String LOGIN_NAME = "minchekov160@hotmail.com";
    private static final String PASSWORD = "Qw1111";

    public static String getLoginName(){
        return LOGIN_NAME;
    }

    public static String getPassword(){
        return PASSWORD;
    }

    @Test
    public void canLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.successfullyLoginAs(LOGIN_NAME, PASSWORD);
        String actualLogin = homePage.getTopMenuBlock().getTitle();
        Assert.assertEquals(LOGIN_NAME, actualLogin, String.format("Expected %1$s but found %2$s",
                LOGIN_NAME, actualLogin));
    }

    @Test(dataProvider = "emptyCredentials")
    public void cannotLoginWithEmptyCredentials(String login, String password, String expectedAlertMessage) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage = loginPage.tryLoginAs(login, password);
        Alert alert = loginPage.getAlert();
        String actualAlertMessage = alert.getText();
        alert.accept();
        Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
    }

    @Test(dataProvider = "invalidCredentials")
    public void cannotLoginWithInvalidCredentials(String login, String password, String expectedErrorMessage) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage = loginPage.tryLoginAs(login, password);
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @DataProvider
    public Object[][] emptyCredentials() {
        return new Object[][]{
                {"", "", "Username must be supplied"},
                {"", PASSWORD, "Username must be supplied"},
                {LOGIN_NAME, "", "Password must be supplied"}
        };
    }

    @DataProvider
    public Object[][] invalidCredentials() {
        String alertMessage = "Unable to verify credentials";
        return new Object[][]{
                {LOGIN_NAME, RandomStringUtils.randomAlphabetic(8), alertMessage},
                {RandomStringUtils.randomAlphabetic(10), PASSWORD, alertMessage},
                {RandomStringUtils.randomAscii(15), RandomStringUtils.randomNumeric(8), alertMessage},
                {RandomStringUtils.random(15), RandomStringUtils.randomAscii(10), alertMessage},
                {RandomStringUtils.randomAscii(20), RandomStringUtils.randomAlphanumeric(10), alertMessage}
        };
    }
}
