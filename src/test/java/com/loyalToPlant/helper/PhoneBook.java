package com.loyalToPlant.helper;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PhoneBook {

    private static final SelenideElement rootList = $("table>tbody");
    private ElementsCollection listNote;// = ElementsCollection list = $$(byXpath("//table/tbody/tr"));

    public enum HeaderPhoneBook {

        NAME_CONTACT(0),
        PHONE_NUMBER(1),
        BIRTHDAY(2),
        INDEX_NUMBER(3),
        REMOVE(4);

        private int number;

        HeaderPhoneBook(int number) {this.number = number;}
    }

    public PhoneBook() {
        listNote = $$(byXpath("//table/tbody/tr"));
    }

    private ElementsCollection getContactInformation(SelenideElement contact) {

        return contact.findAll("td");
    }

    public String getAttributeContact(ElementsCollection contactInformation) {
        return contactInformation.get(0).getText();
    }
}
