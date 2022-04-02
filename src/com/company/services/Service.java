package com.company.services;

import com.company.model.EmailType;
import com.company.model.PhoneNumberType;
import com.company.model.User;

public interface Service {

    void addNewContact(String key, User value);

    void update(String userName, String number, PhoneNumberType phoneNumberType, int index);

    void update(String userName, String email, EmailType emailType, int index);

    String contactNames();

    void delete(String key);
}
