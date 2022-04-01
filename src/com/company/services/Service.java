package com.company.services;

import com.company.model.PhoneNumberType;
import com.company.model.User;

public interface Service {

    void addNew(String key, User value);

    void update(String userName, String number, PhoneNumberType phoneNumberType,int index);

    String printContactNames();

    void delete(String key);

////User search(String key);
}
