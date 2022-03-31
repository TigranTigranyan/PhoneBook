package com.company.controller;

import com.company.Contact;
import com.company.model.*;
import com.company.model.Number;
import com.company.services.PhoneService;
import com.company.services.UserService;

import java.util.List;

public class Controller {
    PhoneService phoneService = new PhoneService();
    UserService userService=new UserService();

    public void create(String userName, List<Number> numbers, List<Email> emails, String company) {
        phoneService.addNew(userName, new User(numbers, emails, company));
    }

    public void addInExisting(String userName, String number, PhoneNumberType phoneNumberType) {
        userService.addNumber(Contact.contacts.get(userName),new Number(number, phoneNumberType));
    }

    public void update(String userName, String number, PhoneNumberType phoneNumberType, int index) {
        phoneService.update(userName, number, phoneNumberType, index);
    }

    public  void showUserAllNumber(String name){

    }
    public void showAll() {
        System.out.println(phoneService.printContactNames());
    }
}
