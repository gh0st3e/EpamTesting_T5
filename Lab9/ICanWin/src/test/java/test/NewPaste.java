package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.PasteBinPage;


public class NewPaste {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void driverSetup() {
        driver = new ChromeDriver();
    }

    @Test
    public void isNewPateCreated() {
        PasteBinPage pasteBinPage = new PasteBinPage(driver);
        pasteBinPage.OpenPage();
        pasteBinPage.setText("Hello from WebDriver");
        pasteBinPage.setExpiration("10 Minutes");
        pasteBinPage.setName("helloweb");
        String oldUrl = driver.getCurrentUrl();
        pasteBinPage.CreateNewPasteBtnClick();
        Assert.assertNotEquals(oldUrl, driver.getCurrentUrl());
    }



    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}
