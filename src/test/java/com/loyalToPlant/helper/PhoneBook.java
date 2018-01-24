package com.loyalToPlant.helper;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;

public class PhoneBook {

    private ElementsCollection listNotes;

    public PhoneBook() {
        initListNotes();
    }

    public int getSizePhoneBook() {
        return listNotes.size();
    }

    private void initListNotes() {
        listNotes = $$(byXpath("//table/tbody/tr"));
    }

    public Contact getContact(int numberContact) {

        return new Contact(listNotes.get(numberContact));
    }

    public void removeContact(int numberContact) {

        Contact contact = getContact(numberContact);
        contact.deleteContact();
    }
}
