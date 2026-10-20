/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poepart1;

/**
 *
 * @author Student
 */
public class Registration{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    private String username;
    private String password;
    private String cellphone;
    private String firstName;
    private String lastName;

    public boolean checkUserName(String username) {
        // Must contain underscore and <= 5 characters
        if (username.contains("_") && username.length() <= 5) {
            return true;
        }
        return false;
    }

    public boolean checkPasswordComplexity(String password) {
        // Regex: 8 chars, 1 capital, 1 number, 1 special char
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$";
        return password.matches(regex);
    }

    public boolean checkCellPhoneNumber(String cellphone) {
        // Must start with international code + and not more than 10 digits after +27
        // Accepts +27xxxxxxxxx (12 chars total)
        String regex = "^\\+27\\d{9}$";
        return cellphone.matches(regex);
    }

    public String registerUser(String username, String password, String cellphone, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.cellphone = cellphone;
        this.firstName = firstName;
        this.lastName = lastName;

        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        
        if (!checkCellPhoneNumber(cellphone)) {
            return "Cell phone number is incorrectly formatted or does not contain an international code, please correct the number and try again.";
        }
        
        return "User has been registered successfully.";
    }

    // Getters - NEEDED for Login.java
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCellphone() {
        return cellphone;
    }
}  

