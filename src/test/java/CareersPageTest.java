import com.useInsider.Pages.CareersPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CareersPageTest extends BaseTest {
    static final String careersUrl = "https://useinsider.com/careers/";

    CareersPage careersPage;

    @BeforeClass
    public void beforeStart() {
        careersPage = new CareersPage(webDriver);
    }

    @Test
    public void verifyIsInCareersPage() {
        assertEquals(webDriver.getCurrentUrl(), careersUrl);
    }

    @Test
    public void verifyTeamsSectionIsVisible() {
        careersPage.scrollToElementOfMid(careersPage.teamsSectionBy);
        careersPage.isVisible(careersPage.teamsSectionBy);
    }

    @Test
    public void verifyLocationsSectionIsVisible() {
        careersPage.scrollToElementOfMid(careersPage.locationSectionBy);
        careersPage.isVisible(careersPage.locationSectionBy);
    }

    @Test
    public void verifyLifeAtInsiderIsVisible() {
        careersPage.scrollToElementOfMid(careersPage.lifeAtInsiderSectionBy);
        careersPage.isVisible(careersPage.lifeAtInsiderSectionBy);
    }

    @Test
    public void clickSeeAllTeamsButtonInTeamsSection() {
        careersPage.scrollToElementOfEnd(careersPage.seeAllTeamsButtonInTeamsSectionBy);
        careersPage.click(careersPage.seeAllTeamsButtonInTeamsSectionBy);
    }

    @Test
    public void verifyQualityAssuranceTeamIsVisible() {
        careersPage.isVisible(careersPage.qualityAssuranceTeamCardBy);
        careersPage.scrollToElementOfMid(careersPage.qualityAssuranceTeamCardBy);
    }

    @Test
    public void clickQualityAssuranceTeamIsVisible() {
        careersPage.click(careersPage.qualityAssuranceTeamLinkBy);
    }
}
