package pages;

import static org.hamcrest.Matchers.is;
import static org.openqa.selenium.support.PageFactory.initElements;
import static utilities.DriverConfiguration.getDriver;

import helpers.TextTranslation;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Constants;
import utilities.DriverConfiguration;
import utilities.FrontEndOperation;
import utilities.enums.Direction;

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

  @FindBy(className = "ue-c-cover-content__link")
  @AndroidFindBy(id = "com.iphonedroid.marca:id/ue_cms_list_item_text_container")
  WebElement noticia;

  @FindBy(xpath = "//a[@title='Noticias del Leganés']")
  WebElement leganesButton;

  @FindBy(xpath = "//a[text()='Plantilla']")
  WebElement plantillaButton;

  @FindBy(linkText = "Javier Avilés")
  WebElement playerNameLink;

  @FindBy(id = "logo")
  WebElement googleLogo;


  public Marca() {
    driver = getDriver();
    initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(Constants.LOW_TIMEOUT)), this);
  }

  public void acceptCookies() {
    if (isVisible(acceptCookies)) {
      acceptCookies.click();
    }
  }

  public void clickLeganes(){
    if (isVisible(leganesButton)) {
      leganesButton.click();
    }
  }

  public void clickPlantilla(){
    FrontEndOperation.clickWhenVisible(plantillaButton);
  }

  public void checkNamePlayer(){
    WebDriver driver = DriverConfiguration.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Actions actions = new Actions(driver);
    wait.until(ExpectedConditions.visibilityOf(playerNameLink));
    actions.moveToElement(playerNameLink).perform();

    FrontEndOperation.waitSeconds(4);
    FrontEndOperation.checkThat("El texto es igual", playerNameLink.getText(), is(TextTranslation.get("nombreJugador")));
  }

  public void changeTab(){
    FrontEndOperation.switchToTab(1, false);
    if(FrontEndOperation.isVisible(googleLogo)){
      FrontEndOperation.waitSeconds(5);
    }
  }
}
