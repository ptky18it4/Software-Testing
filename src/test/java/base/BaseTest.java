package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver = null;
    protected LoginPage loginPage;
    protected NewCustomerPage newCustomerPage;
    protected NewAccountPage newAccountPage;

    @BeforeEach
    public void setUp() {
        // TODO: 5/21/2021 : Ở đây tui đã cấu hình biến môi trường rồi nên dòng phía dưới tui comment nha mấy cha
        //System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        driver = new ChromeDriver();
//        driver.get("http://www.demo.guru99.com/V4/manager/addcustomerpage.php");
        driver.get("http://demo.guru99.com/v4/manager/addAccount.php");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);

        newCustomerPage = new NewCustomerPage(driver);

        newAccountPage = new NewAccountPage(driver);
        // Đoạn này nhớ đợi 10s nha mấy cha
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @AfterEach
    public void tearDown() {
//        driver.quit();
    }
}
