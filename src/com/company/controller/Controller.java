package com.company.controller;

import com.company.Contact;
import com.company.Main;
import com.company.model.*;
import com.company.model.Number;
import com.company.services.EmailService;
import com.company.services.PhoneService;
import com.company.services.UserService;

import java.io.File;
import java.io.InputStream;
import java.util.List;

public class Controller {
    static PhoneService phoneService = new PhoneService();
    static UserService userService = new UserService();
    static EmailService emailService = new EmailService();
    public static final String ANSI_PURPLE = "\u001B[35m";


    public static void create(String userName, List<Number> numbers, List<Email> emails, String company) {
        phoneService.addNew(userName, new User(numbers, emails, company));
    }

    public void delete(String name) {
        phoneService.delete(name);
    }

    public void addNumberInExisting(String userName, String number, PhoneNumberType phoneNumberType) {
        userService.addNumber(Contact.contacts.get(userName), new Number(number, phoneNumberType));
    }

    public void addEmailInExisting(String userName, String email, EmailType emailType) {
        emailService.addEmail(Contact.contacts.get(userName), new Email(email, emailType));
    }

    public void update(String userName, String number, PhoneNumberType phoneNumberType, int index) {
        phoneService.update(userName, number, phoneNumberType, index);
    }

    public String showUserAllNumber(String name) {
        return userService.contactNumbers(Contact.contacts.get(name));
    }

    public static String getAllNames() {
        return phoneService.printContactNames();
    }

    public static void showAll() {
        System.out.println("---------------");
        for (String name : Contact.contacts.keySet()) {
            User user = Contact.contacts.get(name);
            System.out.println(ANSI_PURPLE+name + "\n" + userService.contactNumbers(user) +
                    emailService.contactEmails(user) +
                    " " + user.getCompany());
            System.out.println("---------------");
        }
//        for (String str : Contact.contacts.keySet()) {
//            s.append(str).append("\n");
//        }
    }
}

