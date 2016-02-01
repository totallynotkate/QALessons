package framework.pageobject.blocks;

import framework.pageobject.PageObject;
import framework.pageobject.pages.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by totallynotkate on 29.01.16.
 */
public class LeftMenuBlock extends PageObject{
    private static final String CSS_SETTINGS = ".navBoxHeader.menu-settings.accordion-toggle";
    private static final String CSS_PROFILE_PAGE = "a[href='/settings']";
    private WebElement leftMenuBLock;

    public LeftMenuBlock(WebDriver driver, WebElement leftMenuBLock) {
        super(driver);
        this.leftMenuBLock = leftMenuBLock;
    }

    public ProfilePage goToProfilePage(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CSS_SETTINGS))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CSS_PROFILE_PAGE))).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(ProfilePage.getHeaderCSS()),
                ProfilePage.getHeaderText()));
        return new ProfilePage(driver);
    }
}
