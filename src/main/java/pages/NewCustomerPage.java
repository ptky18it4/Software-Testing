package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewCustomerPage {
    private final WebDriver driver;
    private final By customerName = By.name("name");
    private final By genderRadio = By.xpath("//tbody/tr[5]/td[2]/input[1]");
    private final By dateOfBirthPicker = By.name("dob");
    private final By addressTxt = By.name("addr");
    private final By cityTxt = By.name("city");
    private final By stateTxt = By.name("state");
    private final By pinTxt = By.name("pinno");
    private final By mobileNumberTxt = By.name("telephoneno");
    private final By emailTxt = By.name("emailid");
    private final By passwordTxt = By.name("password");
    private final By loginButton = By.name("sub");

    public NewCustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getMessage(String idMessage){
       return driver.findElement(By.id(idMessage)).getText();
    }
    public void setCustomerName(String userName) {
        driver.findElement(customerName).sendKeys(userName);
    }

    public void selectedGender() {
        driver.findElement(genderRadio).click();
    }

    public void selectedDate() {
        WebElement datePicker = driver.findElement(dateOfBirthPicker);
        datePicker.sendKeys(Keys.ARROW_DOWN);
        datePicker.sendKeys(Keys.ARROW_RIGHT);
        datePicker.sendKeys(Keys.ARROW_UP);
        datePicker.sendKeys(Keys.ARROW_RIGHT);
        datePicker.sendKeys(Keys.ARROW_DOWN);
        datePicker.sendKeys(Keys.TAB);
    }

    public void setAddressTxt(String address) {
        driver.findElement(addressTxt).sendKeys(address);
    }

    public void setCityTxt(String city) {
        driver.findElement(cityTxt).sendKeys(city);
    }

    public void setStateTxt(String state) {
        driver.findElement(stateTxt).sendKeys(state);
    }

    public void setPinTxt(String pin) {
        driver.findElement(pinTxt).sendKeys(pin);
    }

    public void setMobileNumberTxt(String mobileNumber) {
        driver.findElement(mobileNumberTxt).sendKeys(mobileNumber);
    }

    public void setEmailTxt(String email) {
        driver.findElement(emailTxt).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordTxt).sendKeys(password);
    }

    public void loginButton() {
        driver.findElement(loginButton).click();
    }

}
