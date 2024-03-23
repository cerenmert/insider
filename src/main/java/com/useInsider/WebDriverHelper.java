package com.useInsider;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class WebDriverHelper {

    protected WebDriver webDriver;

    public WebDriverHelper(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean isVisible(By byElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(byElement)).isDisplayed();
    }

    public void click(By byElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(byElement)).click();
    }

    public void selectOptionInSelect2(By selector, String text) {
        javascriptExecutor(this.webDriver)
                .executeScript("$(arguments[0]).val(arguments[1]).trigger('change')", this.webDriver.findElement(selector), text);
    }

    public String getTextOfElement(By selector) {
        return this.webDriver.findElement(selector).getText();
    }

    public void waitForTextChange(By selector, String text) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(this.webDriver.findElement(selector), text)));
    }

    public boolean checkAllElementTexts(By selector, String text) {
        List<WebElement> allJobs = webDriver.findElements(selector);
        for (WebElement webElement : allJobs) {
            if (!(webElement.getText().equals(text))) {
                return false;
            }
        }

        return true;
    }

    public void hoverToElement(By selector) {
        Actions action = new Actions(webDriver);
        action.moveToElement(webDriver.findElement(selector)).perform();
    }

    public void switchToLastWindow() {
        Set<String> windows = webDriver.getWindowHandles();
        webDriver.switchTo().window(windows.toArray()[windows.toArray().length - 1].toString());
    }

    public void softWaitForPageToLoad() {
        new WebDriverWait(webDriver, Duration.ofSeconds(60)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").toString().matches("interactive|complete"));
    }

    public void waitForLoad(By byElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
    }

    public String getText(By byElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(byElement)).getText();
    }

    public void waitUntilHTMLElementLoadIntoTheDOM(By byElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(byElement));
    }

    public JavascriptExecutor javascriptExecutor(WebDriver webDriver) {
        return (JavascriptExecutor) webDriver;
    }

    public void scrollToElementOfMid(By selector) {
        javascriptExecutor(this.webDriver)
                .executeScript("arguments[0].scrollIntoView({behavior: \"instant\", block: \"center\", inline: \"nearest\"});", this.webDriver.findElement(selector));
    }

    public void scrollToElementOfEnd(By selector) {
        javascriptExecutor(this.webDriver)
                .executeScript("arguments[0].scrollIntoView({behavior: \"instant\", block: \"end\", inline: \"nearest\"});", this.webDriver.findElement(selector));
    }

    public void scrollToOfSet(WebDriver webDriver, int x, int y) {
        javascriptExecutor(this.webDriver).executeScript("window.scrollTo(" + x + "," + y + ");");
    }

    public void scrollToElement(WebDriver webDriver, WebElement webElement) {
        javascriptExecutor(this.webDriver).executeScript("window.scrollTo(" + webElement.getLocation().x + "," + webElement.getLocation().y + ");");
    }

    public void moveAndClickElement(By selector) throws InterruptedException {
        WebElement element = webDriver.findElement(selector);
        Actions actions = new Actions(webDriver);
        try {
            scrollToOfSet(webDriver, element.getLocation().x, element.getLocation().y);
            Thread.sleep(500);
            actions.moveToElement(element).build().perform();
        } catch (MoveTargetOutOfBoundsException me) {
            scrollToElement(webDriver, element);
            Thread.sleep(500);
            actions.moveByOffset(element.getLocation().x, element.getLocation().y).build().perform();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
