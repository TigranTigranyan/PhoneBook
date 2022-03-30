package com.company.services;

import com.company.Contact;
import com.company.model.User;

public class PhoneService implements Service {
    @Override
    public void add(String userName, User value) {
//        System.out.println("enter user info");
//        User user = new User();
        Contact.contacts.put(userName, value);
    }

    @Override
    public void printContacts() {
        ////toString-@ override ptit arvi
        System.out.println(Contact.contacts.toString());
    }

    @Override
    public void delete(String key) {

    }

    @Override
    public User get(String key) {
        return null;
    }

    @Override
    public boolean set(String key, User value) {
        return false;
    }
}
