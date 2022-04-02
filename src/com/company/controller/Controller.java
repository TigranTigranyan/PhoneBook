package com.company.controller;

import com.company.Contact;
import com.company.model.*;
import com.company.model.Number;
import com.company.services.EmailService;
import com.company.services.PhoneService;
import com.company.services.UserService;

import java.util.List;

public class Controller {
    PhoneService phoneService = new PhoneService();
    UserService userService = new UserService();
    EmailService emailService = new EmailService();

    public void create(String userName, List<Number> numbers, List<Email> emails, String company) {
        phoneService.addNewContact(userName, new User(numbers, emails, company));
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

    public void updateNumber(String userName, String number, PhoneNumberType phoneNumberType, int index) {
        phoneService.update(userName, number, phoneNumberType, index);
    }

    public void updateEmail(String userName, String email, EmailType emailType, int index) {
        phoneService.update(userName, email, emailType, index);
    }

    public String showAllNumbersOfAUser(String name) {
        return userService.contactNumbers(Contact.contacts.get(name));
    }

    public String showAllEMailsOfAUser(String name) {
        return emailService.contactEmails(Contact.contacts.get(name));
    }

    public String allNames() {
        return phoneService.contactNames();
    }

    public void showAllInfo() {
        System.out.println("---------------");
        for (String name : Contact.contacts.keySet()) {
            User user = Contact.contacts.get(name);
            System.out.println("Name: " + name + "\n\nNumbers: \n" + userService.contactNumbers(user) +
                    "\nEmails: \n" + emailService.contactEmails(user) +
                    "\nCompany: " + user.getCompany());
            System.out.println("---------------");
        }
    }
}
