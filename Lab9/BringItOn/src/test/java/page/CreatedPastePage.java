package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatedPastePage {
    private final WebDriver driver;
    @FindBy(xpath = "//div[contains(@class, 'top-buttons')]/div[contains(@class, 'right')]/a[contains(text(), 'raw')]")
    private WebElement rawLink;

    @FindBy(xpath = "//div[contains(@class,'highlighted-code')]/descendant::a")
    private WebElement resultHighlighting;

    @FindBy(xpath = "//textarea[contains(@class,'js-paste-raw')]")
    private WebElement resultRawPaste;

    @FindBy(xpath = "//pre")
    private WebElement rawPaste;

    public CreatedPastePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getHighlighting() {
        return resultHighlighting.getText();
    }

    public String getRawPaste() {
        rawLink.click();
        String paste = rawPaste.getText().trim();
        driver.navigate().back();
        return paste;
    }
}