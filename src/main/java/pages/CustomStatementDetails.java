package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomStatementDetails {
    private WebDriver driver;

    private By btnContinue = By.linkText("Continue");
    private By alertCustomised = By.xpath("/html/body/table/tbody/tr[1]/td/p");
    public CustomStatementDetails(WebDriver driver){
        this.driver = driver;
    }
    public HomePage clickBtnContinue(){
        driver.findElement(btnContinue).click();
        return new HomePage(driver);
    }
    public String getCustomised(){
       return driver.findElement(alertCustomised).getText();

    }
    public String getAlertText(){
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
}
//ff