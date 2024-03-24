package Pages;

import org.openqa.selenium.By;

public class CareersPage extends BasePage {
    public String url = "https://useinsider.com/careers/";
    public By teamsSectionBy = By.id("career-find-our-calling");
    public By locationSectionBy = By.id("career-our-location");
    public By lifeAtInsiderSectionBy = By.cssSelector("section[data-id=a8e7b90]"); // This section has not any id
    public By seeAllTeamsButtonInTeamsSectionBy = By.cssSelector("#career-find-our-calling a.btn.loadmore");
    public By qualityAssuranceTeamCardBy = By.cssSelector("#career-find-our-calling .job-item:nth-of-type(12)");
    public By qualityAssuranceTeamLinkBy = By.cssSelector("#career-find-our-calling .job-item:nth-of-type(12) a");
}
