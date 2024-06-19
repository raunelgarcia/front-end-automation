package pages;

import helpers.TextTranslation;
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

public class Discord {

  private WebDriver driver;

  @FindBy(className = "login-button-js")
  WebElement iniciarSesion;

  @FindBy(id = "uid_7")
  WebElement email;

  @FindBy(id = "uid_9")
  WebElement password;

  @FindBy(
      xpath =
          "//button[@type='submit' and contains(@class, 'button_dc6abe') and contains(@class, 'button_dd4f85')]")
  WebElement botonIniciarSesion;

  @FindBy(className = "title_d10a58")
  WebElement textoConfirmacion;

  public Discord() {
    this.driver = DriverConfiguration.getDriver();
    initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(Constants.LOW_TIMEOUT)), this);
  }

  public void clickIniciarSesion() {
    iniciarSesion.click();
  }

  public void rellenarEmail() {
    FrontEndOperation.waitForVisibility(email);
    email.sendKeys("ejemplo@gmail.com");
  }

  public void rellenarPassword() {
    FrontEndOperation.waitForVisibility(password);
    password.sendKeys("123456");
  }

  public void clickBotonIniciarSesion() {
    FrontEndOperation.clickWhenVisible(botonIniciarSesion);
    FrontEndOperation.waitSeconds(4);
    FrontEndOperation.checkThat(
        "El texto es igual",
        FrontEndOperation.compareTexts(textoConfirmacion, TextTranslation.get("textoConfirmacion")),
        is(true));
  }
}
