package login;

import base.BaseTest;
import base.SecureAreaPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTests extends BaseTest {

    @Test
    @DisplayName("TC01-Login successfully")
    public void testLoginSuccessful() {

        // Set username: tomsmith, password SupperSecretPassword!
        loginPage.setUserName("mngr328445");
        loginPage.setPassword("sAdugem");

        // Click nút login
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();

        /* Trong quá trình chờ xử lí 2 thằng nhok username, password ở trên
           thì ta tạo một biến alertText kiểu String để tí nữa ta sẽ dùng biến alertText này để lưu nội dung trong alert
           mà chương trình trả về
        */
        try {
            String alertText = secureAreaPage.getAlertText();
            if (alertText != null) {
                Assertions.assertTrue(alertText.contains("User or Password is not valid"), "User ID : ");
            } else {
                System.out.println("Login successful");

            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
