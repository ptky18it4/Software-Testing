package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewAccountPage {
    private final WebDriver driver;
    private By customerIdTxt = By.name("cusid");
    private By selectedAccountTxt = By.name("selaccount");
    private By initialDepositTxt = By.name("inideposit");
    private By submitBtn = By.name("button2");


    public NewAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getMessage(String idMessage){
        return driver.findElement(By.id(idMessage)).getText();
    }

    public void setCustomerIdTxt(String customerId) {
        driver.findElement(customerIdTxt).sendKeys(customerId);
    }

    public void setSelectedAccountTxt() {
        WebElement element = driver.findElement(selectedAccountTxt);
        element.sendKeys(Keys.ARROW_DOWN);
        element.sendKeys(Keys.TAB);
    }

    public void setInitialDepositTxt(String initialDeposit) {
        driver.findElement(initialDepositTxt).sendKeys(initialDeposit);
    }

    public void setSubmitBtn(By submitBtn) {
        this.submitBtn = submitBtn;
    }
}
