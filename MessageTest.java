/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class MessageTest {
    
    public MessageTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testMessageLengthSuccess() {
        Message msg = new Message("1234567890", 1, "+27718693002", "Short message");
        assertEquals("Message ready to send.", msg.checkMessageLength());
    }

    @Test
    public void testMessageLengthFailure() {
        // Create a string longer than 250 characters
        String longMsg = "A".repeat(260); 
        Message msg = new Message("1234567890", 1, "+27718693002", longMsg);
        assertEquals("Message exceeds 250 characters by 10; please reduce the size.", msg.checkMessageLength());
    }

  
    @Test
    public void testCellPhoneSuccess() {
        Message msg = new Message("1234567890", 1, "+27718693002", "Test");
        assertEquals("Cell phone number successfully captured.", msg.checkRecipientCell());
    }

    @Test
    public void testCellPhoneFailure() {
        Message msg = new Message("1234567890", 1, "08575975889", "Test");
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.", msg.checkRecipientCell());
    }

    
    @Test
    public void testHashGeneration() {
    
        Message msg = new Message("0012345678", 0, "+27718693002", "HI THANKS");
        assertEquals("00:0:HITHANKS", msg.createMessageHash());
    }
}
    
    
    

