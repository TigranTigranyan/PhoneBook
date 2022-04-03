package com.company;

import com.company.services.Validator;

import java.util.Scanner;

public class Helper {

    public static final String ANSI_RED = "\u001B[31m";
    static Scanner sc = new Scanner(System.in);

    public static String addName(String name) {
        while (!Validator.isValidName(name)) {
            System.out.println(ANSI_RED + "is Not valid name: try again");
            name = sc.next();
        }
        return name;
    }

    public static String addNumber(String number) {
        while (!Validator.isValidNum(number)) {
            System.out.println(ANSI_RED + "is Not valid number: try again");
            number = sc.next();
        }
        return number;
    }

    public static String addEmail(String email) {
        while (!Validator.isValidEmail(email)) {
            System.out.println(ANSI_RED + "is Not valid email, try again");
            email = sc.next();
        }
        return email;
    }

    public static String addCompany(String compName) {
        while (!Validator.isValidCompanyName(compName)) {
            System.out.println(ANSI_RED + "is Not valid company name, try again");
            compName = sc.next();
        }
        return compName;
    }
}

