package com.company.services;

import com.company.model.Number;
import com.company.model.User;

import java.util.List;

public interface Service {
    void addNew(String key, User value);

    void addInExisting(String key, Number number);

    String printContactNames();

    void printContacts();

    void delete(String key);

    User get(String key);

////User search(String key);
}
