package com.mycompany.quickchatpart1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login loginUser = new Login();

        System.out.println("=== QuickChat Registration ===\n");

        System.out.print("Enter your first name: ");
        loginUser.setFirstName(scanner.nextLine().trim());

        System.out.print("Enter your last name: ");
        loginUser.setLastName(scanner.nextLine().trim());

        // Username loop
        while (!loginUser.checkUserName()) {
            System.out.print("Enter a username: ");
            loginUser.setUsername(scanner.nextLine().trim());
            if (loginUser.checkUserName()) {
                System.out.println("Username successfully captured.");
            } else {
                System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
            }
        }

        // Password loop
        while (!loginUser.checkPasswordComplexity()) {
            System.out.print("Enter a password: ");
            loginUser.setPassword(scanner.nextLine().trim());
            if (loginUser.checkPasswordComplexity()) {
                System.out.println("Password successfully captured.");
            } else {
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            }
        }

        // Cell phone loop
        while (!loginUser.checkCellPhoneNumber()) {
            System.out.print("Enter cell phone number (e.g. +27838968976): ");
            loginUser.setCellPhoneNumber(scanner.nextLine().trim());
            if (loginUser.checkCellPhoneNumber()) {
                System.out.println("Cell phone number successfully added.");
            } else {
                System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
            }
        }

        System.out.println("\nRegistration complete!\n");

        // Login
        System.out.println("=== QuickChat Login ===\n");
        boolean loggedIn = false;
        int attempts = 0;
        while (!loggedIn && attempts < 3) {
            System.out.print("Username: ");
            String u = scanner.nextLine().trim();
            System.out.print("Password: ");
            String p = scanner.nextLine().trim();
            System.out.println(loginUser.returnLoginStatus(u, p));
            loggedIn = loginUser.loginUser(u, p);
            attempts++;
        }

        scanner.close();
    }
}
