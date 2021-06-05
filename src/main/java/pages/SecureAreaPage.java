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
    /***   Successe  */
    private By detailDeposit = By.cssSelector("table.layout:nth-child(9) table:nth-child(1) tbody:nth-child(1) tr:nth-child(1) td:nth-child(1) > p.heading3");


    /***   Successe  */
    public String getTextDetail(){
        String text = driver.findElement(detailDeposit).getText();
        return text;
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
