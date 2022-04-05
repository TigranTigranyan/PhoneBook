package com.company.services;

import com.company.model.*;
import com.company.model.Number;

public interface Service {

    void addNewContact(String key, User value);

    void update(String userName, Number number, int index);

    void update(String userName, Email email, int index);

    String contactNames();

    void delete(String key);
}
