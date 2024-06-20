package pages;
import helpers.TextTranslation;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Constants;
import utilities.DriverConfiguration;
import utilities.FrontEndOperation;

import java.time.Duration;

import static org.hamcrest.Matchers.is;
import static org.openqa.selenium.support.PageFactory.initElements;

import utilities.FrontEndOperation;

public class Actividad extends FrontEndOperation {
    private WebDriver driver;

    @FindBy(id = "ue-accept-notice-button")
    WebElement acceptCookies;

    public Actividad() {
        this.driver = DriverConfiguration.getDriver();
        initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(Constants.LOW_TIMEOUT)), this);
    }

    public void acceptCookies() {
        if (isVisible(acceptCookies)) {
            acceptCookies.click();
        }
    }
}
