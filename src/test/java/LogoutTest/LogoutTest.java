package LogoutTest;

import base.BaseTestsLogout;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.SecureAreaPageDeposit;

public class LogoutTest extends BaseTestsLogout {
    @Test
    @Disabled("TC_01-Verify account is able to Log out with click on Log out")
    public void testLogoutSuccessfuly(){
        SecureAreaPageDeposit  secureAreaPageDeposit = homePage.ckickLogout();
        String text1 = secureAreaPageDeposit.getAlertText();
        Assertions.assertEquals(text1, "You Have Succesfully Logged Out!!","Log out Fail! ");


    }
}
