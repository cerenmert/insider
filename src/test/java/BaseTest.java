import com.useInsider.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static io.github.bonigarcia.wdm.WebDriverManager.isDockerAvailable;


public class BaseTest {
    WebDriver webDriver;
    By acceptCookieBy = By.id("wt-cli-accept-all-btn");
    WebDriverManager wdm = WebDriverManager.chromedriver().browserInDocker().dockerDefaultArgs("--disable-gpu,--no-sandbox").browserVersion("dev");

    @BeforeMethod
    public void startUp() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "/Users/ceren/Downloads/chromedriver-mac-arm64/chromedriver");
        webDriver.manage().window().maximize();
        webDriver.get("https://useinsider.com/");
        Thread.sleep(2000);
        WebElement acceptCookie = webDriver.findElement(acceptCookieBy);
        acceptCookie.click();
    }
    @BeforeEach
    void setupTest() {
        Assert.assertTrue(isDockerAvailable());
        webDriver = wdm.create();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        Utility.captureScreenshot(webDriver, result.getName());
        webDriver.quit();
    }

}
