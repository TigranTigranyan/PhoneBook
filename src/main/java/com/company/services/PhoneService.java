package com.company.services;

import com.company.Contact;
import com.company.model.PhoneNumberType;
import com.company.model.User;

public class PhoneService implements Service {

    @Override
    public void addNew(String key, User value) {
        Contact.contacts.put(key, value);
    }

    @Override
    public void update(String userName, String number, PhoneNumberType phoneNumberType, int index) {

        Contact.contacts.get(userName).getNumbers().get(index-1).setNumber(number);
        Contact.contacts.get(userName).getNumbers().get(index-1).setType(phoneNumberType);
    }

    @Override
    public String printContactNames() {
        StringBuilder s = new StringBuilder("");
        for (String str : Contact.contacts.keySet()) {
            s.append(str).append("\n");
        }
        return s.toString();
    }

    @Override
    public void delete(String key) {
       Contact.contacts.remove(key);
    }

}
