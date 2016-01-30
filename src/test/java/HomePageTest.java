import framework.pageobject.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.HashSet;
import java.util.Set;

public class HomePageTest extends RegularPageTest{

    private static final String TEST_FOLDER_NAME = "students";

    @Test
    public void checkFoldersList(){
        HomePage homePage = new HomePage(driver);

        //create Set of expected folders
        Set<String> expectedFolders = new HashSet<String>();
        expectedFolders.add("File Sharing");
        expectedFolders.add("test");

        //get Set of actual folders
        Set<String> actualFolders = homePage.getSetOfPresentFolders();

        Assert.assertEquals(actualFolders, expectedFolders);
    }

    @Test
    public void createNewFolder(){
        HomePage homePage = new HomePage(driver);
        homePage = homePage.createNewFolder(TEST_FOLDER_NAME);
        Assert.assertTrue(homePage.getSetOfPresentFolders().contains(TEST_FOLDER_NAME));
    }

    @Test
    public void deleteFolder(){
        HomePage homePage = new HomePage(driver);
        homePage = homePage.deleteFolder(TEST_FOLDER_NAME);
        Assert.assertFalse(homePage.getSetOfPresentFolders().contains(TEST_FOLDER_NAME));
    }
}
