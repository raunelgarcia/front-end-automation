package pages;

import static org.openqa.selenium.support.PageFactory.initElements;
import static utilities.DriverConfiguration.getDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Constants;
import utilities.DriverConfiguration;
import utilities.FrontEndOperation;
public class Amazon {

    private WebDriver driver;

    @FindBy(id = "twotabsearchtextbox")
    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/chrome_action_bar_search_icon")
    WebElement searchBar;

    @FindBy(id = "a-autoid-0")
    WebElement acceptCookies;

    public Amazon() {
        this.driver = DriverConfiguration.getDriver();
        PageFactory.initElements(
                new AppiumFieldDecorator(driver, Duration.ofSeconds(Constants.LOW_TIMEOUT)), this);
    }

    public void acceptCookies() {
        if (FrontEndOperation.isVisible(acceptCookies)) {
            acceptCookies.click();
        }
    }

    public void searchForProduct() {
        String productName = "Cargador";
        searchBar.sendKeys(productName);
        searchBar.submit();
    }

}
