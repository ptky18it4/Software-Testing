package Logintest;

import base.BaseTestLogin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.SecureAreaPage;

public class LoginTestLogin extends BaseTestLogin {
    @Test
    @Disabled("TC01-Login successfully")
    public void testLoginSuccessful(){
        loginPage.setUserNameTxt("mngr328445");
        loginPage.setPasswordTxt("sAdugem");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        String textHomePage = secureAreaPage.getTextHomepage();
        Assertions.assertTrue(textHomePage.contains("Welcome To Manager's Page of Guru99 Bank"), "Loginfail!!!");
    }

    @Test
    @Disabled("TC03-Login unsuccessfully_ with Invalid Username")
    public void testLoginUNSuccessful_InvalidUsername(){
        loginPage.setUserNameTxt("abc123");
        loginPage.setPasswordTxt("sAdugem");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        String ErrorText = secureAreaPage.getAlertText();
        System.out.println("Mes: "+ErrorText);
        Assertions.assertTrue(ErrorText.contains("User is not valid"), "UserName or Password is valid");

    }
    @Test
    @Disabled("TC04-Login unsuccessfully_ with Invalid Password")
    public void testLoginUnSuccessful_InvalidPass(){
        loginPage.setUserNameTxt("mngr328445");
        loginPage.setPasswordTxt("sA");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        String ErrorText = secureAreaPage.getAlertText();
        System.out.println("Mes: "+ErrorText);
        Assertions.assertTrue(ErrorText.contains("User is not valid"), "UserName or Password is valid!");
    }
    @Test
    @Disabled("TC05-Login unsuccessfully_ with Blank Username")
    public void testLoginUnSuccessful_BlankUsername(){
        loginPage.setUserNameTxt("");
        loginPage.setPasswordTxt("sAdugem");
        String ErrorText = loginPage.getMesUser();
        System.out.println("Mes: "+ErrorText);
        Assertions.assertTrue(ErrorText.contains("User-ID must not be blank"), "User-ID not be blank");
    }
    @Test
    @Disabled("TC06-Login unsuccessfully_ with Blank Password")
    public void testBlankPassword(){
        loginPage.setPasswordTxt("");
        loginPage.setUserNameTxt("mngr328445");
        String ErrorText = loginPage.getMesPass();
        System.out.println("Mes: "+ErrorText);
        Assertions.assertTrue(ErrorText.contains("Password must not be blank"), "Pass not be blank");
    }
    @Test
    @Disabled("TC07_Click Reset")
    public void testReset(){
        loginPage.clickButtonReset();
        String text = loginPage.getUserNameTxt() + loginPage.getPasswordTxt();
        Assertions.assertEquals(text, "",
                "Reset Faill!!!!!!! ");
    }
}
