package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Constants;
import utilities.DriverConfiguration;
import utilities.FrontEndOperation;

import java.time.Duration;

public class Marca extends FrontEndOperation {
    private WebDriver driver;

    @FindBy(id = "ue-accept-notice-button")
    WebElement acceptCookies;

    @FindBy(partialLinkText = "Noticia que no existe")
    @AndroidFindBy(
            xpath =
                    "(//android.widget.LinearLayout[@resource-id=\"com.iphonedroid.marca:id/portadilla_container\"])[3]")
    WebElement randomNotice;

    @FindBy(id = "buttonYes")
    WebElement ageButton;

    public Marca() {
        this.driver = DriverConfiguration.getDriver();
        PageFactory.initElements(
                new AppiumFieldDecorator(driver, Duration.ofSeconds(Constants.LOW_TIMEOUT)), this);
    }

    public void acceptCookies() {
        if (FrontEndOperation.isVisible(acceptCookies)) {
            acceptCookies.click();
        }
    }

    public void goToNotice() {
        randomNotice.click();
    }

    public void acceptAge() {
        FrontEndOperation.clickWhenVisible(ageButton);
    }

    public boolean isNoticeShow() {
        return FrontEndOperation.isVisible(randomNotice);
    }
}
