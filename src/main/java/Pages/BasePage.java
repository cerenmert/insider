package Pages;

import Utils.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage extends Driver {
    public BasePage() {
        PageFactory.initElements(webDriver, this);
    }

    public void goTo(String url) {
        webDriver.get(url);
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public void click(By byElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, WAIT_DURATION);
        wait.until(ExpectedConditions.elementToBeClickable(byElement)).click();
    }

    public void isVisible(By byElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, WAIT_DURATION);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byElement)).isDisplayed();
    }

    public JavascriptExecutor javascriptExecutor() {
        return (JavascriptExecutor) webDriver;
    }

    public void scrollToElementOfMid(By selector) {
        javascriptExecutor()
                .executeScript("arguments[0].scrollIntoView({behavior: \"instant\", block: \"center\", inline: \"nearest\"});", webDriver.findElement(selector));
    }

    public void scrollToElementOfEnd(By selector) {
        javascriptExecutor()
                .executeScript("arguments[0].scrollIntoView({behavior: \"instant\", block: \"end\", inline: \"nearest\"});", webDriver.findElement(selector));
    }

    public void selectOptionInSelect2(By selector, String text) {
        javascriptExecutor()
                .executeScript("$(arguments[0]).val(arguments[1]).trigger('change')", webDriver.findElement(selector), text);
    }

    public String getTextOfElement(By selector) {
        return webDriver.findElement(selector).getText();
    }

    public void waitForTextChange(By selector, String text) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(webDriver.findElement(selector), text)));
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

    public static void captureScreenshot(String methodName) throws IOException {
        File ss = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(ss, new File("screenshots/" + methodName + ".png"));
    }
}
