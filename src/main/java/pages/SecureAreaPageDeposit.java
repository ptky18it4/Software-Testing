package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class SecureAreaPageDeposit {
    WebDriver driver;

    public SecureAreaPageDeposit(WebDriver driver) {
        this.driver = driver;
    }

    public String getAlertText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            alert.accept();
            return alertText;
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
        return null;
    }

}
