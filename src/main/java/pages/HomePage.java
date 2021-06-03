package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By btnFundTransfer = By.linkText("Fund Transfer");
    private By btnCustomStatement = By.linkText("Customised Statement");
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

}
//d