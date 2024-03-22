package com.useInsider.Pages;

import com.useInsider.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;


public class BasePage extends WebDriverHelper {

    public BasePage(WebDriver webDriver) {
        super(webDriver);
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