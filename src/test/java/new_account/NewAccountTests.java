package new_account;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.Keys;

public class NewAccountTests extends BaseTest {

    // TODO: 5/31/2021 :Verify Customer id
    @Test
    @DisplayName("NA1- Customer id cannot be empty")
    public void NA1() {
        newAccountPage.setCustomerIdTxt(String.valueOf(Keys.TAB));
        String message = newAccountPage.getMessage("message14");
        Assertions.assertTrue(message.contains("Customer ID is required"), "Result: ");
    }

    @DisplayName("NA2- Customer id must be numeric")
    @ParameterizedTest
    @ValueSource(strings = {"1234Acc", "Acc123"})
    public void NA2(String input) {
        newAccountPage.setCustomerIdTxt(input);
        String message = newAccountPage.getMessage("message14");
        Assertions.assertTrue(message.contains("Characters are not allowed"), "Result: ");
    }

    @DisplayName("NA3- Customer id cannot have special character")
    @ParameterizedTest
    @ValueSource(strings = {"123!@#", "!@#"})
    public void NA3(String input) {
        newAccountPage.setCustomerIdTxt(input);
        String message = newAccountPage.getMessage("message14");
        Assertions.assertTrue(message.contains("Special characters are not allowed"), "Result: ");
    }

    @Test
    @DisplayName("NA4- Customer id cannot have blank space")
    public void NA4() {
        newAccountPage.setCustomerIdTxt("123 12");
        String message = newAccountPage.getMessage("message14");
        Assertions.assertTrue(message.contains("Characters are not allowed"), "Result: ");
    }

    @Test
    @DisplayName("NA5- First Character cannot be space")
    public void NA5() {
        newAccountPage.setCustomerIdTxt(" ");
        newAccountPage.setCustomerIdTxt(String.valueOf(Keys.TAB));
        String message = newAccountPage.getMessage("message14");
        Assertions.assertTrue(message.contains("First character can not have space"), "Result: ");
    }

    // TODO: 5/31/2021 :Verify Initial Deposit
    @Test
    @DisplayName("NA6- Cannot be empty")
    public void NA6() {
        newAccountPage.setInitialDepositTxt(String.valueOf(Keys.TAB));
        String message = newAccountPage.getMessage("message19");
        Assertions.assertTrue(message.contains("Initial Deposit must not be blank"), "Result: ");
    }

    @DisplayName("NA7- Must be numeric")
    @ParameterizedTest
    @ValueSource(strings = {"1234Acc", "Acc123"})
    public void NA7(String input) {
        newAccountPage.setInitialDepositTxt(input);
        String message = newAccountPage.getMessage("message19");
        Assertions.assertTrue(message.contains("Characters are not allowed"), "Result: ");
    }

    @DisplayName("NA8- Customer id cannot have special character")
    @ParameterizedTest
    @ValueSource(strings = {"123!@#", "!@#"})
    public void NA8 (String input) {
        newAccountPage.setInitialDepositTxt(input);
        String message = newAccountPage.getMessage("message14");
        Assertions.assertTrue(message.contains("Special characters are not allowed"), "Result: ");
    }

    @Test
    @DisplayName("NA9- Customer id cannot have blank space")
    public void NA9() {
        newAccountPage.setInitialDepositTxt("123 12");
        String message = newAccountPage.getMessage("message14");
        Assertions.assertTrue(message.contains("Characters are not allowed"), "Result: ");
    }

    @Test
    @DisplayName("NA10- First Character cannot be space")
    public void NA10() {
        newAccountPage.setInitialDepositTxt(" ");
        newAccountPage.setInitialDepositTxt(String.valueOf(Keys.TAB));
        String message = newAccountPage.getMessage("message19");
        Assertions.assertTrue(message.contains("Characters are not allowed"), "Result: ");
    }


}
