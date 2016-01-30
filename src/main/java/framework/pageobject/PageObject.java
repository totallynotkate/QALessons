package framework.pageobject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kate on 27.01.16.
 */
public abstract class PageObject {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15, 250);
    }

    public Alert getAlert(){
        return wait.until(ExpectedConditions.alertIsPresent());
    }
}
