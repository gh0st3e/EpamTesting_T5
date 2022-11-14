import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HelloWebDriver {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://yandex.by");

        WebElement searchInput = driver.findElement(By.id("text"));
        searchInput.sendKeys("selenium java");

        WebElement searchBtn = driver.findElement(By.xpath("/html/body/main/div[2]/form/div/button"));
        searchBtn.click();

        Thread.sleep(2000);
        driver.quit();
    }
}
