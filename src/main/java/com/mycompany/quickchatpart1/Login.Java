// PROG5121 – Programming 1A
// POE Part 1 – Registration and Login Feature
// Student: Ayse Kevser Erdogan
package com.mycompany.quickchatpart1;
/**
 * Login class handles user registration and authentication.
 * Provides methods to validate username, password, and cell phone number.
 *
 * @author Ayse Kevser Erdogan
 // Login validation methods for QuickChat Part 1
 */
public class Login {

    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    
    public Login() {}

    /**
     * Parameterized constructor.
     *
     * @param firstName      User's first name
     * @param lastName       User's last name
     * @param username       Desired username
     * @param password       Desired password
     * @param cellPhoneNumber User's cell phone number
     */
    public Login(String firstName, String lastName, String username, String password, String cellPhoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    // ─── Getters & Setters ────────────────────────────────────────────────────

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getCellPhoneNumber() { return cellPhoneNumber; }
    public void setCellPhoneNumber(String cellPhoneNumber) { this.cellPhoneNumber = cellPhoneNumber; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    // ─── Validation Methods ───────────────────────────────────────────────────

    /**
     * Checks that the username contains an underscore and is no more than 5 characters long.
     *
     * @return true if the username is valid, false otherwise
     */
    public boolean checkUserName() {
        if (username == null) return false;
        return username.contains("_") && username.length() <= 5;
    }

    /**
     * Checks that the password meets complexity requirements:
     * - At least 8 characters long
     * - Contains a capital letter
     * - Contains a number
     * - Contains a special character
     *
     * @return true if the password meets complexity rules, false otherwise
     */
    public boolean checkPasswordComplexity() {
        if (password == null || password.length() < 8) return false;

        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }

        return hasUpper && hasDigit && hasSpecial;
    }

    /**
     * Checks that the cell phone number contains the international country code
     * and is no more than 10 characters (after the + prefix).
     *
     * Uses a regular expression to validate South African and international numbers.
     *
     * Regex adapted from: https://ihateregex.io/expr/phone/
     * Pattern: starts with '+', followed by country code digits, then up to 10 digits total.
     *
     * @return true if the cell phone number is valid, false otherwise
     */
    public boolean checkCellPhoneNumber() {
        if (cellPhoneNumber == null) return false;
        // Regex: must start with '+', followed by 1-3 digit country code, then remaining digits
        // Total digits (excluding '+') must be <= 12 and >= 10.
        // Reference: https://www.oreilly.com/library/view/regular-expressions-cookbook/9781449327453/ch04s02.html
        return cellPhoneNumber.matches("^\\+[0-9]{10,12}$");
    }

    // ─── Registration & Login Methods ────────────────────────────────────────

    /**
     * Registers the user by validating username, password, and cell phone number.
     *
     * @return A message indicating success or the first validation failure encountered
     */
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username " +
                   "contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password " +
                   "contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        return "User registered successfully.";
    }

    /**
     * Verifies that the provided credentials match the stored credentials.
     *
     * @param enteredUsername The username entered during login
     * @param enteredPassword The password entered during login
     * @return true if the credentials match, false otherwise
     */
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        if (username == null || password == null) return false;
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    /**
     * Returns the appropriate login status message.
     *
     * @param enteredUsername The username entered during login
     * @param enteredPassword The password entered during login
     * @return A welcome message on success, or an error message on failure
     */
    public String returnLoginStatus(String enteredUsername, String enteredPassword) {
        if (loginUser(enteredUsername, enteredPassword)) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }
}

