package login;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.DialogCantLoginPage;
import pages.SecureAreaPage;

public class LoginTests extends BaseTests {
    @Test
    @Disabled("TC01-Login successfully")
    public void testLoginSuccessful(){
        loginPage.setUserNameTxt("Admin");
        loginPage.setPasswordTxt("Admin123");
        loginPage.clickLocationSession();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        System.out.println("Logged........");
        String LoggedText = secureAreaPage.getTextLoginSuccess();
        Assertions.assertTrue(LoggedText.contains("Logged in as Super User (admin) at Inpatient Ward."), "Loginfail!!!");

    }
    @Test
    @Disabled("TC02-Login unsuccessfully with not choose a location")
    public void testLoginUnSuccessful_notChooseLocation(){
        loginPage.setUserNameTxt("Admin");
        loginPage.setPasswordTxt("Admin123");

        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        System.out.println("Click Login.....");
        String textLocationError = secureAreaPage.getTextLocationError();
        System.out.println("Mes: "+ textLocationError);
        Assertions.assertTrue(textLocationError.contains("You must choose a location!"), "Location for this session!");
    }
    @Test
    @Disabled("TC03-Login unsuccessfully_ with Invalid Username")
    public void testLoginUNSuccessful_InvalidUsername(){
        loginPage.setUserNameTxt("ad");
        loginPage.setPasswordTxt("Admin123");
        loginPage.clickLocationSession();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        System.out.println("Click Login.....");
        String ErrorText = secureAreaPage.getTextErrorMes();
        System.out.println("Mes: "+ErrorText);
        Assertions.assertTrue(ErrorText.contains("Invalid username/password. Please try again."), "UserName and Password is valid");

    }
    @Test
    @Disabled("TC04-Login unsuccessfully_ with Invalid Password")
    public void testLoginUnSuccessful_InvalidPass(){
        loginPage.setUserNameTxt("Admin");
        loginPage.setPasswordTxt("admin123");
        loginPage.clickLocationSession();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        System.out.println("Click Login.....");
        String ErrorText = secureAreaPage.getTextErrorMes();
        System.out.println("Mes: "+ErrorText);
        Assertions.assertTrue(ErrorText.contains("Invalid username/password. Please try again."), "UserName and Password is valid!");
    }
    @Test
    @Disabled("TC05-Login unsuccessfully_ with Invalid Username and Password")
    public void testLoginUnSuccessful_InvalidUsernamePassword(){
        loginPage.setUserNameTxt("admi");
        loginPage.setPasswordTxt("admin");
        loginPage.clickLocationSession();
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        System.out.println("Click Login.....");
        String ErrorText = secureAreaPage.getTextErrorMes();
        System.out.println("Mes: "+ErrorText);
        Assertions.assertTrue(ErrorText.contains("Invalid username/password. Please try again."), "UserName and Password is valid!");
    }
    @Test
    @Disabled("TC06-Login unsuccessfully_ with Invalid Username and Password")
    public void testCanNotLogin(){
        DialogCantLoginPage cantLoginPage = loginPage.clickCantLogin();
        System.out.println("Click Can't Login.....");
        String dialogText = cantLoginPage.getTestDialog();
        System.out.println("Mes: "+dialogText);
        cantLoginPage.clickButtonOK();
        Assertions.assertTrue(dialogText.contains("Please contact your System Administrator."), "Loginfail!!!");
    }
}
