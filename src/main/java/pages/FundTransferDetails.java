package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FundTransferDetails {
    private WebDriver driver;
    private By btnContinue = By.linkText("Continue");
    private By btnHome = By.linkText("Home");
    private By alertFundTransfer = By.xpath("/html/body/table/tbody/tr[1]/td/p");
    public FundTransferDetails(WebDriver driver){
        this.driver = driver;
    }
    public HomePage clickBtnContinue(){
        driver.findElement(btnContinue).click();
        return new HomePage(driver);
    }

    public String getAlertText(){
       Alert alert = driver.switchTo().alert();
       String alertText = alert.getText();
       alert.accept();
       return alertText;
    }
    public String getAlertFundTransfer(){
        return driver.findElement(alertFundTransfer).getText();
    }
}
