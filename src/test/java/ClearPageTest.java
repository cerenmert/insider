import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class ClearPageTest {
    public static WebDriver webDriver;

    @BeforeClass
    public static void setUpDriver() {
        // In v0.1 we'll be sharing the driver between tests in same class
        // Assuming the tests will not be running in parallel.
        // For v1.0 you can improve the model after reading about test-listeners

        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            return;
        }

        driver = DriverManager.createDriver("chrome");
        DriverManager.setDriver(driver);
    }

    @AfterClass
    public static void tearDownDriver() {
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            driver.quit();
            DriverManager.setDriver(null);
        }
    }

    @BeforeMethod
    public void setUp() {
        webDriver = DriverManager.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        //
    }

    @Test
    public void openPage() {
        webDriver.get("http://google.com");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void makeTest() {
        System.out.println(webDriver.getCurrentUrl());
        webDriver.findElement(By.cssSelector("a")).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
