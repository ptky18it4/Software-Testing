package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    private By textHome = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee");
    private By btnLoout = By.linkText("Log out");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextHome(){
        String text = driver.findElement(textHome).getText();
        return text;
    }

    public SecureAreaPageDeposit ckickLogout(){
        driver.findElement(btnLoout).click();
        return new SecureAreaPageDeposit(driver);
    }
}
