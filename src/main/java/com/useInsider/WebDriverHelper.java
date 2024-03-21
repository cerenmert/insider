package com.useInsider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverHelper {

    protected WebDriver webDriver;

    public WebDriverHelper(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void isDisplayed(By byElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(byElement)).isDisplayed();
    }

    public void waitForLoad(By byElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
    }

    public void waitUntilHTMLElementLoadIntoTheDOM(By byElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(byElement));
    }

}
