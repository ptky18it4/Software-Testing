package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.WithdrawalPage;

import java.util.concurrent.TimeUnit;

public class BaseTestsWithdrawal {
    private WebDriver driver;
    protected WithdrawalPage withdrawalPage;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/v3/index.php");
        driver.manage().window().setSize(new Dimension(400, 812));

        driver.findElement(By.name("uid")).sendKeys("mngr328445");
        driver.findElement(By.name("password")).sendKeys("sAdugem");
        driver.findElement(By.name("btnLogin")).click();
        driver.findElement(By.linkText("Withdrawal")).click();
        withdrawalPage = new WithdrawalPage(driver);
        System.out.println("After Login");

    }
    @AfterEach
    public  void  tearDown(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.quit();
    }
}
