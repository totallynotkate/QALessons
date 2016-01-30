package framework.pageobject.blocks;

import framework.pageobject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by kate on 27.01.16.
 */
public class TopMenuBlock extends PageObject {
    private static final String CSS_TITLE_ELEMENT = ".info[title]";
    public static final String ATTRIBUTE_DATA = "data";
    private WebElement topMenuBlock;

    public TopMenuBlock(WebDriver driver, WebElement topMenu) {
        super(driver);
        this.topMenuBlock = topMenu;
    }

    public String getTitle(){
        return topMenuBlock.findElement(By.cssSelector(CSS_TITLE_ELEMENT)).getAttribute(ATTRIBUTE_DATA);
    }
}
