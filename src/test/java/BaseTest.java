import com.useInsider.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    WebDriver webDriver;
    By acceptCookieBy = By.id("wt-cli-accept-all-btn");

    @BeforeMethod
    public void startUp() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        WebDriverManager.chromedriver().setup(); //bonigarcia
        //System.setProperty("webdriver.chrome.driver", "/Users/ceren/Downloads/chromedriver-mac-arm64/chromedriver");
        webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
        webDriver.get("https://useinsider.com/");
        Thread.sleep(2000);
        WebElement acceptCookie = webDriver.findElement(acceptCookieBy);
        acceptCookie.click();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        Utility.captureScreenshot(webDriver, result.getName());
        webDriver.quit();
    }

}
