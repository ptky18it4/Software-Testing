package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    private By btnLoout = By.linkText("Log out");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public SecureAreaPageDeposit ckickLogout(){
        driver.findElement(btnLoout).click();
        return new SecureAreaPageDeposit(driver);
    }

}
