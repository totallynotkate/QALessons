import framework.pageobject.blocks.LeftMenuBlock;
import framework.pageobject.pages.HomePage;
import framework.pageobject.pages.ProfilePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by totallynotkate on 29.01.16.
 */
public class ProfilePageTest extends RegularPageTest {

    @Test
    public void canAccessProfilePageFromLeftMenu() {
        LeftMenuBlock leftMenuBlock = new HomePage(driver).getLeftMenuBlock();
        leftMenuBlock.goToProfilePage();
        Assert.assertEquals(ProfilePage.getHeaderText(), driver.findElement(By.cssSelector(ProfilePage.getHeaderCSS())).getText());
    }

    @Test (dataProvider = "validFirstName")
    public void canAssignValidFirstName(String firstName){
        ProfilePage profilePage = new ProfilePage(driver);
        driver.get(ProfilePage.getProfilePageUrl()); //TODO
        profilePage.setFirstName(firstName);
        Assert.assertEquals(firstName, profilePage.getFirstNameFieldText());
    }

    @Test (dataProvider = "invalidFirstName")
    public void canNotAssignInvalidFirstName(String firstName){
        ProfilePage profilePage = new ProfilePage(driver);
        driver.get(ProfilePage.getProfilePageUrl()); //TODO
        profilePage.setFirstName(firstName);
        profilePage.getErrorMessage();
    }

    @DataProvider
    public Object[][]validFirstName(){
        return new Object[][]{
                {RandomStringUtils.randomAlphabetic(5)},
                {RandomStringUtils.randomAlphabetic(10)},
                {RandomStringUtils.randomAlphabetic(15)},
                {RandomStringUtils.randomAlphabetic(20)},
                {"Test"}
        };
    }

    @DataProvider
    public Object[][] invalidFirstName(){
        return new Object[][] {
                {RandomStringUtils.randomAlphanumeric(10)+RandomStringUtils.randomNumeric(2)},
                {RandomStringUtils.randomAlphabetic(1)},
                {RandomStringUtils.randomAlphabetic(31)}
        };
    }
}
