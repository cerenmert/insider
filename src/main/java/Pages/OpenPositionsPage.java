package Pages;

import org.openqa.selenium.By;

public class OpenPositionsPage extends BasePage {
    public String url = "https://useinsider.com/careers/open-positions/";
    public By filteredQaBy = By.cssSelector("#select2-filter-by-department-container[title='Quality Assurance']");
    public By filterByLocationSelectBoxBy = By.id("filter-by-location");
    public By locationFilterBy = By.cssSelector("#select2-filter-by-location-container");
    public By resultCountBy = By.cssSelector("#resultCounter");
    public By totalResultsCountTextBy = By.cssSelector("#resultCounter .totalResult");
    public By jobItemDepartmentBy = By.cssSelector(".position-list-item .position-department");
    public By jobItemLocationBy = By.cssSelector(".position-list-item .position-location");
    public By jobItemBy = By.cssSelector(".position-list-item");
    public By jobItemViewRoleButtonBy = By.cssSelector(".position-list-item a.btn");
}
