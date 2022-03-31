package com.company.services;

import com.company.model.Number;
import com.company.model.User;

public class  UserService {
    public void addNumber(User user,Number number) {
        user.getNumbers().add(number);
    }

    public String contactNumbers(){
        StringBuilder str=new StringBuilder("");
        for (Number num:numbers ) {
            str.append(num.getType() + num.getNumber() + "\n");
        }
        return
    }
}
