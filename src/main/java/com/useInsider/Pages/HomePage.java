package com.useInsider.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public By acceptCookieBy = By.id("wt-cli-accept-all-btn");
    public By companyNavBarItemBy = By.cssSelector("#navbarNavDropdown li.nav-item:nth-of-type(6) a");

    public By careersItemInDropdown = By.cssSelector("#navbarNavDropdown .new-menu-dropdown-layout-6.show .new-menu-dropdown-layout-6-mid-container a.dropdown-sub:nth-of-type(2)");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
}
