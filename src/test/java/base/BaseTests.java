package base;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;


import java.awt.print.PrinterException;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;
    protected FundTransfer fundTransfer;
    protected CustomStatement customStatement;
    protected CustomStatementDetails customStatementDetails;
    @BeforeEach
    public void setUp(){
        try {
            System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("http://www.demo.guru99.com/V4/index.php");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.name("uid")).sendKeys("mngr328445");
            driver.findElement(By.name("password")).sendKeys("sAdugem");
            driver.findElement(By.name("btnLogin")).click();
            homePage = new HomePage(driver);
            fundTransfer = new FundTransfer(driver);
            customStatement = new CustomStatement(driver);
            customStatementDetails = new CustomStatementDetails(driver);
        } catch (Exception e){
              System.out.print(e);
        }
    }
    public void main(String[] args){
        BaseTests test = new BaseTests();
        test.setUp();
    }
}
//d