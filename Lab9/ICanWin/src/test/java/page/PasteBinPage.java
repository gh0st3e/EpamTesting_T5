package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.MyCondition;

import java.time.Duration;
import java.util.List;

public class PasteBinPage {
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private WebDriver driver;

    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement textField;

    @FindBy(xpath = "//span[@data-select2-id='1']")
    private WebElement selectHighlighting;

    @FindBy(xpath = "//select[@id='postform-expiration']/following::span[1]")
    private WebElement selectExpiration;

    @FindAll({ @FindBy(xpath = "//li[@class='select2-results__option']") })
    private List<WebElement> expirationOptions;

    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement pasteName;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement newPasteBtn;


    public PasteBinPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public PasteBinPage OpenPage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 30).until(MyCondition.jQueryAJAXsCompleted());
        return this;
    }

    public void setText(String name) {
        textField.sendKeys(name);
    }

    public void setSelectOption(WebElement select, String optionValue) {
        select.click();
        for (WebElement selectOption : expirationOptions) {
            new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(selectOption));
            if (selectOption.getText().trim().equals(optionValue.trim())) {
                selectOption.click();
                new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOf(selectOption));
                break;
            }
        }
    }

    public void setExpiration(String expiration) {
        setSelectOption(selectExpiration, expiration);
    }

    public void setName(String name) {
        pasteName.sendKeys(name);
    }

    public void CreateNewPasteBtnClick() {
        newPasteBtn.click();
        new WebDriverWait(driver, 30).until(MyCondition.changingURL(driver.getCurrentUrl()));
    }
}
