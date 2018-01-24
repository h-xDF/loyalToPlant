package com.loyalToPlant.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.loyalToPlant.helper.Contact;
import com.loyalToPlant.helper.HeaderPhoneBook;
import com.loyalToPlant.helper.PhoneBook;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class PhoneBookPage {

    private static final SelenideElement BTN_LOGOUT = $("p>a[href = 'logout.php']");
    private static final SelenideElement TITLE = $("body>h1>center");  //TODO remove?

    //Todo check tittle message

    @Step("Check attribute contact")
    public void checkAttribute(int numberContact, HeaderPhoneBook headerPhoneBook, String expectedString) {

        PhoneBook phoneBook = new PhoneBook();
        Contact contact = phoneBook.getContact(numberContact);

        contact.checkAttribute(headerPhoneBook, expectedString);
    }

    public int getSizePhoneBook() {

        return new PhoneBook().getSizePhoneBook();
    }

    @Step("Check tittle page")
    public void checkTittlePage(String tittle) {

        $(withText(tittle)).should(Condition.visible);
    }

    @Step("Delete contact")
    public DeletePage deleteContact(int indexContact) {

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.removeContact(indexContact);

        return page(DeletePage.class);
    }

    @Step("Click button Добавить запсь")
    public ContactAddPage clickPhoneBookAdd() {

        $(byText("Добавить запись")).click();
        return page(ContactAddPage.class);
    }

    @Step("LogOut")
    public LoginPage logout() {

        BTN_LOGOUT.should(Condition.visible).click();
        return page(LoginPage.class);
    }
}
