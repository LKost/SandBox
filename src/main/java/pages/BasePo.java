package pages;
import lombok.SneakyThrows;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static seleniumUtils.WebDriverManager.getDriver;


public class BasePo {
    WebDriver driver;

    public BasePo() {
        this.driver = getDriver();
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(name = "q")
    private WebElement search;

    public void typeIntoSearch(String someText) {
        search.sendKeys(someText);
    }

    @SneakyThrows
    public void pressEnter() {
        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.ENTER).build().perform();
    }
}
