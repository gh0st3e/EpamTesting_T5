package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CreatedPastePage;
import page.NewPastePage;


public class NewPageWithTest {
    private WebDriver driver;
    private static final String PASTETEXT = "git config --global user.name  \"New Sheriff in Town\"\n" + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" + "git push origin master --force";
    private static final String PASTE_NAME = "how to gain dominance among developers";
    private static final String PASTE_HIGHLIGHTING = "Bash";
    private static final String PASTE_EXPIRATION = "10 Minutes";
    CreatedPastePage createdPastePage;

    @BeforeMethod
    public void createNewPaste() {
        driver = new ChromeDriver();
        NewPastePage mainPage = new NewPastePage(driver);
        mainPage.openPage();
        mainPage.setNewText(PASTETEXT);
        mainPage.setHighlighting(PASTE_HIGHLIGHTING);
        mainPage.setExpiration(PASTE_EXPIRATION);
        mainPage.setName(PASTE_NAME);
        createdPastePage = mainPage.CreateNewPasteBtnClick();
    }

    @Test
    public void compareHighlighting() {
        Assert.assertEquals(createdPastePage.getHighlighting(),PASTE_HIGHLIGHTING);
    }
    @Test
    public void compareTitle() {
        Assert.assertEquals(createdPastePage.getPageTitle().split("-")[0].trim(), PASTE_NAME);
    }
    @Test
    public void compareText() {
        Assert.assertEquals(createdPastePage.getRawPaste(), PASTETEXT);
    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}