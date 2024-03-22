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
}