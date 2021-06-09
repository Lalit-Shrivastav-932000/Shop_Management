package com;


import java.util.regex.Pattern;

public class Validation {

    public static boolean isValidName(String s) {
        return (Pattern.matches("[A-Z]{1}[a-z]{1,19}", s));
    }

    public static boolean isValidPincode(String s) {
        //pincode with length=6 and contains number only
        return (Pattern.matches("[0-9]{6}", s));
    }

    public static boolean isValidContactNo(String s) {
        //contact no. with length=10 and contains number only
        return (Pattern.matches("[0-9]{10}", s));
    }

    String mail = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    String username = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+$";

    public static boolean isValidMail(String s) {
        String mail ="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        return (Pattern.matches(mail, s));
    }
    
    public static boolean isValidUsername(String s) {
    String username = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+$";
        return (Pattern.matches(username, s));
    }
    
}
