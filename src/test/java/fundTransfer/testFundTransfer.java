package fundTransfer;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.FundTransfer;
import pages.FundTransferDetails;

public class testFundTransfer extends BaseTests {
    @Test
    @DisplayName("TC_001: Fund Transfer Successful")
    public void testFundTransferSucceffful () throws InterruptedException {
        FundTransfer fundTransfer = homePage.clickForm();
        fundTransfer.setPayerAccount("93277");
        Thread.sleep(1000);
        fundTransfer.setPayeeAccount("93278");
        Thread.sleep(1000);
        fundTransfer.setAmount("200000");
        fundTransfer.setDes("ck");
        Thread.sleep(1000);
        FundTransferDetails fundTransferDetails = fundTransfer.clickSubmit();

    }
    @Test
    @DisplayName("TC_002: INVALID Payer Account No")
    public void testInvalidPayerAccountNo () throws InterruptedException {
        FundTransfer fundTransfer = homePage.clickForm();
        fundTransfer.setPayerAccount("10000");
        Thread.sleep(2000);
        fundTransfer.setPayeeAccount("93278");
        Thread.sleep(2000);
        fundTransfer.setAmount("200000");
        fundTransfer.setDes("ck");
        Thread.sleep(2000);
        FundTransferDetails fundTransferDetails = fundTransfer.clickSubmit();
        Assertions.assertEquals(fundTransferDetails.getAlertText(),"Account does not exist","Message");

    }
    @Test
    @DisplayName("TC_003: INVALID Payee Account No")
    public void testInvalidPayeeAccountNo () throws InterruptedException {
        FundTransfer fundTransfer = homePage.clickForm();
        fundTransfer.setPayerAccount("93277");
        Thread.sleep(2000);
        fundTransfer.setPayeeAccount("10000");
        Thread.sleep(2000);
        fundTransfer.setAmount("200000");
        fundTransfer.setDes("ck");
        Thread.sleep(2000);
        FundTransferDetails fundTransferDetails = fundTransfer.clickSubmit();
        Assertions.assertEquals(fundTransferDetails.getAlertText(),"Account does not exist","Message");
    }
    @Test
    @DisplayName("TC_004: INCORRECT character Payer Account No")
    public void testIncorrectCharacterPayerAccountNo () throws InterruptedException {
        FundTransfer fundTransfer = homePage.clickForm();
        fundTransfer.setPayerAccount("A10000");
        Thread.sleep(2000);
        fundTransfer.setPayeeAccount("93278");
        Thread.sleep(2000);
        fundTransfer.setAmount("200000");
        fundTransfer.setDes("ck");
        Thread.sleep(2000);
        Assertions.assertEquals(fundTransfer.getMessagePayer(),"Characters are not allowed","Message");

    }
    @Test
    @DisplayName("TC_005: INCORRECT character Payee Account No")
    public void testIncorrectCharacterPayeeAccountNo () throws InterruptedException {
        FundTransfer fundTransfer = homePage.clickForm();
        fundTransfer.setPayerAccount("A93277");
        Thread.sleep(2000);
        fundTransfer.setPayeeAccount("93278");
        Thread.sleep(2000);
        fundTransfer.setAmount("200000");
        fundTransfer.setDes("ck");
        Thread.sleep(2000);
        Assertions.assertEquals(fundTransfer.getMessagePayee(),"Characters are not allowed","Message");

    }
    @Test
    @DisplayName("TC_006: INCORRECT character Amount Field")
    public void testIncorrectCharacterAmount () throws InterruptedException {
        FundTransfer fundTransfer = homePage.clickForm();
        fundTransfer.setPayerAccount("93277");
        Thread.sleep(2000);
        fundTransfer.setPayeeAccount("93278");
        Thread.sleep(2000);
        fundTransfer.setAmount("200000");
        fundTransfer.setDes("ck");
        Thread.sleep(2000);
        Assertions.assertEquals(fundTransfer.getMessageAmount(),"Characters are not allowed","Message");

    }
    @Test
    @DisplayName("TC_007: BLANK Payer Account No")
    public void testBlankPayerAccountNo () throws InterruptedException {
        FundTransfer fundTransfer = homePage.clickForm();
        fundTransfer.setPayerAccount("");
        Thread.sleep(2000);
        fundTransfer.setPayeeAccount("93278");
        Thread.sleep(2000);
        fundTransfer.setAmount("200000");
        fundTransfer.setDes("ck");
        Thread.sleep(2000);
        Assertions.assertEquals(fundTransfer.getMessagePayer()," Payer Account Number must not be blank","Message");

    }
    @Test
    @DisplayName("TC_008: BLANK Payee Account No")
    public void testBlankPayeeAccountNo () throws InterruptedException {
        FundTransfer fundTransfer = homePage.clickForm();
        fundTransfer.setPayerAccount("93277");
        Thread.sleep(2000);
        fundTransfer.setPayeeAccount("");
        Thread.sleep(2000);
        fundTransfer.setAmount("200000");
        fundTransfer.setDes("ck");
        Thread.sleep(2000);
        Assertions.assertEquals(fundTransfer.getMessagePayee()," Payee Account Number must not be blank","Message");

    }
    @Test
    @DisplayName("TC_009: BLANK Amount Field")
    public void testBlankAmount () throws InterruptedException {
        FundTransfer fundTransfer = homePage.clickForm();
        fundTransfer.setPayerAccount("93277");
        Thread.sleep(2000);
        fundTransfer.setPayeeAccount("93278");
        Thread.sleep(2000);
        fundTransfer.setAmount("");
        fundTransfer.setDes("ck");
        Thread.sleep(2000);
        Assertions.assertEquals(fundTransfer.getMessageAmount()," Amount field must not be blank","Message");
    }
    @Test
    @DisplayName("TC_010: BLANK Description Fiels")
    public void testBlankDescription () throws InterruptedException {
        FundTransfer fundTransfer = homePage.clickForm();
        fundTransfer.setPayerAccount("93277");
        Thread.sleep(2000);
        fundTransfer.setPayeeAccount("93278");
        Thread.sleep(2000);
        fundTransfer.setAmount("20000");
        fundTransfer.setDes("");
        Thread.sleep(2000);
        Assertions.assertEquals(fundTransfer.getMessageDescription()," Description field must not be blank","Message");
    }
    @Test
    @DisplayName("TC_011: Account Balance Low")
    public void testAccountBalanceLow () throws InterruptedException {
        FundTransfer fundTransfer = homePage.clickForm();
        fundTransfer.setPayerAccount("93277");
        Thread.sleep(2000);
        fundTransfer.setPayeeAccount("93278");
        Thread.sleep(2000);
        fundTransfer.setAmount("9900000");
        fundTransfer.setDes("ck");
        Thread.sleep(2000);
        FundTransferDetails fundTransferDetails = fundTransfer.clickSubmit();
        Assertions.assertEquals(fundTransferDetails.getAlertText()," Account Balance Low","Message");
    }
    @Test
    @DisplayName("TC_012: Not Entering All Field")
    public void testAllField () throws InterruptedException {
        FundTransfer fundTransfer = homePage.clickForm();
        fundTransfer.setPayerAccount("");
        Thread.sleep(2000);
        fundTransfer.setPayeeAccount("");
        Thread.sleep(2000);
        fundTransfer.setAmount("");
        fundTransfer.setDes("");
        Thread.sleep(2000);
        FundTransferDetails fundTransferDetails = fundTransfer.clickSubmit();
        Assertions.assertEquals(fundTransferDetails.getAlertText(),"Please fill all fields","Message");
    }
    @Test
    @DisplayName("TC_013: Fund Transfer Reset")
    public void testFundTransferReset () throws InterruptedException {
        FundTransfer fundTransfer = homePage.clickForm();
        fundTransfer.clickReset();

    }
    @Test
    @DisplayName("TC_013: Fund Transfer Reset")
    public void testFundTransferHome () throws InterruptedException {
        FundTransfer fundTransfer = homePage.clickForm();
        fundTransfer.clickBtnHome();

    }
}
