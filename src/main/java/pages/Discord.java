package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.DriverConfiguration;

public class Discord {

    private WebDriver driver;

    @FindBy(className= "login-button-js")
    WebElement iniciarSesion;

    @FindBy(id = "uid_8")
    WebElement email;

    @FindBy(id = "uid_10")
    WebElement password;

    public Discord() {
        this.driver = DriverConfiguration.getDriver();
    }

    public void clickIniciarSesion() {
        iniciarSesion.click();
    }

    public void clickEmail() {
        email.click();
        email.sendKeys("ejemplo@gmail.com");
    }

    public void clickPassword() {
        password.click();
        password.sendKeys("123456");
    }

}
