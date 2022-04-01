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

    public void addNew() {
        System.out.println("Add contact name");
        String name = sc.next();


        System.out.println("Add number");
        String number = sc.next();


        List<Number> numbers = new LinkedList<>();
        numbers.add(new Number(number, selectPhoneType()));

        System.out.println("Add email");
        String email = sc.next();


        List<Email> emails = new LinkedList<>();
        emails.add(new Email(email, selectEmailType()));

        System.out.println("Insert company name");
        String company = sc.next();

        controller.create(name, numbers, emails, company);
    }

    public static void addNumberInExist() {
        System.out.println(controller.getAllNames());
        System.out.println("Choose contact");
        String name = sc.next();

        System.out.println("Add number");
        String number = sc.next();

        controller.addNumberInExisting(name, number, selectPhoneType());
    }

    public static void addEmailInExist() {
        System.out.println(controller.getAllNames());
        System.out.println("Choose contact");
        String name = sc.next();

        System.out.println("Add email");
        String email = sc.next();

        controller.addEmailInExisting(name, email, selectEmailType());
    }

    public  void showAll() {
        controller.showAll();
    }

    public   void delete() {
        System.out.println(controller.getAllNames());

        System.out.println("Choose contact");
        String name = sc.next();
        controller.delete(name);
    }

    public  void updateExistingNumber() {
        System.out.println(controller.getAllNames());

        System.out.println("Choose contact");
        String name = sc.next();

        System.out.println(controller.showUserAllNumber(name));

        System.out.println("What row you want update?");
        int index = sc.nextInt();

        System.out.println("Add new number");
        String number = sc.next();

        controller.update(name, number, selectPhoneType(), index);
    }

    private static PhoneNumberType selectPhoneType() {
        System.out.println("Add number type");
        System.out.println("""
                1: HOME
                2: SCHOOL
                3: WORK
                4: MOBILE
                """);
        int numberType = sc.nextInt();
        PhoneNumberType phoneNumberType = PhoneNumberType.HOME;
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
        EmailType emailType = EmailType.OTHER;
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
        }
        return emailType;
    }

}

