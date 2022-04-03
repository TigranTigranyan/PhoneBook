package com.company.services;

import java.util.regex.Pattern;

public class Validator {

    //    public static boolean isValidNum(String strNum) {
//        for (int i = 1; i <= strNum.length(); i++) {
//            if (strNum.charAt(i) >= '0' && strNum.charAt(i) <= '9') {
//                return true;
//            }
//        }
//        return false;
//    }
    public static boolean isValidNum(String phoneNumber) {
        if (phoneNumber == null) {
            return false;
        }
        return phoneNumber.matches("[0-9]+");
    }

    public static Boolean isValidName(String name) {
        if (name == null) {
            return false;
        }
        return name.length() >= 2 && name.length() <= 20;
    }


    private static final Pattern PATTERN_GLOBAL_EMAIL = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)");
    public static boolean isValidEmail(String email) {
        final Pattern PATTERN_OTHER = Pattern.compile("^[A-Za-z0-9+_.-]+@");
        final Pattern PATTERN_GMAIL = Pattern.compile("^[A-Za-z0-9+_.-]+@gmail.com");
        final Pattern PATTERN_ICLOUD = Pattern.compile("^[A-Za-z0-9+_.-]+@icloud.com");

        return email.matches(PATTERN_GLOBAL_EMAIL.pattern());
    }

    public static Boolean isValidCompanyName(String compName) {
        if (compName == null) {
            return false;
        }
        return compName.length() >= 2 && compName.length() <= 40;
    }


}
