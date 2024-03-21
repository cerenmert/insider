package com.useInsider.Pages;

import org.openqa.selenium.WebDriver;

public class LeverApplicationFormPage extends BasePage{

    String URL = "https://jobs.lever.co/useinsider/78ddbec0-16bf-4eab-b5a6-04facb993ddc";
    public LeverApplicationFormPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean checkUrlOfLeverApplicationFormPage() {
        return webDriver.getCurrentUrl().equals(URL);
    }

    public boolean checkPageTitle(String jobTitle) {
        String pageTitle = webDriver.getTitle();
        return pageTitle.contains(jobTitle);
    }
}
