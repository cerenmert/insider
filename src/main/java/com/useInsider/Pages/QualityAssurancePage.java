package com.useInsider.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QualityAssurancePage extends BasePage {
    public By seeAllQAJobsButtonBy = By.linkText("See all QA jobs");

    public QualityAssurancePage(WebDriver webDriver) {
        super(webDriver);
    }

    public OpenPositionsPage findAllQAJobs() {
        click(seeAllQAJobsButtonBy);
        return new OpenPositionsPage(webDriver);
    }
}
