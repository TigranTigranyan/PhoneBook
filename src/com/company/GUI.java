package com.company;

import com.company.controller.Controller;
import com.company.model.Email;
import com.company.model.EmailType;
import com.company.model.Number;
import com.company.model.PhoneNumberType;

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
        System.out.println("Enter name");
        String name = sc.next();

        System.out.println("Enter phone number");
        String number = sc.next();

        List<Number> numbers = new LinkedList<>();
        numbers.add(new Number(number, selectPhoneNumberType()));

        System.out.println("Enter email");
        String email = sc.next();

        List<Email> emails = new LinkedList<>();
        emails.add(new Email(email, selectEmailType()));

        System.out.println("Enter company name");
        String company = sc.next();

        controller.create(name, numbers, emails, company);
    }

    public void addNumberInExistingContact() {
        System.out.println(controller.allNames());
        System.out.println("Choose contact");
        String name = sc.next();

        System.out.println("Enter phone number");
        String number = sc.next();

        controller.addNumberInExisting(name, number, selectPhoneNumberType());
    }

    public void addEmailInExistingContact() {
        System.out.println(controller.allNames());
        System.out.println("Choose contact");
        String name = sc.next();

        System.out.println("Enter email");
        String email = sc.next();

        controller.addEmailInExisting(name, email, selectEmailType());
    }

    public void showContactsInfo() {
        controller.showAllInfo();
    }

    public void delete() {
        System.out.println(controller.allNames());

        System.out.println("Choose contact");
        String name = sc.next();

        controller.delete(name);
    }

    public void updateExistingNumber() {
        System.out.println(controller.allNames());

        System.out.println("Choose contact");
        String name = sc.next();

        System.out.println(controller.showAllNumbersOfAUser(name));

        System.out.println("Which row do you want to update?");
        int index = sc.nextInt();

        System.out.println("Add new number");
        String number = sc.next();

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
            int numberType = sc.nextInt();

            switch (numberType) {
                case 1 -> {
                    phoneNumberType = PhoneNumberType.HOME;
                    inputIsWrong = false;
                }
                case 2 -> {
                    phoneNumberType = PhoneNumberType.SCHOOL;
                    inputIsWrong = false;
                }
                case 3 -> {
                    phoneNumberType = PhoneNumberType.WORK;
                    inputIsWrong = false;
                }
                case 4 -> {
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
