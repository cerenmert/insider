import com.useInsider.Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class HomePageTest extends BaseTest {
    static final String startUrl = "https://useinsider.com/";

    HomePage homePage;

    @BeforeClass
    public void beforeStart() {
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--headless");
//        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        webDriver = new ChromeDriver(options);
        webDriver.manage().window().setSize(new Dimension(1366, 768));

        homePage = new HomePage(webDriver);
    }

    @Test
    public void openHomePage() {
        webDriver.get(startUrl);
    }

    @Test
    public void verifyIsInHomePage() {
        assertEquals(webDriver.getCurrentUrl(), startUrl);
    }

    @Test
    public void acceptCookies() {
        homePage.click(homePage.acceptCookieBy);
    }

    @Test
    public void clickCompanyMenu() {
        homePage.click(homePage.companyNavBarItemBy);
    }

    @Test
    public void clickCareersItemInDropdownMenu() {
        homePage.click(homePage.careersItemInDropdown);
    }
}
