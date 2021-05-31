package base;

import org.openqa.selenium.*;

public class LoginPage {
    private final WebDriver driver;

    private final By userNameTxt = By.name("uid");
    private final By passwordTxt = By.name("password");
    private final By loginButton = By.name("btnLogin");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String userName) {
        driver.findElement(userNameTxt).sendKeys(userName);
    }

    public void setPassword(String password) {
        driver.findElement(passwordTxt).sendKeys(password);
    }

    public SecureAreaPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }
}
