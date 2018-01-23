package com.loyalToPlant.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class DeletePage {

    private static final SelenideElement BTN_BACK_PHONE_BOOK = $("body>p>a[href = '/']");

    public PhoneBookPage backPhoneBook() {

        BTN_BACK_PHONE_BOOK.click();
        return page(PhoneBookPage.class);
    }

    public void checkStringOnPage(String tittle) {

        $(byText(tittle)).should(Condition.visible);
    }
}
