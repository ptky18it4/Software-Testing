package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DialogCantLoginPage {
    private WebDriver driver;
    private By buttonOK = By.xpath("//*[@id=\"cannotLoginPopup\"]/div[2]/button");

    public DialogCantLoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickButtonOK(){
        driver.findElement(buttonOK).click();
    }
    public String getTestDialog(){
        String textDialog = driver.findElement(By.xpath("//*[@id=\"cannotLoginPopup\"]/div[2]/p")).getText();
        return textDialog;
    }

}
