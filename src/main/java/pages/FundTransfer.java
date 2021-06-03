package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FundTransfer {
    private WebDriver driver;
    private By payerAccount = By.name("payersaccount");
    private By payeeAccount = By.name("payeeaccount");
    private By amount = By.name("ammount");
    private By des = By.name("desc");
    private By btnSubmit = By.name("AccSubmit");
    private By btnReset = By.name("res");
    private By btnHome = By.linkText("Home");
    public FundTransfer(WebDriver driver){
        this.driver = driver;
    }
    public void setPayerAccount(String a){
        driver.findElement(payerAccount).sendKeys(a);
    }
    public void setPayeeAccount(String b){
        driver.findElement(payeeAccount).sendKeys(b);
    }
    public void setAmount(String c){
        driver.findElement(amount).sendKeys(c);
    }
    public void setDes(String d){
        driver.findElement(des).sendKeys(d);
    }
    public void clickReset (){
        driver.findElement(btnReset).click();
    }
    public String getMessagePayer(){
        return  driver.findElement(payerAccount).getText();
    }
    public String getMessagePayee(){
        return  driver.findElement(payeeAccount).getText();
    }
    public String getMessageAmount(){
        return  driver.findElement(amount).getText();
    }
    public String getMessageDescription(){
        return  driver.findElement(des).getText();
    }
    public void clickBtnHome(){
        driver.findElement(btnHome).click();

    }
    public FundTransferDetails clickSubmit(){
        driver.findElement(btnSubmit).click();
        return new FundTransferDetails(driver);
    }

}
//d
