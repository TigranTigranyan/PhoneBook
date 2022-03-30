package com.company.services;

import com.company.model.User;

import java.util.List;

public interface Service {
    void add(String key, User value);

    void printContacts();

    void delete(String key);

    User get(String key);

////User search(String key);
}
