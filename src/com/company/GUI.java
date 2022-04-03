package com.company;

import com.company.controller.Controller;
import com.company.model.Email;
import com.company.model.EmailType;
import com.company.model.Number;
import com.company.model.PhoneNumberType;
import com.company.services.Validator;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static com.company.Main.ANSI_BLUE;
import static com.company.Main.start;
import static com.company.helper.*;

public class GUI {
    static Scanner sc = new Scanner(System.in);
    static Controller controller = new Controller();

    public static void start() {
        Scanner sc = new Scanner(System.in);
        GUI gui = new GUI();
        boolean condition = true;

        System.out.println("Add new contact");
        gui.addNewContact();

        while (condition) {
            System.out.println("""
                    press 1: Add new contact
                    press 2: Add new number in existing contact
                    press 3: Update existing number
                    press 4: Add email in existing contact
                    press 5: Update existing Email
                    press 6: Show all contacts
                    press 7: Show all contacts with all info
                    press 8: Delete contact
                    press 0: Exit
                    """);
            int command = sc.nextInt();

            switch (command) {
                case 1:
                    gui.addNewContact();
                    break;
                case 2:
                    gui.addNumberInExistingContact();
                    break;
                case 3:
                    gui.updateExistingNumber();
                    break;
                case 4:
                    gui.addEmailInExistingContact();
                    break;
                case 5:
                    gui.updateExistingEMail();
                    break;
                case 6:
                    System.out.println("Contacts:\n" + controller.allNames());
                    break;
                case 7:
                    gui.showContactsInfo();
                    break;
                case 8:
                    gui.delete();
                    break;
                case 0:
                    condition = false;
                    break;
                default:
                    break;
            }
        }
    }

    public void addNewContact() {

    public static void addNewContact() {
        System.out.println("Enter name");
        String name = sc.next();
        addName(name);

        System.out.println("Enter phone number");
        String number = sc.next();
        addNumber(number);

        List<Number> numbers = new LinkedList<>();
        numbers.add(new Number(number, selectPhoneNumberType()));




        System.out.println("Add email");
        System.out.println("Enter email");
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

        System.out.println("Enter company name");
        String company = sc.next();

        controller.create(name, numbers, emails, company);

    }

    public void addNumberInExistingContact() {
        System.out.println(controller.allNames());
        System.out.println("Choose contact");
        String name = sc.next();
    public void addNumberInExisting() {
        System.out.println(controller.getAllNames());
        if (controller.getAllNames()== "") {
            start();
        }
        else {
            System.out.println("Choose contact");
            String name = sc.next();

        System.out.println("Enter phone number");
        String number = sc.next();
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
        System.out.println(controller.getAllNames());
        System.out.println("Choose contact");
        String name = sc.next();

        System.out.println("Add email");
        String email = sc.next();

            controller.addEmailInExisting(name, email, selectEmailType());
    }

    public void showContactsInfo() {
        controller.showAllInfo();
    }

    public void delete() {
        System.out.println(controller.getAllNames());

        System.out.println("Choose contact");
        String name = sc.next();

        controller.delete(name);
    }
    public void updateExistingNumber() {
        System.out.println(controller.getAllNames());

        System.out.println("Choose contact");
        String name = sc.next();

        System.out.println(controller.showAllNumbersOfAUser(name));

        System.out.println("Which row do you want to update?");
        int index = sc.nextInt();

        System.out.println("Add new number");
        String number = sc.next();
        if (!Validator.isValidNum(number)){
            System.out.println(ANSI_RED+"Is not valid num: try again");
            updateExistingNumber();
        }

        controller.updateNumber(name, number, selectPhoneNumberType(), index);
    }

    public void updateExistingEMail() {
        System.out.println(controller.allNames());

        System.out.println("Choose contact");
        String name = sc.next();

        System.out.println(controller.showAllEMailsOfAUser(name));

        System.out.println("Which row do you want to update?");
        int index = sc.nextInt();

        System.out.println("Add new Email");
        String email = sc.next();

        controller.updateEmail(name, email, selectEmailType(), index);
    }

    private static PhoneNumberType selectPhoneNumberType() {
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
        EmailType emailType = null;
        boolean inputIsWrong = true;
        while (inputIsWrong) {
            System.out.println("Add email type");
            System.out.println("""
                    1: GMAIL
                    2: ICLOUD
                    3: OTHER
                    """);
            int email = sc.nextInt();

            switch (email) {
                case 1 -> {
                    emailType = EmailType.GMAIL;
                    inputIsWrong = false;
                }
                case 2 -> {
                    emailType = EmailType.ICLOUD;
                    inputIsWrong = false;
                }
                case 3 -> {
                    emailType = EmailType.OTHER;
                    inputIsWrong = false;
                }
                default -> System.out.println("No such type");
            }
        }
        return emailType;
    }

}
