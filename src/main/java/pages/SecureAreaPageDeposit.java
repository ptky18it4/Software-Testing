package pages;

import org.openqa.selenium.Alert;
<<<<<<< HEAD
import org.openqa.selenium.By;
=======
>>>>>>> main
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class SecureAreaPageDeposit {
    WebDriver driver;
<<<<<<< HEAD
    /***   Successe  */
    private By detailDeposit = By.cssSelector("table.layout:nth-child(9) table:nth-child(1) tbody:nth-child(1) tr:nth-child(1) td:nth-child(1) > p.heading3");


    /***********************************************/
    public SecureAreaPageDeposit(WebDriver driver) {
        this.driver = driver;
    }
    /***   Successe  */
    public String getTextDetail(){
        String text = driver.findElement(detailDeposit).getText();
        return text;
    }
=======

    public SecureAreaPageDeposit(WebDriver driver) {
        this.driver = driver;
    }
>>>>>>> main

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
