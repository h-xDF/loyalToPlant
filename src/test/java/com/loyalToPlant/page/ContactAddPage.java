package com.loyalToPlant.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ContactAddPage {

    private static final SelenideElement BTN_BACK = $("p>a");

    public PhoneBookPage clickBack() {

        BTN_BACK.should(Condition.visible).click();

        return page(PhoneBookPage.class);
    }
}
