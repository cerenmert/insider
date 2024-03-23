import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Objects;


public class BaseTest {
    public static WebDriver webDriver;

    public void buildWebDriver(String browser) {
        if (Objects.equals(browser, "firefox")) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            webDriver = new ChromeDriver(options);
        }
    }

    @BeforeSuite
    public void startUp() {
        buildWebDriver("firefox");
        webDriver.manage().window().setSize(new Dimension(1366, 768));
    }

    @AfterSuite
    public void finish() {
        webDriver.quit();
    }
}
