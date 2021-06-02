package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WithdrawalPage {
    WebDriver driver;
    private By idAccounttxt = By.name("accountno");
    private By amounttxt = By.name("balance");
    private By description = By.name("desc");
    private By btnSubmit = By.name("AccSubmit");
    private By btnReset = By.name("res");
    private By linkHome = By.linkText("Home");
    /***   Message  */
    private By mesId = By.id("message2");
    private By mesAmount = By.id("message15");
    private By mesDes = By.id("message17");
/***************************************************************************/
    public WithdrawalPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setidAccount(String input){
        driver.findElement(idAccounttxt).sendKeys(input);
    }
    public void setAmount(String input){
        driver.findElement(amounttxt).sendKeys(input);
    }
    public void setDescriptio(String input){
        driver.findElement(description).sendKeys(input);
    }
    public SecureAreaPage clickbtnSubmit(){
        driver.findElement(btnSubmit).click();
        return new SecureAreaPage(driver);
    }
    /*** Reset*/
    public void clickbtnReset(){
        driver.findElement(btnReset).click();
    }
    public String getIDField(){
        return driver.findElement(idAccounttxt).getText();
    }
    public String getAmountField(){
        return driver.findElement(amounttxt).getText();
    }
    public String getDescriptionField(){
        return driver.findElement(description).getText();
    }
    /*** Cancel*/
    public HomePage clickHome(){
        driver.findElement(linkHome).click();
        return  new HomePage(driver);
    }
    public void clickLogout(){
        driver.findElement(By.linkText("Log out"));
    }
    /***   Message  */
    public String getmesID(){
      String text = driver.findElement(mesId).getText();
      return text;
    }
    public String getmesAmount(){
        String text = driver.findElement(mesAmount).getText();
        return text;
    }
    public String getmesDes(){
        String text = driver.findElement(mesDes).getText();
        return text;
    }

}
