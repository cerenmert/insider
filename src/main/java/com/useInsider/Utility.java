package com.useInsider;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.WebDriver;

public class Utility
{
    public static void captureScreenshot(WebDriver webdriver, String failTestName)
    {

        try
        {
            TakesScreenshot ts=(TakesScreenshot)webdriver;

            File source=ts.getScreenshotAs(OutputType.FILE);

            FileHandler.copy(source, new File("/Users/ceren/IdeaProjects/insiderbootcampproject-cerenmert/screenshots/" + "fail" + failTestName + ".png"));

            System.out.println("Screenshot is taken");
        }
        catch (Exception e)
        {

            System.out.println("Exception while taking screenshot "+e.getMessage());
        }
    }
}
