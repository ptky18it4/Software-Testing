package new_customer;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;

public class NewCustomerTests extends BaseTest {

    // TODO: 5/31/2021 : Verify Name Field 
    @Test
    @DisplayName("NC1- Name cannot be empty")
    public void NC1() {
        newCustomerPage.setCustomerName(String.valueOf(Keys.TAB));
        String message = newCustomerPage.getMessage("message");
        Assertions.assertTrue(message.contains("Customer name must not be blank"), "Result: ");
    }

    @Test
    @DisplayName("NC2- Name cannot be numeric")
    public void NC2() {
        List<String> listName = new ArrayList<>();
        listName.add("1234");
        listName.add("name123");
        listName.forEach((element) -> {
            newCustomerPage.setCustomerName(element);
            String message = newCustomerPage.getMessage("message");
            Assertions.assertTrue(message.contains("Numbers are not allowed"), "Result: ");
        });

    }

    @DisplayName("NC3- Name cannot have special characters")
    @ParameterizedTest
    @ValueSource(strings = {"name!@#", "!@#"})
    public void NC3(String input) {
        // input: parameter in strings of @ValueSource
        newCustomerPage.setCustomerName(input);
        String message = newCustomerPage.getMessage("message");
        Assertions.assertTrue(message.contains("Special characters are not allowed"), "Result: ");
    }

    @Test
    @DisplayName("NC4- Name cannot have first character as blank space")
    public void NC4() {
        newCustomerPage.setCustomerName(" ");
        String message = newCustomerPage.getMessage("message");
        Assertions.assertTrue(message.contains("First character can not have space"), "Result: ");
    }

    // TODO: 5/31/2021 : Verify Address Field 
    @Test
    @DisplayName("NC5- Address cannot be empty")
    public void NC5() {
        newCustomerPage.setAddressTxt(String.valueOf(Keys.TAB));
        String message = newCustomerPage.getMessage("message3");
        Assertions.assertTrue(message.contains("Address Field must not be blank"), "Result: ");
    }

    @Test
    @DisplayName("NC4- Address cannot have first blank space")
    public void NC6() {
        newCustomerPage.setAddressTxt(" ");
        String message = newCustomerPage.getMessage("message3");
        Assertions.assertTrue(message.contains("First character can not have space"), "Result: ");
    }

    // TODO: 5/31/2021 : Verify City Field
    @Test
    @DisplayName("NC8-City not be empty")
    public void NC8() {
        newCustomerPage.setCityTxt(String.valueOf(Keys.TAB));
        String message = newCustomerPage.getMessage("message4");
        Assertions.assertTrue(message.contains("City Field must not be blank"), "Result: ");
    }

