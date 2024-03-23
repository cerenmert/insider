package com.useInsider.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CareersPage extends BasePage {
    JavascriptExecutor js = (JavascriptExecutor) webDriver;
    public By teamsSectionBy = By.id("career-find-our-calling");
    public By locationSectionBy = By.id("career-our-location");
    public By lifeAtInsiderSectionBy = By.cssSelector("section[data-id=a8e7b90]"); // This section has not any id
    public By seeAllTeamsButtonInTeamsSectionBy = By.cssSelector("#career-find-our-calling a.btn.loadmore");
    public By qualityAssuranceTeamCardBy = By.cssSelector("#career-find-our-calling .job-item:nth-of-type(12)");
    public By qualityAssuranceTeamLinkBy = By.cssSelector("#career-find-our-calling .job-item:nth-of-type(12) a");

    By seeAllTeamsButtonBy = By.cssSelector(".btn.loadmore");
    By lifeAtInsiderTextBy = By.cssSelector("[data-id='21cea83'] .elementor-heading-title");
    By ourLocationsSectionBy = By.cssSelector(".elementor-section.elementor-top-section.elementor-element.elementor-element-8ab30be.elementor-section-full_width.elementor-section-height-default.elementor-section-height-default");
    By ourLocationsTitleBy = By.cssSelector(".category-title-media.ml-0");
    By qualityAssuranceBy = By.cssSelector("div:nth-of-type(12) > .job-title.mt-0.mt-lg-2.mt-xl-5 > a");

    public CareersPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void pageScroll() {
        js.executeScript("window.scrollBy(0,2200)");
    }
    public boolean teamsSectionIsDisplayed() {
        return isVisible(teamsSectionBy);
    }

    public boolean lifeAtInsiderSectionIsDisplayed() {
        return isVisible(lifeAtInsiderSectionBy);
    }

    public boolean ourLocationsSectionIsDisplayed() {
        return isVisible(ourLocationsSectionBy);
    }

    public String getSeeAllTeamsButtonText() {
        return getText(seeAllTeamsButtonBy);
    }

    public String getLifeAtInsiderText() {
        return getText(lifeAtInsiderTextBy);
    }

    public String getOurLocationsTitle() {
        return getText(ourLocationsTitleBy);
    }

    public void clickAllTeamsButton() {
        WebElement element = webDriver.findElement(seeAllTeamsButtonBy);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).click().build().perform();
    }
    public QualityAssurancePage clickQualityAssurance() {
        waitUntilHTMLElementLoadIntoTheDOM(qualityAssuranceBy);
        click(qualityAssuranceBy);
        return new QualityAssurancePage(webDriver);
    }
}
