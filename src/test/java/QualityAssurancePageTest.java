import com.useInsider.Pages.QualityAssurancePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class QualityAssurancePageTest extends BaseTest {
    static final String qualityAssuranceUrl = "https://useinsider.com/careers/quality-assurance/";

    QualityAssurancePage qualityAssurancePage;

    @BeforeClass
    public void beforeStart() {
        qualityAssurancePage = new QualityAssurancePage(webDriver);
    }

    @Test
    public void verifyIsInQualityAssurancePage() {
        assertEquals(webDriver.getCurrentUrl(), qualityAssuranceUrl);
    }

    @Test
    public void clickSeeAllQAJobsButton() {
        qualityAssurancePage.click(qualityAssurancePage.seeAllQAJobsButtonBy);
    }
}
