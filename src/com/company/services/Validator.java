package services;

import java.util.regex.Pattern;

public class Validator {

    public static boolean isNotValidNum(String phoneNumber) {
        if (phoneNumber == null) {
            return true;
        }
        return !phoneNumber.matches("[0-9]+");
    }

    public static Boolean isNotValidName(String name) {
        if (name == null) {
            return true;
        }
        return !(name.length() >= 2 && name.length() <= 20);
    }


    private static final Pattern PATTERN_GLOBAL_EMAIL = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)");

    public static boolean isNotValidEmail(String email) {
        final Pattern PATTERN_OTHER = Pattern.compile("^[A-Za-z0-9+_.-]+@");
        final Pattern PATTERN_GMAIL = Pattern.compile("^[A-Za-z0-9+_.-]+@gmail.com");
        final Pattern PATTERN_ICLOUD = Pattern.compile("^[A-Za-z0-9+_.-]+@icloud.com");

        return !(email.matches(PATTERN_GLOBAL_EMAIL.pattern()));
    }

    public static Boolean isNotValidCompanyName(String compName) {
        if (compName == null) {
            return true;
        }
        return !(compName.length() >= 2 && compName.length() <= 40);
    }


}
