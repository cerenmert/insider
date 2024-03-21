package com.useInsider.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class OpenPositions extends BasePage {

    By filteredQaBy = By.cssSelector("span#select2-filter-by-department-container[title='Quality Assurance']");
    By istanbulOnTheDropdownBy = By.id("filter-by-location");

    By listedJobCardBy = By.cssSelector(".position-list-item.col-12.col-lg-4");
    By jobTitleBy = By.cssSelector(".position-title.font-weight-bold");
    By listedQaJobsBy = By.cssSelector(".position-list-item.col-12.col-lg-4 .position-department");
    By listedIstanbulJobsBy = By.cssSelector(".position-list-item.col-12.col-lg-4 .position-location");
    By viewRoleButtonBy = By.cssSelector(".btn.btn-navy.rounded.pt-2.pr-5.pb-2.pl-5");

    public OpenPositions(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean filterByDepartment() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(filteredQaBy));
        return webDriver.findElement(filteredQaBy).isDisplayed();
    }

    public void pageScroll() {
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0,800)");
    }

    public void selectLocationFromTheLocationDropdown() throws InterruptedException {
        Thread.sleep(3000);
        WebElement locationDropdown = webDriver.findElement(istanbulOnTheDropdownBy);
        Select objSelect = new Select(locationDropdown);
        objSelect.selectByIndex(1);
    }

    public boolean checkAllListedJobsAreQaJobs() throws InterruptedException {
        // Wait for render filtered elements in page
        Thread.sleep(3000);
        List<WebElement> allJobs = webDriver.findElements(listedQaJobsBy);
        for (WebElement webElement : allJobs) {
            if (!(webElement.getText().equals("Quality Assurance"))) {
                return false;
            }
        }
        return true;
    }

    public boolean checkAllListedJobsAreInIstanbul() throws InterruptedException {
        // Wait for render filtered elements in page
        Thread.sleep(3000);
        List<WebElement> allJobs = webDriver.findElements(listedIstanbulJobsBy);
        for (WebElement webElement : allJobs) {
            if (!(webElement.getText().equals("Istanbul, Turkey"))) {
                return false;
            }
        }
        return true;
    }

    public WebDriver switchWindow() {
        Set<String> windows = webDriver.getWindowHandles();
        return webDriver.switchTo().window(windows.toArray()[windows.toArray().length - 1].toString());
    }

    public LeverApplicationFormPage checkViewRoleButtonAction(){
        Actions action = new Actions(webDriver);
        action.moveToElement(webDriver.findElement(listedJobCardBy)).perform();
        WebElement viewRoleButton = webDriver.findElement(viewRoleButtonBy);
        viewRoleButton.click();
        return new LeverApplicationFormPage(switchWindow());
    }
    public String getJobTitle() {
        return webDriver.findElement(jobTitleBy).getText();
    }


}
