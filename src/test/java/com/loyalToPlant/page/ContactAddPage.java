package com.loyalToPlant.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ContactAddPage {

    private static final SelenideElement BTN_BACK = $("p>a");

    private static final SelenideElement NAME_INPUT = $(By.name("name"));
    private static final SelenideElement PHONE_INPUT = $(By.name("phone"));
    private static final SelenideElement BIRTHDAY_INPUT = $(By.name("birthday"));
    private static final SelenideElement POSTAL_INPUT = $(By.name("postal"));

    public void enterValue(String name, String phone, String birthday, String postal) {

        NAME_INPUT.shouldHave(Condition.visible).sendKeys(name);
        PHONE_INPUT.shouldHave(Condition.visible).sendKeys(phone);
        BIRTHDAY_INPUT.shouldHave(Condition.visible).sendKeys(birthday);
        POSTAL_INPUT.shouldHave(Condition.visible).sendKeys(postal);

        $(byText("Отправить запрос")).click();
    }

    public void checkError(String message) {

        $(withText(message)).shouldHave(Condition.visible);
    }

    public PhoneBookPage clickBack() {

        BTN_BACK.should(Condition.visible).click();

        return page(PhoneBookPage.class);
    }
}
