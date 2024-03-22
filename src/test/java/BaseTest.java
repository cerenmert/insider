import com.useInsider.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.chainsaw.Main;
import org.junit.jupiter.api.BeforeEach;
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
        WebDriverManager.chromedriver().setup(); //bonigarcia
        Main.main(new String[] { "standalone", "--port", "4445" });
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        //System.setProperty("webdriver.chrome.driver", "/Users/ceren/Downloads/chromedriver-mac-arm64/chromedriver");
        webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
        webDriver.get("https://useinsider.com/");
        Thread.sleep(2000);
        WebElement acceptCookie = webDriver.findElement(acceptCookieBy);
        acceptCookie.click();
    }
    @BeforeEach
    void setupTest() {
        webDriver = WebDriverManager.chromedriver().remoteAddress("http://localhost:4445/wd/hub").create();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        Utility.captureScreenshot(webDriver, result.getName());
        webDriver.quit();
    }

}
