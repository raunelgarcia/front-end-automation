package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Constants;
import utilities.DriverConfiguration;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;
import static utilities.FrontEndOperation.isVisible;

public class Actividad2 {

    private WebDriver driver;

    @AndroidFindBy(id = "com.google.android.dialer:id/tab_contacts")
    WebElement contactos;

    public Actividad2() {
        this.driver = DriverConfiguration.getDriver();
        initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(Constants.LOW_TIMEOUT)), this);
    }

    public void clickContactos() {
        if (isVisible(contactos)) {
            contactos.click();
        }
    }
}
