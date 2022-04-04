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
            String command = sc.next();

            switch (command) {
                case "1" -> gui.addNewContact();
                case "2" -> gui.addNumberInExistingContact();
                case "3" -> gui.updateExistingNumber();
                case "4" -> gui.addEmailInExistingContact();
                case "5" -> gui.updateExistingEmail();
                case "6" -> System.out.println("Contacts:\n" + controller.getAllNames());
                case "7" -> gui.showContactsInfo();
                case "8" -> gui.delete();
                case "0" -> condition = false;
                default -> {
                }
            }
        }
    }

    public void addNewContact() {

        System.out.println("Enter name");
        String name = sc.next();
        name = Helper.addName(name);

        System.out.println("Enter phone number");
        String number = sc.next();
        number = Helper.addNumber(number);

        List<Number> numbers = new LinkedList<>();
        numbers.add(new Number(number, selectPhoneNumberType()));

        System.out.println("Enter email");
        String email = sc.next();
        email = Helper.addEmail(email);

        List<Email> emails = new LinkedList<>();
        emails.add(new Email(email, selectEmailType()));

        System.out.println("Enter company name");
        String companyName = sc.next();
        companyName = Helper.addCompany(companyName);

        controller.create(name, numbers, emails, companyName);

    }

    public void addNumberInExistingContact() {
        System.out.println(controller.getAllNames());
        System.out.println("Choose contact");
        String name = sc.next();

        System.out.println("Enter phone number");
        String number = sc.next();
        number = Helper.addNumber(number);

        controller.addNumberInExisting(name, number, selectPhoneNumberType());

    }

    public void addEmailInExistingContact() {
        System.out.println(controller.getAllNames());
        System.out.println("Choose contact");
        String name = sc.next();

        System.out.println("Enter email");
        String email = sc.next();
        email = Helper.addEmail(email);

        controller.addEmailInExisting(name, email, selectEmailType());
    }

    public void showContactsInfo() {
        controller.showAll();
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

        System.out.println("Enter phone number");
        String number = sc.next();
        number = Helper.addNumber(number);

        controller.updateNumber(name, number, selectPhoneNumberType(), index);
    }

    public void updateExistingEmail() {
        System.out.println(controller.getAllNames());

        System.out.println("Choose contact");
        String name = sc.next();

        System.out.println(controller.showAllEmailsOfAUser(name));

        System.out.println("Which row do you want to update?");
        int index = sc.nextInt();

        System.out.println("Enter email");
        String email = sc.next();
        email = Helper.addEmail(email);

        controller.updateEmail(name, email, selectEmailType(), index);
    }

    private static PhoneNumberType selectPhoneNumberType() {
        PhoneNumberType phoneNumberType = null;
        boolean inputIsWrong = true;
        while (inputIsWrong) {
            System.out.println("Choose number type");
            System.out.println("""
                    1: HOME
                    2: SCHOOL
                    3: WORK
                    4: MOBILE
                    """);
            String numberType = sc.next();

            switch (numberType) {
                case "1" -> {
                    phoneNumberType = PhoneNumberType.HOME;
                    inputIsWrong = false;
                }
                case "2" -> {
                    phoneNumberType = PhoneNumberType.SCHOOL;
                    inputIsWrong = false;
                }
                case "3" -> {
                    phoneNumberType = PhoneNumberType.WORK;
                    inputIsWrong = false;
                }
                case "4" -> {
                    phoneNumberType = PhoneNumberType.MOBILE;
                    inputIsWrong = false;
                }
                default -> System.out.println("No such type");
            }
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
            String email = sc.next();

            switch (email) {
                case "1" -> {
                    emailType = EmailType.GMAIL;
                    inputIsWrong = false;
                }
                case "2" -> {
                    emailType = EmailType.ICLOUD;
                    inputIsWrong = false;
                }
                case "3" -> {
                    emailType = EmailType.OTHER;
                    inputIsWrong = false;
                }
                default -> System.out.println("No such type");
            }
        }
        return emailType;
    }
}
