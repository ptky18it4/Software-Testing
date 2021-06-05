package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomStatement {
    private WebDriver driver;
    private By accountNo = By.name("accountno");
    private By formDate = By.name("fdate");
    private By toDate = By.name("tdate");
    private By miniumTransaction = By.name("amountlowerlimit");
    private By numberTranscation = By.name("numtransaction");
    private By btnSubmit = By.name("AccSubmit");
    private By btnReset = By.name("res");
    private By btnHome = By.linkText("Home");
    public CustomStatement(WebDriver driver){
        this.driver = driver;
    }
    public void setAccountNo(String a){
        driver.findElement(accountNo).sendKeys(a);
    }
    public void setFormDate(String b){
        driver.findElement(formDate).sendKeys(b);
    }
    public void setToDate(String c){
        driver.findElement(toDate).sendKeys(c);
    }
    public void setMiniumTransaction(String d){
        driver.findElement(miniumTransaction).sendKeys(d);
    }
    public void setNumberTranscation(String e){
        driver.findElement(numberTranscation).sendKeys(e);
    }
    public String getMessageAccountNo(){
        return driver.findElement(accountNo).getText();
    }
    public String getMessageFormDate(){
         return driver.findElement(formDate).getText();
    }
    public String getMessageToDate(){
        return driver.findElement(toDate).getText();
    }
    public String getMessageMiniumTransaction(){
        return driver.findElement(miniumTransaction).getText();
    }
    public String getMessageNumberTransaction(){
        return driver.findElement(numberTranscation).getText();
    }
    public void clickReset(){
        driver.findElement(btnReset).click();
    }
    public void clickBtnHome(){
        driver.findElement(btnHome).click();

    }
    public CustomStatementDetails clickSubmit (){
        driver.findElement(btnSubmit).click();
        return new CustomStatementDetails(driver);
    }



}
//ff