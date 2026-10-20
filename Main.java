package prog5121poe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static final List<Message> sentMessages = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("--- QuickChat Login ---");
        String firstName = "Kyle"; // Simulated successful login
        System.out.println("Welcome " + firstName + ", it is great to see you again.\n");
        System.out.println("Welcome to QuickChat.");
        
        boolean quit = false;
        while (!quit) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Choose an option: ");
            
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    handleSendingMessages();
                    break;
                case "2":
                    System.out.println("Coming Soon.");
                    break;
                case "3":
                    System.out.println("Exiting QuickChat. Goodbye!");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        }
        scanner.close();
    }

    private static void handleSendingMessages() {
        System.out.print("How many messages do you want to send? ");
        int numMessages;
        try {
            numMessages = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered.");
            return;
        }

       
        for (int i = 1; i <= numMessages; i++) {
            System.out.println("\n--- Message " + i + " of " + numMessages + " ---");
            
            long idNum = 1000000000L + (long)(random.nextDouble() * 9000000000L);
            String messageID = String.valueOf(idNum);

            System.out.print("Enter recipient number (e.g., +27831234567): ");
            String recipient = scanner.nextLine();
            System.out.print("Enter your message: ");
            String messageText = scanner.nextLine();

            Message msg = new Message(messageID, i, recipient, messageText);
            
            System.out.println(">> " + msg.checkRecipientCell());
            System.out.println(">> " + msg.checkMessageLength());

            if (msg.checkRecipientCell().contains("successfully") && msg.checkMessageLength().contains("ready")) {
                
                System.out.println("\nOptions:");
                System.out.println("1 - Send Message");
                System.out.println("2 - Disregard Message");
                System.out.println("3 - Store Message to send later");
                System.out.print("Choice: ");
                int action = Integer.parseInt(scanner.nextLine());

                String result = msg.sentMessage(action);
                System.out.println(">> " + result);
                if (action == 1) {
                    sentMessages.add(msg);
                    System.out.println("\n--- Message Details ---");
                    System.out.println(msg.printMessages());
                }
            }
        }

        System.out.println("\n=================================");
        System.out.println("Total messages sent this session: " + sentMessages.size());
        System.out.println("=================================");
    }

    private static class Message {

        public Message() {
        }

        private Message(String messageID, int i, String recipient, String messageText) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private String checkRecipientCell() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private String checkMessageLength() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private String sentMessage(int action) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private boolean printMessages() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}