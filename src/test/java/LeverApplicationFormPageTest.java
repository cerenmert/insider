import com.useInsider.Pages.LeverApplicationFormPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class LeverApplicationFormPageTest extends BaseTest {
    static final String LeverApplicationFormPageUrl = "https://jobs.lever.co";

    LeverApplicationFormPage leverApplicationFormPage;

    @BeforeClass
    public void beforeStart() {
        leverApplicationFormPage = new LeverApplicationFormPage(webDriver);
    }

    @Test
    public void verifyIsInLeverApplicationFormPage() {
        leverApplicationFormPage.switchToLastWindow();
        leverApplicationFormPage.softWaitForPageToLoad();
        assertTrue(webDriver.getCurrentUrl().contains(LeverApplicationFormPageUrl));
    }
}
