package com.useInsider.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class CareersPage extends BasePage {
    By teamsSectionBy = By.id("career-find-our-calling");
    By seeAllTeamsButtonBy = By.cssSelector(".btn.loadmore");
    By lifeAtInsiderSectionBy = By.cssSelector(".elementor-section.elementor-top-section.elementor-element.elementor-element-a8e7b90.elementor-section-full_width.elementor-section-height-default.elementor-section-height-default");
    By lifeAtInsiderTextBy = By.cssSelector("[data-id='21cea83'] .elementor-heading-title");
    By ourLocationsSectionBy = By.cssSelector(".elementor-section.elementor-top-section.elementor-element.elementor-element-8ab30be.elementor-section-full_width.elementor-section-height-default.elementor-section-height-default");
    By ourLocationsTitleBy = By.cssSelector(".category-title-media.ml-0");
    By qualityAssuranceBy = By.cssSelector("div:nth-of-type(12) > .job-title.mt-0.mt-lg-2.mt-xl-5 > a");

    public CareersPage(WebDriver webDriver) {
       super(webDriver);
    }
    public void pageScroll(){
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0,2200)");
    }

    public boolean shouldTeamsSectionDisplayed() {
        return webDriver.findElement(teamsSectionBy).isDisplayed();
    }
    public boolean shouldLifeAtInsiderSectionDisplayed() {
        return webDriver.findElement(lifeAtInsiderSectionBy).isDisplayed();
    }
    public boolean shouldOurLocationsSectionDisplayed() {
        return webDriver.findElement(ourLocationsSectionBy).isDisplayed();
    }
    public String shouldSeeAllTeamsButtonText() {
        return webDriver.findElement(seeAllTeamsButtonBy).getText();
    }
    public String lifeAtInsiderText() {
        return webDriver.findElement(lifeAtInsiderTextBy).getText();
    }
    public String ourLocationsTitle() {
        return webDriver.findElement(ourLocationsTitleBy).getText();
    }
    public void shouldClickAllTeamsButton() {
        WebElement element = webDriver.findElement(seeAllTeamsButtonBy);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).click().build().perform();
    }

    public QualityAssuranceCareersPage shouldClickQualityAssurance() {
        //How To Handle NoSuchElementException in Selenium?
        waitUntilHTMLElementLoadIntoTheDOM(qualityAssuranceBy);
        webDriver.findElement(qualityAssuranceBy).click();
        return new QualityAssuranceCareersPage(webDriver);
    }
}
