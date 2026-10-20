import java.io.FileWriter;
import java.io.IOException;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
public class Message {
    
    
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;

    // Constructor
    public Message(String messageID, int messageNumber, String recipient, String messageText) {
        this.messageID = messageID;
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        // Generate hash automatically upon creation
        this.messageHash = createMessageHash();
    }

    Message(String string, int i, String string0, String longMsg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters
    public String getMessageID() { return messageID; }
    public String getMessageHash() { return messageHash; }
    public String getRecipient() { return recipient; }
    public String getMessageText() { return messageText; }

    
    public boolean checkMessageID() {
        return this.messageID.length() <= 10;
    }

   
    
    public String checkRecipientCell() {
        if (recipient.matches("^\\+27[0-9]{9,10}$") || recipient.matches("^\\+[0-9]{10,12}$")) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    
    public String createMessageHash() {
        String firstTwo = messageID.substring(0, 2);
        String[] words = messageText.trim().split("\\s+");
        String firstWord = words[0].replaceAll("[^a-zA-Z]", "");
        String lastWord = words[words.length - 1].replaceAll("[^a-zA-Z]", "");
        String hash = firstTwo + ":" + messageNumber + ":" + firstWord + lastWord;
        return hash.toUpperCase();
    }

    public String checkMessageLength() {
        if (messageText.length() <= 250) {
            return "Message ready to send.";
        } else {
            int excess = messageText.length() - 250;
            return "Message exceeds 250 characters by " + excess + "; please reduce the size.";
        }
    }

    public String sentMessage(int choice) {
        switch (choice) {
            case 1: return "Message successfully sent";
            case 2: return "Press 0 to delete the message";
            case 3: 
                storeMessage(); // Calls the JSON method
                return "Message successfully stored";
            default: return "Invalid option";
        }
    }

    
    public String printMessages() {
        return "Message ID: " + messageID + "\n" +
               "Message Hash: " + messageHash + "\n" +
               "Recipient: " + recipient + "\n" +
               "Message: " + messageText;
    }

   
    public void storeMessage() {
        try (FileWriter file = new FileWriter("messages.json", true)) {
            String json = "{\n" +
                    "  \"messageID\": \"" + messageID + "\",\n" +
                    "  \"messageHash\": \"" + messageHash + "\",\n" +
                    "  \"recipient\": \"" + recipient + "\",\n" +
                    "  \"message\": \"" + messageText + "\"\n" + "},\n";
            file.write(json);
            System.out.println(">> Message stored in messages.json file.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the message.");
        }
    }
    
} 
    
    