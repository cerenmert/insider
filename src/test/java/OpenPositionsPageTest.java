import com.useInsider.Pages.OpenPositionsPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class OpenPositionsPageTest extends BaseTest {
    static final String openPositionsPageUrl = "https://useinsider.com/careers/open-positions/";

    OpenPositionsPage openPositionsPage;

    @BeforeClass
    public void beforeStart() {
        openPositionsPage = new OpenPositionsPage(webDriver);
    }

    @Test
    public void verifyIsInOpenPositionsPage() {
        assertTrue(webDriver.getCurrentUrl().contains(openPositionsPageUrl));
    }

    @Test
    public void verifyQADepartmentIsSelected() {
        openPositionsPage.isVisible(openPositionsPage.filteredQaBy);
    }

    @Test
    public void selectIstanbulLocationInFilter() {
        openPositionsPage.selectOptionInSelect2(openPositionsPage.filterByLocationSelectBoxBy, "Istanbul, Turkey");

        // I'm selecting qa and istanbul filters then checking the result
        // Scroll to result in the page because it do not render without scroll
        openPositionsPage.scrollToElementOfMid(openPositionsPage.resultCountBy);
        // Waiting for first render of total result count
        openPositionsPage.isVisible(openPositionsPage.totalResultsCountTextBy);
        // Getting first value of the total result count (it should be 172 in the first load)
        String beforeCount = openPositionsPage.getTextOfElement(openPositionsPage.totalResultsCountTextBy);
        // Waiting for change text of total result count (it should be 4 after re-render items by filters)
        openPositionsPage.waitForTextChange(openPositionsPage.totalResultsCountTextBy, beforeCount);
    }

    @Test
    public void verifyLocationIstanbulIsSelected() {
        openPositionsPage.isVisible(openPositionsPage.locationFilterBy);
    }

    @Test
    public void verifyAllListedJobsDepartmentIsQA() {
        assertTrue(openPositionsPage.checkAllElementTexts(openPositionsPage.jobItemDepartmentBy, "Quality Assurance"));
    }

    @Test
    public void verifyAllListedJobsLocationIsIstanbul() {
        assertTrue(openPositionsPage.checkAllElementTexts(openPositionsPage.jobItemLocationBy, "Istanbul, Turkey"));
    }

    @Test
    public void clickListedJobViewRoleButton() {
        openPositionsPage.hoverToElement(openPositionsPage.jobItemBy);
        openPositionsPage.click(openPositionsPage.jobItemViewRoleButtonBy);
    }
}
