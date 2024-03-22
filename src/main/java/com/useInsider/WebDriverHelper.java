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

public class WebDriverHelper {

    protected WebDriver webDriver;

    public WebDriverHelper(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean isDisplayed(By byElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(byElement)).isDisplayed();
    }
    public void click(By byElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(byElement)).click();
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
