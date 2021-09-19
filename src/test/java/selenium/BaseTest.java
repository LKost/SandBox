package selenium;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static seleniumUtils.WebDriverManager.getDriver;


public class BaseTest {

    @BeforeMethod
    public void beforMethod(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        getDriver().get("http://www.google.com");
    }

    @AfterMethod
    public void afterMethod() {
        getDriver().close();
    }
}
