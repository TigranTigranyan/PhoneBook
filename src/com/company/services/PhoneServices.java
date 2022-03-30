package com.company.services;

import com.company.Contact;
import com.company.model.User;

public class PhoneServices implements Service {
    @Override
    public void add(String userName, User value) {
        System.out.println("enter user info");
//        User user = new User();
        Contact.contacts.put(userName, value);
    }

    @Override
    public void printContacts() {

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
