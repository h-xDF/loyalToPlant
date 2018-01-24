package com.loyalToPlant.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class DeletePage {

    private static final SelenideElement BTN_BACK_PHONE_BOOK = $("body>p>a[href = '/']");

    @Step("Click button back")
    public PhoneBookPage backPhoneBook() {

        BTN_BACK_PHONE_BOOK.click();
        return page(PhoneBookPage.class);
    }

    @Step("Check {0} on page")
    public void checkStringOnPage(String tittle) {

        $(byText(tittle)).should(Condition.visible);
    }
}
