import com.useInsider.Pages.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class HomePageTest extends BaseTest {
    static final String startUrl = "https://useinsider.com/";

    HomePage homePage;

    @BeforeClass
    public void beforeStart() {
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
