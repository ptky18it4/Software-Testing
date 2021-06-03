package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecureAreaPage {
    private WebDriver driver;

    private By sessionLocationError = By.id("sessionLocationError");
    private By errorMessage = By.id("error-message");


    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getTextLoginSuccess(){
        String text = driver.findElement(By.cssSelector("#content > div:nth-child(2) > div > h4")).getText();
        return text;
    }
    public String getTextErrorMes(){
        String textError = driver.findElement(errorMessage).getText();
        return textError;
    }
    public String getTextLocationError(){
        String textError = driver.findElement(sessionLocationError).getText();
            return textError;
    }
    public void cantLogin(){
        driver.findElement(By.id("//*[@id=\"cannotLoginPopup\"]/div[2]/button")).click();
    }

}
