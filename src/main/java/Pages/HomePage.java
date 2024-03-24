package Pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    public String url = "https://useinsider.com/";
    public By acceptCookieBy = By.id("wt-cli-accept-all-btn");
    public By companyNavBarItemBy = By.cssSelector("#navbarNavDropdown li.nav-item:nth-of-type(6) a");
    public By careersItemInDropdown = By.cssSelector("#navbarNavDropdown .new-menu-dropdown-layout-6.show .new-menu-dropdown-layout-6-mid-container a.dropdown-sub:nth-of-type(2)");
}
