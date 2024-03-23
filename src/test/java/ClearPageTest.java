import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ClearPageTest {
    WebDriver webDriver;

    @BeforeClass
    public void initiliaze() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        webDriver = new ChromeDriver(options);
        webDriver.manage().window().setSize(new Dimension(1366, 768));
    }

    @Test
    public void openPage() {
        webDriver.get("http://google.com");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void makeTest() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(webDriver.getCurrentUrl());
        webDriver.findElement(By.cssSelector("a")).click();
    }

    @AfterClass()
    public void beforeEnd() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
