package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By btnFundTransfer = By.linkText("Fund Transfer");
    private By btnCustomStatement = By.linkText("Customised Statement");
    private By textHome = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee");
    private By btnLoout = By.linkText("Log out");
  
    public HomePage(WebDriver driver){
        this.driver= driver;
    }
    public FundTransfer clickForm(){
         driver.findElement(btnFundTransfer).click();
         return new FundTransfer(driver);
    }
    public CustomStatement clickFormCustom(){
        driver.findElement(btnCustomStatement).click();
        return new CustomStatement(driver);
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
