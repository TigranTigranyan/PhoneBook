package com.company.controller;

import com.company.model.EmailType;
import com.company.model.PhoneNumberType;
import com.company.model.User;
import com.company.services.PhoneService;

public class Controller {
    PhoneService phoneService = new PhoneService();

    public void add(String userName, String email, String company, String phoneNumbers,
                    PhoneNumberType numberType, EmailType emailType) {
        phoneService.add(userName, new User(email, company, phoneNumbers, numberType, emailType));
    }
}
