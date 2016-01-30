package framework.pageobject.pages;

import framework.pageobject.PageObject;
import framework.pageobject.blocks.LeftMenuBlock;
import framework.pageobject.blocks.TopMenuBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by kate on 27.01.16.
 */
public abstract class BasePage extends PageObject {
    private static final String CSS_TOP_MENU = "#header-outside";
    public static final String CSS_LEFT_BOX = "#leftBox";

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public TopMenuBlock getTopMenuBlock(){
        WebElement topMenu = driver.findElement(By.cssSelector(CSS_TOP_MENU));
        return new TopMenuBlock(driver, topMenu);
    }

    public LeftMenuBlock getLeftMenuBlock(){
        WebElement leftMenu = driver.findElement(By.cssSelector(CSS_LEFT_BOX));
        return new LeftMenuBlock(driver, leftMenu);
    }
}
