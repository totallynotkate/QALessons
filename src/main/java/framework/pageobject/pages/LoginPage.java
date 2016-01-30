package framework.pageobject.pages;

import framework.pageobject.PageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;

/**
 * Created by kate on 27.01.16.
 */
public class LoginPage extends PageObject {
    private static final String CSS_LOGIN_FIELD = "input#txtLogin";
    private static final String CSS_PASSWORD_FIELD = "input[type='password']";
    private static final String CSS_LOGIN_BUTTON = "#loginBtnSubmit";
    private static final String CSS_ALERT_MESSAGE = "#alertBox center";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage successfullyLoginAs(String login, String password) {
        login(login, password);
        return new HomePage(driver);
    }

    public LoginPage tryLoginAs(String login, String password) {
        login(login, password);
        return this;
    }

    public String getErrorMessage(){
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_ALERT_MESSAGE)));
        return errorMessage.getText();
    }

    private void login(String login, String password) {
        driver.findElement(By.cssSelector(CSS_LOGIN_FIELD)).sendKeys(login);
        driver.findElement(By.cssSelector(CSS_PASSWORD_FIELD)).sendKeys(password);
        driver.findElement(By.cssSelector(CSS_LOGIN_BUTTON)).click();
    }
}
