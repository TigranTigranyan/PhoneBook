package com.company.services;

import com.company.Contact;
import com.company.model.Number;
import com.company.model.User;

public class PhoneService implements Service {
    @Override
    public void addNew(String key, User value) {
        Contact.contacts.put(key,value);
    }

    @Override
    public void addInExisting(String key, Number number) {
        Contact.contacts.get(key).addNumber(number);

    }

    @Override
    public String printContactNames() {
        StringBuilder s=new StringBuilder("");
        for (String str:Contact.contacts.keySet()) {
            s.append(str+"/");
        }
        return s.toString();
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


    }

