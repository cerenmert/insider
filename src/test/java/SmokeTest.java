import com.useInsider.Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class SmokeTest extends BaseTest{

    @Test
    public void test() throws InterruptedException {
        HomePage homePage= new HomePage(webDriver);
        CareersPage careersPage = homePage.goToCareersPage();
        boolean ourLocationSection = careersPage.shouldOurLocationsSectionDisplayed();
        assertTrue(ourLocationSection);
        boolean lifeAtInsiderSection = careersPage.shouldLifeAtInsiderSectionDisplayed();
        assertTrue(lifeAtInsiderSection);
        boolean teamsSection= careersPage.shouldTeamsSectionDisplayed();
        assertTrue(teamsSection);
        String seeAllTeamsButtonText = careersPage.shouldSeeAllTeamsButtonText();
        Assert.assertEquals(seeAllTeamsButtonText, "See all teams");
        String lifeAtInsiderText = careersPage.lifeAtInsiderText();
        Assert.assertEquals(lifeAtInsiderText, "Life at Insider");
        String ourLocationsTitle = careersPage.ourLocationsTitle();
        Assert.assertEquals(ourLocationsTitle, "Our Locations");
        careersPage.shouldClickAllTeamsButton();
        careersPage.pageScroll();
        QualityAssuranceCareersPage qualityAssuranceCareersPage = careersPage.shouldClickQualityAssurance();
        OpenPositions openPositions = qualityAssuranceCareersPage.findAllQAJobs();
        boolean filteredQaDepartment = openPositions.filterByDepartment();
        assertTrue(filteredQaDepartment);
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