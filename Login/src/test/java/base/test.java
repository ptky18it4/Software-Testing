package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
    private WebDriver driver;
    public void setUp(){
        //System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.openmrs.org/openmrs/referenceapplication/home.page");
        driver.findElement(By.id("username")).sendKeys("Admin");
        driver.findElement(By.id("password")).sendKeys(("Admin123"));
        driver.findElement(By.id("Inpatient Ward")).click();
        driver.findElement(By.id("loginButton")).click();
        driver.manage().window().setSize(new Dimension(375, 812));

        System.out.println(driver.getTitle());
    }
    public static void main(String[] args){
        test test = new test();
        test.setUp();
    }
}
