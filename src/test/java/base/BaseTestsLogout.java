package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseTestsLogout {
    private WebDriver driver;
    protected HomePage homePage;
//    protected SecureAreaPageDeposit secureAreaPageDeposit;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/v3/index.php");
        driver.manage().window().setSize(new Dimension(600, 812));
        driver.findElement(By.name("uid")).sendKeys("mngr328445");
        driver.findElement(By.name("password")).sendKeys("sAdugem");
        driver.findElement(By.name("btnLogin")).click();
        homePage = new HomePage(driver);
    }
    @AfterEach
    public  void  tearDown(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.quit();
    }
}