    @DisplayName("NC9- Name cannot be numeric")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "city123"})
    public void NC9(String input) {
        newCustomerPage.setCityTxt(input);
        String message = newCustomerPage.getMessage("message4");
        Assertions.assertTrue(message.contains("Numbers are not allowed"), "Result: ");
    }

    /* Chú ý, ở đây chúng ta bỏ annotation @Test nha.
     * Để hiểu rõ hơn về @Test và @ParameterizedTest thì bạn nên đọc thêm tài liệu về nó.*/
    @DisplayName("NC10- Name cannot have special characters")
    @ParameterizedTest
    @ValueSource(strings = {"City!@#", "!@#"})
    public void NC10(String input) {
        newCustomerPage.setCityTxt(input);
        String message = newCustomerPage.getMessage("message4");
        Assertions.assertTrue(message.contains("Special characters are not allowed"), "Result: ");
    }

    @Test
    @DisplayName("NC11- Name cannot have first character as blank space")
    public void NC11() {
        newCustomerPage.setCityTxt(" ");
        String message = newCustomerPage.getMessage("message4");
        Assertions.assertTrue(message.contains("First character can not have space"), "Result: ");
    }

    // TODO: 5/31/2021 : Verify State Field
    @Test
    @DisplayName("NC12- State cannot be empty")
    public void NC12() {
        newCustomerPage.setStateTxt(String.valueOf(Keys.TAB));
        String message = newCustomerPage.getMessage("message5");
        Assertions.assertTrue(message.contains("State must not be blank"), "Result: ");
    }

    @DisplayName("NC13- Sate cannot be numeric")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "State123"})
    public void NC13(String input) {
        newCustomerPage.setStateTxt(input);
        String message = newCustomerPage.getMessage("message5");
        Assertions.assertTrue(message.contains("Numbers are not allowed"), "Result: ");
    }

    @DisplayName("NC14- State cannot have special characters")
    @ParameterizedTest
    @ValueSource(strings = {"State!@#", "!@#"})
    public void NC14(String input) {
        newCustomerPage.setStateTxt(input);
        String message = newCustomerPage.getMessage("message5");
        Assertions.assertTrue(message.contains("Special characters are not allowed"), "Result: ");
    }

    @Test
    @DisplayName("NC15- State cannot have first character as blank space")
    public void NC15() {
        newCustomerPage.setStateTxt(" ");
        String message = newCustomerPage.getMessage("message5");
        Assertions.assertTrue(message.contains("First character can not have space"), "Result: ");
    }

    // TODO: 5/31/2021 : Verify PIN Field
    @DisplayName("NC16- PIN must be numeric")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "1234PIN"})
    public void NC16(String input) {
        newCustomerPage.setPinTxt(input);
        String message = newCustomerPage.getMessage("message6");
        String expect1 = "PIN Code must have 6 Digits";
        String expect2 = "Characters are not allowed";
        if (message.equals(expect1)) {
            Assertions.assertTrue(message.contains(expect1), "Result: ");
        } else if (message.equals(expect2)) {
            Assertions.assertTrue(message.contains(expect2), "Result: ");
        }
    }

    @Test
    @DisplayName("NC17- Pin cannot be empty")
    public void NC17() {
        newCustomerPage.setPinTxt(String.valueOf(Keys.TAB));
        String message = newCustomerPage.getMessage("message6");
        Assertions.assertTrue(message.contains("PIN Code must not be blank"), "Result: ");
    }

    @DisplayName("NC18- PIN must have 6 digits")
    @ParameterizedTest
    @ValueSource(strings = {"12", "123"})
    public void NC18(String input) {
        newCustomerPage.setPinTxt(input);
        String message = newCustomerPage.getMessage("message6");
        Assertions.assertTrue(message.contains("PIN Code must have 6 Digits"), "Result: ");
    }

    @DisplayName("NC19- PIN cannot have special character")
    @ParameterizedTest
    @ValueSource(strings = {"!@#", "123!@#"})
    public void NC19(String input) {
        newCustomerPage.setPinTxt(input);
        String message = newCustomerPage.getMessage("message6");
        Assertions.assertTrue(message.contains("Special characters are not allowed"), "Result: ");
    }

    @Test
    @DisplayName("NC20- PIN cannot have first blank space")
    public void NC20() {
        newCustomerPage.setPinTxt(" ");
        String message = newCustomerPage.getMessage("message6");
        Assertions.assertTrue(message.contains("First character can not have space"), "Result: ");
    }

    // TODO: 5/31/2021 : Verify Telephone Field
    @Test
    @DisplayName("NC22- Telephone cannot be empty")
    public void NC22() {
        newCustomerPage.setMobileNumberTxt(String.valueOf(Keys.TAB));
        String message = newCustomerPage.getMessage("message7");
        Assertions.assertTrue(message.contains("Mobile no must not be blank"), "Result: ");
    }

    @Test
    @DisplayName("NC23- Telephone cannot have first character as blank space")
    public void NC23() {
        newCustomerPage.setMobileNumberTxt(" ");
        String message = newCustomerPage.getMessage("message7");
        Assertions.assertTrue(message.contains("First character can not have space"), "Result: ");
    }

    @Test
    @DisplayName("NC24- Telephone cannot have spaces")
    public void NC24() {
        newCustomerPage.setMobileNumberTxt("123 123");
        String message = newCustomerPage.getMessage("message7");
        Assertions.assertTrue(message.contains("Characters are not allowed"), "Result: ");
    }

    @DisplayName("NC25- Telephone cannot have special character")
    @ParameterizedTest
    @ValueSource(strings = {"886636!@12", "!@88662682", "88663682!@"})
    public void NC25(String input) {
        newCustomerPage.setMobileNumberTxt(input);
        String message = newCustomerPage.getMessage("message7");
        Assertions.assertTrue(message.contains("Special characters are not allowed"), "Result: ");
    }

    // TODO: 5/31/2021 : Verify Email Field
    @Test
    @DisplayName("NC26- Email cannot be empty")
    public void NC26() {
        newCustomerPage.setEmailTxt(String.valueOf(Keys.TAB));
        String message = newCustomerPage.getMessage("message9");
        Assertions.assertTrue(message.contains("Email-ID must not be blank"), "Result: ");
    }

    @DisplayName("NC27- Email must be in correct format")
    @ParameterizedTest
    @ValueSource(strings = {"trungky00@gmail", "trungky00", "Trungky00@", "trungky00@gmail.", "trungky00gmail.com"})
    public void NC27(String input) {
        newCustomerPage.setEmailTxt(input);
        String message = newCustomerPage.getMessage("message9");
        Assertions.assertTrue(message.contains("Email-ID is not valid"), "Result: ");
    }

    @Test
    @DisplayName("NC29- Email cannot have space")
    public void NC29() {
        newCustomerPage.setEmailTxt(" ");
        String message = newCustomerPage.getMessage("message9");
        Assertions.assertTrue(message.contains("First character can not have space"), "Result: ");
    }
}
