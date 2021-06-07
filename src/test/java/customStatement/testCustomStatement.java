package customStatement;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CustomStatement;
import pages.CustomStatementDetails;


public class testCustomStatement extends BaseTests {
    @Test
    @DisplayName("TC_001: CORRECT Custom Statement ")
    public void testCustomStatementSuccessful() throws InterruptedException {
        CustomStatement customStatement = homePage.clickFormCustom();
        customStatement.setAccountNo("93277");
        Thread.sleep(1000);
        customStatement.setFormDate("05/28/2021");
        Thread.sleep(1000);
        customStatement.setToDate("05/31/2021");
        Thread.sleep(1000);
        customStatement.setMiniumTransaction("100");
        Thread.sleep(1000);
        customStatement.setNumberTranscation("1000000");
        Thread.sleep(1000);
        CustomStatementDetails customStatementDetails = customStatement.clickSubmit();
        Assertions.assertEquals(customStatementDetails.getCustomised(),"Transaction Details for Account No: 93277 from Date: 2021-05-28 to: 2021-05-31","Message");
    }
    @Test
    @DisplayName("TC_002: INVALID Account No")
    public void testCustomStatementFails() throws InterruptedException {
        CustomStatement customStatement = homePage.clickFormCustom();
        customStatement.setAccountNo("10000");
        Thread.sleep(1000);
        customStatement.setFormDate("05/28/2021");
        Thread.sleep(1000);
        customStatement.setToDate("05/31/2021");
        Thread.sleep(1000);
        customStatement.setMiniumTransaction("100");
        Thread.sleep(1000);
        customStatement.setNumberTranscation("1000000");
        Thread.sleep(1000);
        CustomStatementDetails customStatementDetails = customStatement.clickSubmit();
        Assertions.assertEquals(customStatementDetails.getAlertText(),"Account does not exist","Message");
//ff
    }
    @Test
    @DisplayName("TC_003: INCORRECT Account No")
    public void testIncorrectCustomStatement() throws InterruptedException {
        CustomStatement customStatement = homePage.clickFormCustom();
        customStatement.setAccountNo("A93277");
        Thread.sleep(1000);
        customStatement.setFormDate("05/28/2021");
        Thread.sleep(1000);
        customStatement.setToDate("05/31/2021");
        Thread.sleep(1000);
        customStatement.setMiniumTransaction("100");
        Thread.sleep(1000);
        customStatement.setNumberTranscation("1000000");
        Assertions.assertEquals(customStatement.getMessageAccountNo(),"Characters are not allowed","Message");

    }
    @Test
    @DisplayName("TC_004: INCORRECT Minium Transaction ")
    public void testIncorrectMiniumTrasaction() throws InterruptedException {
        CustomStatement customStatement = homePage.clickFormCustom();
        customStatement.setAccountNo("93277");
        Thread.sleep(1000);
        customStatement.setFormDate("05/28/2021");
        Thread.sleep(1000);
        customStatement.setToDate("05/31/2021");
        Thread.sleep(1000);
        customStatement.setMiniumTransaction("A100");
        Thread.sleep(1000);
        customStatement.setNumberTranscation("1000000");
        Assertions.assertEquals(customStatement.getMessageMiniumTransaction(),"Characters are not allowed","Message");

    }
    @Test
    @DisplayName("TC_005: INCORRECT Number Of Transaction")
    public void testIncorrectNumberTransaction() throws InterruptedException {
        CustomStatement customStatement = homePage.clickFormCustom();
        customStatement.setAccountNo("10000");
        Thread.sleep(1000);
        customStatement.setFormDate("05/28/2021");
        Thread.sleep(1000);
        customStatement.setToDate("05/31/2021");
        Thread.sleep(1000);
        customStatement.setMiniumTransaction("100");
        Thread.sleep(1000);
        customStatement.setNumberTranscation("A1000000");
        Assertions.assertEquals(customStatement.getMessageNumberTransaction(),"Characters are not allowed","Message");

    }
    @Test
    @DisplayName("TC_006: BLANK Account No")
    public void testBlankAccountNo() throws InterruptedException {
        CustomStatement customStatement = homePage.clickFormCustom();
        customStatement.setAccountNo("");
        Thread.sleep(1000);
        customStatement.setFormDate("05/28/2021");
        Thread.sleep(1000);
        customStatement.setToDate("05/31/2021");
        Thread.sleep(1000);
        customStatement.setMiniumTransaction("100");
        Thread.sleep(1000);
        customStatement.setNumberTranscation("1000000");
        Assertions.assertEquals(customStatement.getMessageAccountNo()," Account Number must not be blank","Message");

    }
    @Test
    @DisplayName("TC_007: BLANK Minium Transaction Value Fiels")
    public void testBlankMiniumTransaction() throws InterruptedException {
        CustomStatement customStatement = homePage.clickFormCustom();
        customStatement.setAccountNo("93277");
        Thread.sleep(1000);
        customStatement.setFormDate("05/28/2021");
        Thread.sleep(1000);
        customStatement.setToDate("05/31/2021");
        Thread.sleep(1000);
        customStatement.setMiniumTransaction("");
        Thread.sleep(1000);
        customStatement.setNumberTranscation("1000000");
        Assertions.assertEquals(customStatement.getMessageMiniumTransaction()," Minium Transaction Value must not be blank","Message");

    }
    @Test
    @DisplayName("TC_008: BLANK Number of Transaction Fiels")
    public void testBlankNumberTransaction() throws InterruptedException {
        CustomStatement customStatement = homePage.clickFormCustom();
        customStatement.setAccountNo("93277");
        Thread.sleep(1000);
        customStatement.setFormDate("05/28/2021");
        Thread.sleep(1000);
        customStatement.setToDate("05/31/2021");
        Thread.sleep(1000);
        customStatement.setMiniumTransaction("100");
        Thread.sleep(1000);
        customStatement.setNumberTranscation("100000");
        Assertions.assertEquals(customStatement.getMessageNumberTransaction()," Number of Transaction must not be blank","Message");

    }
    @Test
    @DisplayName("TC_009: BLANK From Date Fiels")
    public void testBlankFromDate() throws InterruptedException {
        CustomStatement customStatement = homePage.clickFormCustom();
        customStatement.setAccountNo("93277");
        Thread.sleep(1000);
        customStatement.setFormDate("05/28/2021");
        Thread.sleep(1000);
        customStatement.setToDate("");
        Thread.sleep(1000);
        customStatement.setMiniumTransaction("100");
        Thread.sleep(1000);
        customStatement.setNumberTranscation("1000000");
        Assertions.assertEquals(customStatement.getMessageFormDate()," From Date must not be blank","Message");

    }
    @Test
    @DisplayName("TC_010: BLANK To Date Fiels")
    public void testBlankToDate() throws InterruptedException {
        CustomStatement customStatement = homePage.clickFormCustom();
        customStatement.setAccountNo("93277");
        Thread.sleep(1000);
        customStatement.setFormDate("");
        Thread.sleep(1000);
        customStatement.setToDate("05/31/2021");
        Thread.sleep(1000);
        customStatement.setMiniumTransaction("100");
        Thread.sleep(1000);
        customStatement.setNumberTranscation("1000000");
        Assertions.assertEquals(customStatement.getMessageToDate()," To Date must not be blank","Message");

    }
    @Test
    @DisplayName("TC_011: Not Entering All Field")
    public void testAllFiels() throws InterruptedException {
        CustomStatement customStatement = homePage.clickFormCustom();
        customStatement.setAccountNo("");
        Thread.sleep(1000);
        customStatement.setFormDate("");
        Thread.sleep(1000);
        customStatement.setToDate("");
        Thread.sleep(1000);
        customStatement.setMiniumTransaction("");
        Thread.sleep(1000);
        customStatement.setNumberTranscation("");
        CustomStatementDetails customStatementDetails = customStatement.clickSubmit();
        Assertions.assertEquals(customStatementDetails.getAlertText()," Please fill all fields","Message");

    }
    @Test
    @DisplayName("TC_012: Customised Statement")
    public void testReset() throws InterruptedException {
        CustomStatement customStatement = homePage.clickFormCustom();
        CustomStatementDetails customStatementDetails = customStatement.clickSubmit();
    }

    @Test
    @DisplayName("TC_013: Customised Statement home")
    public void testHome() throws InterruptedException {
        CustomStatement customStatement = homePage.clickFormCustom();
        customStatement.clickBtnHome();
    }
}
