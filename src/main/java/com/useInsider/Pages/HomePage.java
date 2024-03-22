package com.useInsider.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage extends BasePage {
    By companyNavBarItemBy = By.cssSelector(".navbar-nav > li:nth-of-type(6)");
    By careerDropdownMenuItemBy = By.cssSelector(".new-menu-dropdown-layout-6-mid-container > a:nth-of-type(2)");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public CareersPage goToCareersPage() throws InterruptedException {
        click(companyNavBarItemBy);
        click(careerDropdownMenuItemBy);
        return new CareersPage(webDriver);
    }

}
