package com.mycompany.quickchatpart1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testUsernameCorrect() {
        Login login = new Login();
        login.setUsername("kyl_1");
        assertTrue(login.checkUserName());
    }

    @Test
    public void testUsernameIncorrect() {
        Login login = new Login();
        login.setUsername("kyle123");
        assertFalse(login.checkUserName());
    }

    @Test
    public void testPasswordCorrect() {
        Login login = new Login();
        login.setPassword("Abc@1234");
        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    public void testPasswordIncorrect() {
        Login login = new Login();
        login.setPassword("password");
        assertFalse(login.checkPasswordComplexity());
    }

    @Test
    public void testCellPhoneCorrect() {
        Login login = new Login();
        login.setCellPhoneNumber("+27838968976");
        assertTrue(login.checkCellPhoneNumber());
    }

    @Test
    public void testCellPhoneIncorrect() {
        Login login = new Login();
        login.setCellPhoneNumber("0838968976");
        assertFalse(login.checkCellPhoneNumber());
    }
}
