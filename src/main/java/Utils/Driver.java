package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class Driver {
    public static WebDriver webDriver;
    public static final Duration WAIT_DURATION = Duration.ofSeconds(30);

    public static void startDriver(String browserName) {
        if (webDriver == null) {
            if (browserName.equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                webDriver = new FirefoxDriver(options);

                System.out.println("Started firefox.");
            } else {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--no-sandbox");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--disable-web-security");
                options.addArguments("--no-proxy-server");
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                webDriver = new ChromeDriver(options);

                System.out.println("Started chrome.");
            }

            webDriver.manage().timeouts().implicitlyWait(WAIT_DURATION);
            webDriver.manage().window().setSize(new Dimension(1366, 768));
        }

    }

    public static void endDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
