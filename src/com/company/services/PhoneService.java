package com.company.services;

import com.company.Contact;
import com.company.model.EmailType;
import com.company.model.PhoneNumberType;
import com.company.model.User;

public class PhoneService implements Service {

    @Override
    public void addNewContact(String key, User value) {
        Contact.contacts.put(key, value);
    }

    @Override
    public void update(String userName, String number, PhoneNumberType phoneNumberType, int index) {
        Contact.contacts.get(userName).getNumbers().get(index - 1).setNumber(number);
        Contact.contacts.get(userName).getNumbers().get(index - 1).setType(phoneNumberType);
    }

    @Override
    public void update(String userName, String email, EmailType emailType, int index) {
        Contact.contacts.get(userName).getEmails().get(index - 1).setEmail(email);
        Contact.contacts.get(userName).getEmails().get(index - 1).setType(emailType);
    }

    @Override
    public String contactNames() {
        StringBuilder s = new StringBuilder();
        int i = 1;
        for (String str : Contact.contacts.keySet()) {
            s.append(i).append(": ").append(str).append("\n");
            i++;
        }
        return s.toString();
    }

    @Override
    public void delete(String key) {
        Contact.contacts.remove(key);
    }
}
