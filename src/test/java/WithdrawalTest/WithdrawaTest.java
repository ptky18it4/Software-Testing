package WithdrawalTest;

import base.BaseTestsWithdrawal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SecureAreaPage;

public class WithdrawaTest extends BaseTestsWithdrawal {
    @Test
    @Disabled("TC1_All files Valid")
    public void testDepositSuccessfuly(){
        withdrawalPage.setidAccount("93301");
        withdrawalPage.setAmount("1");
        withdrawalPage.setDescriptio("Salary");
        SecureAreaPage secureAreaPage = withdrawalPage.clickbtnSubmit();
        Assertions.assertEquals(secureAreaPage.getTextDetail(), "Transaction details of Withdrawal for Account 93301","Deposit Fail! ");
    }
    @Test
    @Disabled("TC2_INCORRECT character Account No")
    public void testIncorrectAccount(){
        withdrawalPage.setidAccount("abc");
        withdrawalPage.setAmount("100");
        withdrawalPage.setDescriptio("Salary");
        System.out.println(" Mess: " + withdrawalPage.getmesID());
        Assertions.assertEquals(withdrawalPage.getmesID(), "Characters are not allowed",
                "Characters are allowed ");
    }
    ///Alert
    @Test
    @Disabled("TC3_INVALID Account No")
    public void testInvalidAccount(){
        withdrawalPage.setidAccount("1000");
        withdrawalPage.setAmount("100");
        withdrawalPage.setDescriptio("Salary");
        SecureAreaPage secureAreaPage = withdrawalPage.clickbtnSubmit();
        String text = secureAreaPage.getAlertText();
        System.out.println("Alert: "+text);
        Assertions.assertEquals(text, "Account does not exist",
                "Account exist");
    }
    @Test
    @Disabled("TC4_INCORRECT character Amount")
    public void testIncorrectAmount(){
        withdrawalPage.setidAccount("93301");
        withdrawalPage.setAmount("abc1000");
        withdrawalPage.setDescriptio("Salary");
        SecureAreaPage secureAreaPage = withdrawalPage.clickbtnSubmit();
        Assertions.assertEquals(secureAreaPage.getAlertText(), "Amount could not be debited!!",
                "Characters are allowed ");
    }
    @Test
    @Disabled("TC5_INVALID Amount")
    public void testInvalAmount(){
        withdrawalPage.setidAccount("93301");
        withdrawalPage.setAmount("100");
        withdrawalPage.setDescriptio("Salary");
        SecureAreaPage secureAreaPage = withdrawalPage.clickbtnSubmit();
        String text = secureAreaPage.getAlertText();
        Assertions.assertEquals(text, "You are not authorize to debit money from this account!!",
                "Amount valid");
    }
    @Test
    @Disabled("TC6_Bank Account No filed")
    public void testBlankAccount(){
        withdrawalPage.setidAccount("");
        withdrawalPage.setAmount("100");
        withdrawalPage.setDescriptio("Salary");
        System.out.println(" Mess: " + withdrawalPage.getmesID());
        Assertions.assertEquals(withdrawalPage.getmesID(), "Account Number must not be blank",
                "Account Number exist!!!!!1 ");
    }
    @Test
    @Disabled("TC_07- Blank Amount filed")
    public void testBlankAmount(){
        withdrawalPage.setidAccount("93301");
        withdrawalPage.setAmount("");
        withdrawalPage.setDescriptio("Salary");
        System.out.println(" Mess: " + withdrawalPage.getmesAmount());
        Assertions.assertEquals(withdrawalPage.getmesAmount(), "Amount Field must not be blank",
                "Amount Field is not blank ");
    }
    @Test
    @Disabled("TC_08-Blank Description field")
    public void testBlankDes(){
        withdrawalPage.setDescriptio("");
        withdrawalPage.setidAccount("93301");
        withdrawalPage.setAmount("100");
        String text = withdrawalPage.getmesDes();
        Assertions.assertEquals(text, "Description can not be blank",
                "Amount Field is not blank!!!!! ");
    }
    @Test
    @Disabled("TC_09- Field null")
    public void testAllfilenul(){
        SecureAreaPage secureAreaPage = withdrawalPage.clickbtnSubmit();
        String text = secureAreaPage.getAlertText();
        Assertions.assertEquals(text, "Please fill all fields",
                "Field is not null ");
    }
    @Test
    @Disabled("TC_10_Click Reset")
    public void testReset(){
        withdrawalPage.clickbtnReset();
        String text = withdrawalPage.getIDField() + withdrawalPage.getAmountField() + withdrawalPage.getDescriptionField();
        Assertions.assertEquals(text, "",
                "Reset Faill!!!!!!! ");
    }
    @Test
    @Disabled("TC_11_Click link Home")
    public void testHome(){
        HomePage homePage = withdrawalPage.clickHome();
        Assertions.assertEquals(homePage.getTextHome(), "Welcome To Manager's Page of Guru99 Bank",
                "Come back Home page Faill!!!!!!! ");

    }
}
