package pages;

import static org.hamcrest.Matchers.is;
import static org.openqa.selenium.support.PageFactory.initElements;

import helpers.TextTranslation;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Constants;
import utilities.DriverConfiguration;
import utilities.FrontEndOperation;

public class Discord {

  private WebDriver driver;

  @FindBy(className = "login-button-js")
  @AndroidFindBy(
      xpath = "//android.widget.Button[@content-desc=\"Iniciar sesión\"]/android.view.ViewGroup")
  WebElement iniciarSesion;

  @FindBy(id = "uid_7")
  @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"login_login_input\"]")
  WebElement email;

  @FindBy(id = "uid_9")
  @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"login_password_input\"]")
  WebElement password;

  @FindBy(
      xpath =
          "//button[@type='submit' and contains(@class, 'button_b83a05') and contains(@class, 'button_dd4f85')]")
  @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Iniciar sesión\"]")
  WebElement botonIniciarSesion;

  @FindBy(className = "title_d10a58")
  @AndroidFindBy(xpath = "//android.view.View[@text=\"¡Espera! ¿Eres un ser humano?\"]")
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
        textoConfirmacion.getText(),
        is(TextTranslation.get("textoConfirmacion")));
  }
}
