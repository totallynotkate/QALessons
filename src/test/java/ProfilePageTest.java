import framework.pageobject.blocks.LeftMenuBlock;
import framework.pageobject.pages.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by totallynotkate on 29.01.16.
 */
public class ProfilePageTest extends RegularPageTest {

    public static final String H2_TEXT = "User Information";
    public static final String CSS_H2 = "h2";

    @Test
    public void canAccessProfilePageFromLeftMenu() {
        LeftMenuBlock leftMenuBlock = new HomePage(driver).getLeftMenuBlock();
        leftMenuBlock.goToProfilePage();
        Assert.assertEquals(H2_TEXT, driver.findElement(By.cssSelector(CSS_H2)).getText());
    }
}
