package DepositTest;

import base.BaseTestsDeposit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SecureAreaPageDeposit;

public class DepositTest extends BaseTestsDeposit {
    @Test
    @Disabled("TC1_All files Valid")
    public void testDepositSuccessfuly(){
        depositPage.setidAccount("93301");
        depositPage.setAmount("100");
        depositPage.setDescriptio("Salary");
        SecureAreaPageDeposit secureAreaPageDeposit = depositPage.clickbtnSubmit();
        Assertions.assertEquals(secureAreaPageDeposit.getTextDetail(), "Transaction details of Deposit for Account 93301","Deposit Fail! ");
    }
    @Test
    @Disabled("TC2_INCORRECT character Account No")
    public void testIncorrectAccount(){
        depositPage.setidAccount("abc");
        depositPage.setAmount("100");
        depositPage.setDescriptio("Salary");
        System.out.println(" Mess: " + depositPage.getmesID());
        Assertions.assertEquals(depositPage.getmesID(), "Characters are not allowed",
                "Characters are allowed ");
    }
    ///Alert
    @Test
    @Disabled("TC3_INVALID Account No")
    public void testInvalidAccount(){
        depositPage.setidAccount("1000");
        depositPage.setAmount("100");
        depositPage.setDescriptio("Salary");
        SecureAreaPageDeposit secureAreaPageDeposit = depositPage.clickbtnSubmit();
        String text = secureAreaPageDeposit.getAlertText();
        System.out.println("Alert: "+text);
        Assertions.assertEquals(text, "Account does not exist",
                "Account exist");
    }
    @Test
    @Disabled("TC4_INCORRECT character Amount")
    public void testIncorrectAmount(){
        depositPage.setidAccount("93301");
        depositPage.setAmount("abc1000");
        depositPage.setDescriptio("Salary");
        System.out.println(" Mess: " + depositPage.getmesAmount());
        Assertions.assertEquals(depositPage.getmesID(), "Characters are not allowed",
                "Characters are allowed ");
    }
    @Test
    @Disabled("TC5_Bank Account No filed")
    public void testBlankAccount(){
        depositPage.setidAccount("");
        depositPage.setAmount("100");
        depositPage.setDescriptio("Salary");
        System.out.println(" Mess: " + depositPage.getmesID());
        Assertions.assertEquals(depositPage.getmesID(), "Account Number must not be blank",
                "Account Number exist!!!!!1 ");
    }
    @Test
    @Disabled("TC_06- Blank Amount filed")
    public void testBlankAmount(){
        depositPage.setidAccount("93301");
        depositPage.setAmount("");
        depositPage.setDescriptio("Salary");
        System.out.println(" Mess: " + depositPage.getmesAmount());
        Assertions.assertEquals(depositPage.getmesAmount(), "Amount Field must not be blank",
                "Amount Field is not blank ");
    }
    @Test
    @Disabled("TC_07-Blank Description field")
    public void testBlankDes(){
        depositPage.setDescriptio("");
        depositPage.setidAccount("93301");
        depositPage.setAmount("100");
        String text = depositPage.getmesDes();
        Assertions.assertEquals(text, "Description can not be blank",
                "Amount Field is not blank!!!!! ");
    }
    @Test
    @Disabled("TC_08- Field null")
    public void testAllfilenul(){
        SecureAreaPageDeposit secureAreaPageDeposit = depositPage.clickbtnSubmit();
        String text = secureAreaPageDeposit.getAlertText();
        Assertions.assertEquals(text, "Please fill all fields",
                "Field is not null ");
    }
    @Test
    @Disabled("TC09_Click Reset")
    public void testReset(){
        depositPage.clickbtnReset();
        String text = depositPage.getAmountField() + depositPage.getAmountField() +depositPage.getDescriptionField();
        Assertions.assertEquals(text, "",
                "Reset Faill!!!!!!! ");
    }
    @Test
    @Disabled("TC10_Click link Home")
    public void testHomeme(){
        HomePage homePage = depositPage.clickHome();
        Assertions.assertEquals(homePage.getTextHome(), "Welcome To Manager's Page of Guru99 Bank",
                "Come back Home page Faill!!!!!!! ");

    }
}
