package com.useInsider.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QualityAssuranceCareersPage extends BasePage{

    By seeAllQAJobs = By.linkText("See all QA jobs");

    public QualityAssuranceCareersPage(WebDriver webDriver) {
        super(webDriver);
    }

    public OpenPositions findAllQAJobs() {
        webDriver.findElement(seeAllQAJobs).click();
        return new OpenPositions(webDriver);
    }

}
