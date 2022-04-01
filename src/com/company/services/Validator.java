package com.company.services;

import com.company.model.EmailType;
import com.company.model.User;

import java.util.regex.Pattern;

public class Validator {

    public static boolean isValidNum(String strNum) {
        for (int i = 1; i <= strNum.length(); i++) {
            if (strNum.charAt(i) >= '0' && strNum.charAt(i) <= '9') {
                return true;
            }
        }
        return false;
    }

    public static Boolean isValidName(String strName) {
        if (strName== null || strName.length()==0){
        return false;
        }
        return strName.length()>=2 && strName.length()<=20;
    }



    private static final Pattern PATTERN_GLOBAL_EMAIL = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    public static boolean isValidEmail(String email) {
        final Pattern PATTERN_EMAIL = Pattern.compile("^[A-Za-z0-9+_.-]+@gmail.com");
        final Pattern PATTERN_GMAIL = Pattern.compile("^[A-Za-z0-9+_.-]+@icloud.com");
        final Pattern PATTERN_ICLOUD = Pattern.compile("^[A-Za-z0-9+_.-]+@other.com");

        return email.matches(PATTERN_GLOBAL_EMAIL.pattern());
    }
    public static Boolean isValidCompanyName(String strName) {
        if (strName== null || strName.length()==0){
            return false;
        }
        return strName.length()>=2 && strName.length()<=40;
    }



}
