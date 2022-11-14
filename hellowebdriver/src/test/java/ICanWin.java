import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ICanWin {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com");

        WebElement searchInput = driver.findElement(By.id("postform-text"));
        searchInput.sendKeys("Hello From Web Driver");

        WebElement searchBtn = driver.findElement(By.xpath("//*[@id=\"w0\"]/div[5]/div[1]/div[4]/div/span"));
        searchBtn.click();

        Thread.sleep(500);

        searchBtn = driver.findElement(By.xpath("//li[@class='select2-results__option']"));
        searchBtn.click();

        Thread.sleep(5000);

        driver.quit();
    }
}
