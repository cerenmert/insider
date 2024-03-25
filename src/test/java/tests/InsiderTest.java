package tests;

import Pages.*;
import Utils.Driver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners({ Utils.TestListener.class })
public class InsiderTest {
    BasePage basePage;
    HomePage homePage;
    CareersPage careersPage;
    QualityAssurancePage qualityAssurancePage;
    OpenPositionsPage openPositionsPage;
    LeverApplicationFormPage leverApplicationFormPage;

    @BeforeClass(alwaysRun = true)
    @Parameters("browserName")
    public void setUp(@Optional("chrome") String browserName) {
        String browserFromEnv = System.getenv("browserName");

        Driver.startDriver(browserFromEnv != null ? browserFromEnv : browserName);
        basePage = new BasePage();
        homePage = new HomePage();
        careersPage = new CareersPage();
        qualityAssurancePage = new QualityAssurancePage();
        openPositionsPage = new OpenPositionsPage();
        leverApplicationFormPage = new LeverApplicationFormPage();
    }

    @Test(priority = 1)
    public void goToHomePage() {
        basePage.goTo(homePage.url);
    }

    @Test(priority = 2)
    public void verifyIsInHomePage() {
        Assert.assertEquals(basePage.getCurrentUrl(), homePage.url);
    }

    @Test(priority = 3)
    public void acceptCookies() {
        basePage.click(homePage.acceptCookieBy);
    }

    @Test(priority = 4)
    public void clickCompanyMenu() {
        basePage.click(homePage.companyNavBarItemBy);
    }

    @Test(priority = 5)
    public void clickCareersItemInDropdownMenu() {
        basePage.click(homePage.careersItemInDropdown);
    }

    @Test(priority = 6)
    public void verifyIsInCareersPage() {
        Assert.assertEquals(basePage.getCurrentUrl(), careersPage.url);
    }

    @Test(priority = 7)
    public void verifyTeamsSectionIsVisible() {
        basePage.scrollToElementOfMid(careersPage.teamsSectionBy);
        basePage.isVisible(careersPage.teamsSectionBy);
    }

    @Test(priority = 8)
    public void verifyLocationsSectionIsVisible() {
        basePage.scrollToElementOfMid(careersPage.locationSectionBy);
        basePage.isVisible(careersPage.locationSectionBy);
    }

    @Test(priority = 9)
    public void verifyLifeAtInsiderIsVisible() {
        basePage.scrollToElementOfMid(careersPage.lifeAtInsiderSectionBy);
        basePage.isVisible(careersPage.lifeAtInsiderSectionBy);
    }

    @Test(priority = 10)
    public void clickSeeAllTeamsButtonInTeamsSection() {
        basePage.scrollToElementOfEnd(careersPage.seeAllTeamsButtonInTeamsSectionBy);
        basePage.click(careersPage.seeAllTeamsButtonInTeamsSectionBy);
    }

    @Test(priority = 11)
    public void verifyQualityAssuranceTeamIsVisible() {
        basePage.isVisible(careersPage.qualityAssuranceTeamCardBy);
        basePage.scrollToElementOfMid(careersPage.qualityAssuranceTeamCardBy);
    }

    @Test(priority = 12)
    public void clickQualityAssuranceTeamIsVisible() {
        basePage.click(careersPage.qualityAssuranceTeamLinkBy);
    }

    @Test(priority = 13)
    public void verifyIsInQualityAssurancePage() {
        Assert.assertEquals(basePage.getCurrentUrl(), qualityAssurancePage.url);
    }

    @Test(priority = 14)
    public void clickSeeAllQAJobsButton() {
        basePage.click(qualityAssurancePage.seeAllQAJobsButtonBy);
    }

    @Test(priority = 15)
    public void verifyIsInOpenPositionsPage() {
        Assert.assertTrue(basePage.getCurrentUrl().contains(openPositionsPage.url));
    }

    @Test(priority = 16)
    public void verifyQADepartmentIsSelected() {
        basePage.isVisible(openPositionsPage.filteredQaBy);
    }

    @Test(priority = 17)
    public void selectIstanbulLocationInFilter() {
        basePage.selectOptionInSelect2(openPositionsPage.filterByLocationSelectBoxBy, "Istanbul, Turkey");

        // I'm selecting qa and istanbul filters then checking the result
        // Scroll to resultCount element in the page because it does not render without scroll
        basePage.scrollToElementOfMid(openPositionsPage.resultCountBy);
        // Waiting for first render of total result count
        basePage.isVisible(openPositionsPage.totalResultsCountTextBy);
        // Getting first value of the total result count (it should be 172 in the first load)
        String beforeCount = basePage.getTextOfElement(openPositionsPage.totalResultsCountTextBy);
        // Waiting for change text of total result count (it should be 4 after re-render items by filters)
        basePage.waitForTextChange(openPositionsPage.totalResultsCountTextBy, beforeCount);
    }

    @Test(priority = 18)
    public void verifyLocationIstanbulIsSelected() {
        basePage.isVisible(openPositionsPage.locationFilterBy);
    }

    @Test(priority = 19)
    public void verifyAllListedJobsDepartmentIsQA() {
        Assert.assertTrue(basePage.checkAllElementTexts(openPositionsPage.jobItemDepartmentBy, "Quality Assurance"));
    }

    @Test(priority = 20)
    public void verifyAllListedJobsLocationIsIstanbul() {
        Assert.assertTrue(basePage.checkAllElementTexts(openPositionsPage.jobItemLocationBy, "Istanbul, Turkey"));
    }

    @Test(priority = 21)
    public void clickListedJobViewRoleButton() {
        basePage.hoverToElement(openPositionsPage.jobItemBy);
        basePage.click(openPositionsPage.jobItemViewRoleButtonBy);
    }

    @Test(priority = 22)
    public void verifyIsInLeverApplicationFormPage() {
        basePage.switchToLastWindow();
        basePage.softWaitForPageToLoad();
        Assert.assertTrue(basePage.getCurrentUrl().contains(leverApplicationFormPage.url));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        Driver.endDriver();
    }
}
