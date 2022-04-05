package com.company.model;

public enum PhoneNumberType {
    HOME(0), SCHOOL(1), WORK(2), MOBILE(3);
    private int index;
    PhoneNumberType(int index){
        this.index=index;
    }
}
