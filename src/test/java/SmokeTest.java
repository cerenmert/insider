import com.useInsider.Pages.*;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class SmokeTest extends BaseTest{

    @Test
    public void test() throws InterruptedException {
        HomePage homePage= new HomePage(webDriver);
        CareersPage careersPage = homePage.goToCareersPage();
        assertTrue(careersPage.ourLocationsSectionIsDisplayed());
        assertTrue(careersPage.lifeAtInsiderSectionIsDisplayed());
        assertTrue(careersPage.teamsSectionIsDisplayed());
        assertEquals(careersPage.getSeeAllTeamsButtonText(), "See all teams");
        assertEquals(careersPage.getLifeAtInsiderText(), "Life at Insider");
        assertEquals(careersPage.getOurLocationsTitle(), "Our Locations");
        careersPage.clickAllTeamsButton();
        careersPage.pageScroll();
        QualityAssuranceCareersPage qualityAssuranceCareersPage = careersPage.clickQualityAssurance();
        OpenPositionsPage openPositions = qualityAssuranceCareersPage.findAllQAJobs();
        assertTrue(openPositions.filterByDepartment());
        openPositions.selectLocationFromTheLocationDropdown();
        openPositions.pageScroll();
        String positionTitle = openPositions.getJobTitle();
        assertTrue(openPositions.checkAllListedJobsAreQaJobs());
        assertTrue(openPositions.checkAllListedJobsAreInIstanbul());
        LeverApplicationFormPage leverApplicationFormPage = openPositions.checkViewRoleButtonAction();
        leverApplicationFormPage.checkUrlOfLeverApplicationFormPage();
        leverApplicationFormPage.checkPageTitle(positionTitle);
    }
}