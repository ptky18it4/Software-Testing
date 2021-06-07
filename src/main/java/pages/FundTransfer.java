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
    private By alertPayer = By.id("message10");
    private By alertPayee = By.id("message11");
    private By alertAmount = By.id("message1");
    private By alertDes = By.id("message17");
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
        return  driver.findElement(alertPayer).getText();
    }
    public String getMessagePayee(){
        return  driver.findElement(alertPayee).getText();
    }
    public String getMessageAmount(){
        return  driver.findElement(alertAmount).getText();
    }
    public String getMessageDescription(){
        return  driver.findElement(alertDes).getText();
    }
    public void clickBtnHome(){
        driver.findElement(btnHome).click();

    }
    public FundTransferDetails clickSubmit(){
        driver.findElement(btnSubmit).click();
        return new FundTransferDetails(driver);
    }

}
