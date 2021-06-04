package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    private WebDriver driver;

    private By textHomepage = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee");


    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextHomepage(){
        String textError = driver.findElement(textHomepage).getText();
            return textError;
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
