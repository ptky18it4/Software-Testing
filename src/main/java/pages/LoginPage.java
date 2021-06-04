package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By userNameTxt = By.name("uid");
    private By passwordTxt = By.name("password");
    private By btnLogin = By.name("btnLogin");
    private By btnReset = By.name("btnReset");

    private By mesUser = By.id("message23");
    private By mesPass = By.id("message18");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserNameTxt(String username) {
        driver.findElement(userNameTxt).sendKeys(username);
    }

    public void setPasswordTxt(String password) {
        driver.findElement(passwordTxt).sendKeys(password);
    }

    public void clickButtonReset(){
        driver.findElement(btnReset).click();
    }

    public SecureAreaPage clickLoginButton() {
        driver.findElement(btnLogin).click();
        return new SecureAreaPage(driver);
    }
    /////////////////
    public String getMesUser(){
        String text = driver.findElement(mesUser).getText();
        return text;
    }
    public String getMesPass(){
        String textError = driver.findElement(mesPass).getText();
        return textError;
    }
    public String getUserNameTxt() {
        return driver.findElement(userNameTxt).getText();
    }

    public String getPasswordTxt() {
        return driver.findElement(passwordTxt).getText();
    }

}
