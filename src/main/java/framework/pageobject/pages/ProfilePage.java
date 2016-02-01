package framework.pageobject.pages;

import framework.pageobject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by totallynotkate on 29.01.16.
 */
public class ProfilePage extends PageObject {
    private static final String CSS_FIRSTNAME_ALERT_MESSAGE = "#frmError";
    private static final String CSS_BTN_SAVE_CHANGES = "#btnSaveChanges";
    private static final String CSS_H2 = "h2";
    private static final String H2_TEXT = "User Information";
    private static final String PROFILE_PAGE_URL = "https://jhiuhiuhui.filelocker.com/settings";
    public static final String CSS_FIRST_NAME_INPUT_FIELD = "input[name='s_first_name']";

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public ProfilePage setFirstName(String firstName) {
        driver.findElement(By.cssSelector(CSS_FIRST_NAME_INPUT_FIELD)).clear();
        driver.findElement(By.cssSelector(CSS_FIRST_NAME_INPUT_FIELD)).sendKeys(firstName);
        driver.findElement(By.cssSelector(CSS_BTN_SAVE_CHANGES)).click();
        return this;
    }

    public String getErrorMessage() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_FIRSTNAME_ALERT_MESSAGE)));
        return errorMessage.getText();
    }

    public String getFirstNameFieldText(){
        return driver.findElement(By.cssSelector(CSS_FIRST_NAME_INPUT_FIELD)).getAttribute("value");
    }

    public static String getHeaderCSS(){
        return CSS_H2;
    }

    public static String getHeaderText(){
        return H2_TEXT;
    }

    public static String getProfilePageUrl(){
        return PROFILE_PAGE_URL;
    }
}
