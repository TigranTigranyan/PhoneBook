package mainStart;

import controller.ControllerImpl;
import controller.Json;
import model.*;
import model.Number;
import model.EmailType;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static controller.Json.*;

public class GUI {

    static Scanner sc = new Scanner(System.in);
    static ControllerImpl controller = new ControllerImpl();

    public static void start() {
        Scanner sc = new Scanner(System.in);
        GUI gui = new GUI();
        boolean condition = true;
//        System.out.println("Add new contact");
//        gui.addNewContact();

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
                    press 9: To Save contact 
                    press 0: Exit
                    """);
            String command = sc.next();

            switch (command) {
                case "1" -> gui.addNewContact();
                case "2" -> gui.addNumberInExistingContact();
                case "3" -> gui.updateExistingNumber();
                case "4" -> gui.addEmailInExistingContact();
                case "5" -> UpdateJson(); // gui.updateExistingEmail();
                case "6" -> showAllNames(); //System.out.println("Contacts:\n" + controller.getAllNames());
                case "7" -> showAllinfoJson();//gui.showContactsInfo();
                case "8" -> delitefromJson();//gui.delete();
                case "9" -> saveToJson();
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

        controller.create(name, new User(numbers, emails, companyName));
        Json.saveToJson();

    }

    public void addNumberInExistingContact() {
        System.out.println(controller.getAllNames());
        System.out.println("Choose contact");
        String name = sc.next();

        System.out.println("Enter phone number");
        String number = sc.next();
        number = Helper.addNumber(number);

        controller.addNumberInExisting(name, new Number(number, selectPhoneNumberType()));

    }

    public void addEmailInExistingContact() {
        System.out.println(controller.getAllNames());
        System.out.println("Choose contact");
        String name = sc.next();

        System.out.println("Enter email");
        String email = sc.next();
        email = Helper.addEmail(email);

        controller.addEmailInExisting(name, new Email(email, selectEmailType()));
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

        controller.updateNumber(name, new Number(number, selectPhoneNumberType()), index);
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

        controller.updateEmail(name, new Email(email, selectEmailType()), index);
    }

    private static PhoneNumberType selectPhoneNumberType() {
        PhoneNumberType phoneNumberType = null;
        boolean inputIsWrong = true;
        int index;
        while (inputIsWrong) {
            System.out.println("Choose number type");
            System.out.println("""
                    1: HOME
                    2: SCHOOL
                    3: WORK
                    4: MOBILE
                    """);

            try {
                System.out.println("choose type");
                index = sc.nextInt();
                phoneNumberType = PhoneNumberType.values()[index - 1];
                inputIsWrong = false;
            } catch (IndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("No such type");
                sc.next();
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
