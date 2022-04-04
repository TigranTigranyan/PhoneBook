package com.company;

import com.company.controller.Controller;
import com.company.model.Email;
import com.company.model.EmailType;
import com.company.model.Number;
import com.company.model.PhoneNumberType;
import com.company.services.Validator;
import org.json.simple.JSONObject;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static com.company.Main.ANSI_BLUE;
import static com.company.Main.start;
import static com.company.helper.*;

public class GUI {
    static Scanner sc = new Scanner(System.in);
    static Controller controller = new Controller();
    static JSONObject employeeDetails = new JSONObject();
    static JSONObject employeeObject = new JSONObject();

    public static void addNewContact() {
        System.out.println("Enter name");
        String name = sc.next();
        addName(name);

        System.out.println("Enter number");
        String number = sc.next();
        addNumber(number);


        List<Number> numbers = new LinkedList<>();
        numbers.add(new Number(number, selectPhoneNumberType()));




        System.out.println("Add email");
        String email = sc.next();
        addEmail(email);

        List<Email> emails = new LinkedList<>();
        emails.add(new Email(email, selectEmailType()));


        String company = "";

        boolean isCorrectAnswer = false;

        while (!isCorrectAnswer) {
            System.out.println(ANSI_BLUE+"Add Company Y/N");
            String answer = sc.next();
            switch (answer) {

                case "Y":
                    System.out.println(ANSI_BLUE+"Insert company name");
                    company = sc.next();
                    isCorrectAnswer = true;
                    break;

                case "N":
                    isCorrectAnswer = true;
                    break;
                default:
                    start();
            }
        }


        controller.create(name, numbers, emails, company);

    }

    public static void addNumberInExisting() {
        System.out.println(controller.getAllNames());
        if (controller.getAllNames()== "") {
            start();
        }
        else {
            System.out.println("Choose contact");
            String name = sc.next();

            System.out.println("Add number");
            String number = sc.next();
            if (!Validator.isValidNum(number)){
                System.out.println(ANSI_RED+"Is nut valid number:");
                addNumberInExisting();
            }

            controller.addNumberInExisting(name, number, selectPhoneNumberType());
        }
    }

    public void addEmailInExisting() {
        if (controller.getAllNames()== "") {
            start();
        }
            System.out.println(controller.getAllNames());
            System.out.println("Choose contact");
            String name = sc.next();

            System.out.println("Add email");
            String email = sc.next();
            if (!Validator.isValidEmail(email)){
                System.out.println(ANSI_RED+"Is not valid email try again");
                addEmailInExisting();
            }

            controller.addEmailInExisting(name, email, selectEmailType());
    }

    public void showAll() {
        controller.showAll();
    }

    public void delete() {
        System.out.println(controller.getAllNames());
        if (controller.getAllNames()== "") {
            start();
        }

        System.out.println("Choose contact");
        String name = sc.next();
        controller.delete(name);
    }
    public void updateExistingNumber() {
        System.out.println(controller.getAllNames());
        if (controller.getAllNames()== "") {
            start();
        }
        System.out.println("Choose contact");
        String name = sc.next();

        System.out.println(controller.showUserAllNumber(name));

        System.out.println("What row you want update?");
        int index = sc.nextInt();

        System.out.println("Add new number");
        String number = sc.next();
        if (!Validator.isValidNum(number)){
            System.out.println(ANSI_RED+"Is not valid num: try again");
            updateExistingNumber();
        }

        controller.update(name, number, selectPhoneNumberType(), index);
    }

    static PhoneNumberType selectPhoneNumberType() {
        System.out.println("Choose number type");
        System.out.println("""
                1: HOME
                2: SCHOOL
                3: WORK
                4: MOBILE
                """);
        int numberType = sc.nextInt();
        PhoneNumberType phoneNumberType = null;
        switch (numberType) {
            case 1:
                phoneNumberType = PhoneNumberType.HOME;
                break;
            case 2:
                phoneNumberType = PhoneNumberType.SCHOOL;
                break;
            case 3:
                phoneNumberType = PhoneNumberType.WORK;
                break;
            case 4:
                phoneNumberType = PhoneNumberType.MOBILE;
                break;
            default:
                System.out.println("No such type");
                selectPhoneNumberType();
        }
        return phoneNumberType;
    }

    private static EmailType selectEmailType() {
        System.out.println("Add email type");
        System.out.println("""
                1: GMAIL
                2: ICLOUD
                3: OTHER
                """);
        int email = sc.nextInt();
        EmailType emailType = null;
        switch (email) {
            case 1:
                emailType = EmailType.GMAIL;
                break;
            case 2:
                emailType = EmailType.ICLOUD;
                break;
            case 3:
                emailType = EmailType.OTHER;
                break;
            default:
                System.out.println("No such type");
                selectEmailType();
        }
        return emailType;
    }


}
//texapoxel urish klassi mej

  class helper {
      public static final String ANSI_RED = "\u001B[31m";
    static Scanner sc=new Scanner(System.in);
    public static String addName(String name){
        if (!Validator.isValidName(name)){
        }
        return name;
    }
    public static String  addNumber(String number) {
        if (!Validator.isValidNum(number)){
            System.out.println(ANSI_RED+"is Not valid number: try again");
            addName(sc.next());
        }
        return number;
    }
    public static String addEmail(String email){
        if (!Validator.isValidEmail(email)){
            System.out.println(ANSI_RED+"is Not valid email:");
        }
        return email;
    }
    public static String addCompany(String compName){
        if (!Validator.isValidCompanyName(compName)){
            addCompany(compName);
        }
        return compName;
    }
}

