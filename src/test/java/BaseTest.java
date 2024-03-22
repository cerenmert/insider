import com.useInsider.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.manager.SeleniumManagerOutput;
import org.openqa.selenium.remote.service.DriverFinder;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Path;
import java.util.Objects;


public class BaseTest {
    WebDriver webDriver;
    By acceptCookieBy = By.id("wt-cli-accept-all-btn");

    public Path getFirefoxLocation() {
        FirefoxOptions options = new FirefoxOptions();
        options.setBrowserVersion("stable");
        SeleniumManagerOutput.Result output = DriverFinder.getPath(GeckoDriverService.createDefaultService(), options);
        return Path.of(output.getBrowserPath());
    }
    public void buildWebDriver(String browser) {
        if (Objects.equals(browser, "chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            //System.setProperty("webdriver.chrome.driver", "/Users/ceren/Downloads/chromedriver-mac-arm64/chromedriver");
            webDriver = new ChromeDriver(options);
        } else if (Objects.equals(browser, "safari")) {
            WebDriverManager.safaridriver().setup();
            SafariOptions options = new SafariOptions();
            webDriver = new SafariDriver(options);
        } else if (Objects.equals(browser, "firefox")){
            FirefoxOptions options = new FirefoxOptions();
            options.setBinary(getFirefoxLocation());
            webDriver = new FirefoxDriver(options);
        }
    }

    @BeforeMethod
    public void startUp(){
        buildWebDriver("chrome");
        webDriver.manage().window().maximize();
        webDriver.get("https://useinsider.com/");
        WebElement acceptCookie = webDriver.findElement(acceptCookieBy);
        acceptCookie.click();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        Utility.captureScreenshot(webDriver, result.getName());
        webDriver.quit();
    }

}
