package seleniumUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static seleniumUtils.WebDriverManager.getDriver;

public class WaitManager {
    public static void waitForPageLoad() {
        Function<WebDriver, Boolean> loadCondition =
                x -> ((JavascriptExecutor) getDriver()).executeScript("return document.readyState").equals(
                        "complete");
        new WebDriverWait(getDriver(), MILLISECONDS.toSeconds(50), 200).until(loadCondition);
    }

    public static void wait2(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println();
        }
    }
}
