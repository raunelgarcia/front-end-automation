package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Constants;
import utilities.DriverConfiguration;
import utilities.FrontEndOperation;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public class Discord {

  private WebDriver driver;

  @FindBy(className = "login-button-js")
  WebElement iniciarSesion;

  @FindBy(id = "uid_7")
  WebElement email;

  @FindBy(id = "uid_9")
  WebElement password;

  public Discord() {
    this.driver = DriverConfiguration.getDriver();
    initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(Constants.LOW_TIMEOUT)), this);
  }

  public void clickIniciarSesion() {
    iniciarSesion.click();
  }

  public void clickEmail() {
    FrontEndOperation.waitForVisibility(email);
    email.sendKeys("ejemplo@gmail.com");
  }

  public void clickPassword() {
    FrontEndOperation.waitForVisibility(password);
    password.sendKeys("123456");
  }
}
