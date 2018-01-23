package com.loyalToPlant.helper;

public enum HeaderPhoneBook {

    NAME_CONTACT(0),
    PHONE_NUMBER(1),
    BIRTHDAY(2),
    INDEX_NUMBER(3),
    REMOVE(4);

    private int number;

    HeaderPhoneBook(int number) {this.number = number;}

    public int getNumber() {return this.number;}
}
