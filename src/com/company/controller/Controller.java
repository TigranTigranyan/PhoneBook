package com.company.controller;

import com.company.model.*;
import com.company.model.Number;
import com.company.services.PhoneService;

import java.util.List;

public class Controller {
    PhoneService phoneService = new PhoneService();

    public void addNew(String userName, List<Number> numbers, List<Email> emails, String company) {
        phoneService.addNew(userName, new User(numbers, emails,  company));
    }

    public void addInExisting(String userName,String number,PhoneNumberType phoneNumberType){
        phoneService.addInExisting(userName,new Number(number,phoneNumberType));
    }

    public void showAll(){
        System.out.println(phoneService.printContactNames());
    }

}
