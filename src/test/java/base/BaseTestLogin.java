package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTestLogin {
    private WebDriver driver;
    protected LoginPage loginPage;
    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/v3/index.php");
        driver.manage().window().setSize(new Dimension(400, 812));
        loginPage = new LoginPage(driver);
    }
    @AfterEach
    public  void  tearDown(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.quit();
    }

}
