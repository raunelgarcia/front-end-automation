package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Constants;
import utilities.DriverConfiguration;
import utilities.FrontEndOperation;

import java.time.Duration;

public class Ikea extends FrontEndOperation {
    private static WebDriver driver;

    @FindBy(id = "onetrust-accept-btn-handler")
    WebElement acceptCookies;

    public Ikea() {
        this.driver = DriverConfiguration.getDriver();
        PageFactory.initElements(
                new AppiumFieldDecorator(driver, Duration.ofSeconds(Constants.LOW_TIMEOUT)), this);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void acceptCookies() {
        clickWhenVisible(acceptCookies);
    }

    public void clickMuebles() {
        WebElement muebles = driver.findElement(new By.ByClassName("b1cw4fo1"));
        waitSeconds(3);
        clickWhenVisible(muebles);
    }

    public void addToCart() {
        WebElement addToCart = driver.findElement(new By.ByClassName("pip-buy-module__buy-button-container"));
        clickWhenVisible(addToCart);
    }
}