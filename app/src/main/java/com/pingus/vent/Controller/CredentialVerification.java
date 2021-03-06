package com.pingus.vent.Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Darren on 3/5/2017.
 * Verifies the username and password of the user when logging in
 */

public class CredentialVerification {

    private static final Pattern p = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z" +
            "0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x07\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b" +
            "\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(gatech.edu|GATECH.EDU)");

    /**
     * Verifies the email
     * @param email the email to verify
     * @return boolean true if passed, false if not
     */
    public static boolean verifyEmail(String email) {
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * Verifies the password
     * @param password the password to verify
     * @return String the hashed message
     */
    public static String verifyPassword(String password) {
        String message = "";
        boolean length = password.length() >= 8;
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasNumber = password.matches(".*\\d+.*");

        message += (!length) ? "Password is too short" : "";
        message += (!hasUppercase) ? "\nPassword does not contain an uppercase" : "";
        message += (!hasLowercase) ? "\nPassword does not contain a lowercase" : "";
        message += (!hasNumber) ? "\nPassword does not contain a number" : "";

        return message;
    }
}


