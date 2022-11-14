package waits;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class MyCondition {
    public static ExpectedCondition <Boolean> jQueryAJAXsCompleted() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor)driver).executeScript("return (window.jQuery !=null) && (jQuery.active===0);");
            }
        };
    }

    public static ExpectedCondition<Boolean> changingURL(final String url) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return !driver.getCurrentUrl().equals(url);
            }
        };
    }
}
