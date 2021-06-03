package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By userNameTxt = By.id("username");
    private By passwordTxt = By.id("password");
    private By locationSession = By.id("Inpatient Ward");
    private By btnLogin = By.id("loginButton");
    private By cantLogin = By.id("cantLogin");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserNameTxt(String username) {
        driver.findElement(userNameTxt).sendKeys(username);
    }

    public void setPasswordTxt(String password) {
        driver.findElement(passwordTxt).sendKeys(password);
    }

    public void clickLocationSession(){
        driver.findElement(locationSession).click();
    }

    public DialogCantLoginPage clickCantLogin(){
        driver.findElement(cantLogin).click();
        return  new DialogCantLoginPage(driver);
    }

    public SecureAreaPage clickLoginButton() {
        driver.findElement(btnLogin).click();
        return new SecureAreaPage(driver);
    }

}
