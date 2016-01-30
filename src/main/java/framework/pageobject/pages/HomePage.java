package framework.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HomePage extends BasePage {
    private static final String CSS_AJAX_PROGRESS = "img[src='/images/biz/ajax-progress2.gif']";
    private static final String CSS_LISTING_LOADED_ELEMENT = "#listing_loaded";
    private static final String CSS_FILE_LISTING_AREA = "#bizFileListing";
    private static final String CSS_FOLDER = ".dirEntry";
    private static final String CSS_NEW_FOLDER_BUTTON = "div#createFolderBtn";
    private static final String CSS_INPUT_FOLDER_NAME = "input#folder_name";
    private static final String CSS_CREATE_FOLDER_BUTTON = "a[href='javascript:void(0)']";
    private static final String CSS_OK_BUTTON = "#w_sm_button";
    private static final String CSS_REMOVE_FOLDER = "a[title='Remove Folder']";
    private static final String CSS_YES_REMOVE_BUTTON = ".bizButton";
    private static final String FOLDER_NAME = "bdg-name";

    public HomePage(WebDriver driver){
        super(driver);
    }

    public Set<String> getSetOfPresentFolders(){
        waitUntilContentIsLoaded();
        List<WebElement> foldersList = driver.findElements(By.cssSelector(CSS_FILE_LISTING_AREA + " " + CSS_FOLDER));
        Set<String> actualFolders = foldersList.stream()
                .map(element -> element.getAttribute(FOLDER_NAME))
                .collect(Collectors.toSet());
        return actualFolders;
    }

    public HomePage createNewFolder(String folderName){
        waitUntilContentIsLoaded();
        driver.findElement(By.cssSelector(CSS_NEW_FOLDER_BUTTON)).click();
        waitUntilContentIsLoaded();
        driver.findElement(By.cssSelector(CSS_INPUT_FOLDER_NAME)).sendKeys(folderName);
        driver.findElement(By.cssSelector(CSS_CREATE_FOLDER_BUTTON)).click();
        waitUntilContentIsLoaded();
        driver.findElement(By.cssSelector(CSS_OK_BUTTON)).click();
        waitUntilContentIsLoaded();
        return this;
    }

    public HomePage deleteFolder(String folderName){
        waitUntilContentIsLoaded();
        driver.findElement(By.cssSelector(getFolderMenuCssSelector(folderName))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CSS_REMOVE_FOLDER))).click();
        waitUntilContentIsLoaded();
        driver.findElement(By.cssSelector(CSS_YES_REMOVE_BUTTON)).click();
        waitUntilContentIsLoaded();
        driver.findElement(By.cssSelector(CSS_OK_BUTTON)).click();
        waitUntilContentIsLoaded();
        return this;
    }

    private String getFolderMenuCssSelector(String folderName){
        return "li[title='" + folderName + "'] .dirActionButton>a";
    }

    private void waitUntilContentIsLoaded(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CSS_AJAX_PROGRESS)));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CSS_LISTING_LOADED_ELEMENT)));
    }
}
