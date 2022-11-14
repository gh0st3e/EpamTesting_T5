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

public class NewPastePage {
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private final WebDriver driver;

    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement newText;

    @FindBy(xpath = "//select[@id='postform-format']/following::span[1]")
    private WebElement selectHighlighting;

    @FindBy(xpath = "//select[@id='postform-expiration']/following::span[1]")
    private WebElement selectExpiration;

    @FindAll({ @FindBy(xpath = "//li[contains(@class,'select2-results__option')]") })
    private List<WebElement> activeSelect2Options;

    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement pasteName;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement newPasteButton;

    public NewPastePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public NewPastePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 30).until(MyCondition.jQueryAJAXsCompleted());
        return this;
    }

    public void setNewText(String name) {
        newText.sendKeys(name);
    }

    public void setSelectOption(WebElement select, String optionValue) {
        select.click();
        for (WebElement selectOption : activeSelect2Options) {
            new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(selectOption));
            if (selectOption.getText().trim().equals(optionValue.trim())) {
                selectOption.click();
                new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOf(selectOption));
                break;
            }
        }
    }

    public void setHighlighting(String highlighting) {
        setSelectOption(selectHighlighting, highlighting);
    }

    public void setExpiration(String expiration) {
        setSelectOption(selectExpiration, expiration);
    }

    public void setName(String name) {
        pasteName.sendKeys(name);
    }

    public CreatedPastePage CreateNewPasteBtnClick() {
        newPasteButton.click();
        new WebDriverWait(driver, 30).until(MyCondition.changingURL(driver.getCurrentUrl()));
        return new CreatedPastePage(driver);
    }
}