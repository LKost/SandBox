package seleniumUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.concurrent.TimeUnit;

import static java.util.Objects.isNull;

public class WebDriverManager {

    private static final ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    private WebDriverManager() {
    }

    public static WebDriver getDriver() {
        if (isNull(driverPool.get())) {
            driverPool.set(Driver.getInstance());
        }
        return driverPool.get();
    }

    public static class Driver {
        private static WebDriver getInstance() {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            ChromeDriver chrome = new ChromeDriver(options());
            chrome.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            chrome.manage().window().maximize();
            return chrome;
        }

        private static ChromeOptions options() {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            return chromeOptions;
        }
    }
}

