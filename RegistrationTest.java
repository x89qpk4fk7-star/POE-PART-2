

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegistrationTest {
    
    Registration reg = new Registration();
    
    @Test
    public void testCheckUserNameCorrectlyFormatted() {
        System.out.println("Check username with underscore and <=5 chars");
        String username = "kyl_1";
        boolean result = reg.checkUserName(username);
        assertTrue(result);
    }
    
    @Test
    public void testCheckUserNameIncorrectlyFormatted() {
        System.out.println("Check username without underscore");
        String username = "kyle!!!!!!!";
        boolean result = reg.checkUserName(username);
        assertFalse(result);
    }
    
    @Test
    public void testCheckPasswordComplexitySuccess() {
        System.out.println("Check password meets complexity");
        String password = "Ch&&sec@ke99!";
        boolean result = reg.checkPasswordComplexity(password);
        assertTrue(result);
    }
    
    @Test
    public void testCheckPasswordComplexityFailure() {
        System.out.println("Check password fails complexity");
        String password = "password";
        boolean result = reg.checkPasswordComplexity(password);
        assertFalse(result);
    }
    
    @Test
    public void testCheckCellPhoneNumberCorrect() {
        System.out.println("Check cell with +27 and 10 digits");
        String cell = "+27838968976";
        boolean result = reg.checkCellPhoneNumber(cell);
        assertTrue(result);
    }
    
    @Test
    public void testCheckCellPhoneNumberIncorrect() {
        System.out.println("Check cell without country code");
        String cell = "08966553";
        boolean result = reg.checkCellPhoneNumber(cell);
        assertFalse(result);
    }
    
    @Test
    public void testRegisterUserSuccess() {
        System.out.println("Test successful registration");
        String result = reg.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        // Should contain success message
        assertTrue(result.contains("successfully"));
    }
    
    @Test
    public void testRegisterUserFailure() {
        System.out.println("Test failed registration");
        String result = reg.registerUser("kyle!!!!!!!", "password", "08966553");
        // Should contain failure reason
        assertTrue(result.contains("Username") || result.contains("Password") || result.contains("Cell"));
    }
}
/**
 *
 * @author Student
 */
public class RegistrationTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
