package com.loyalToPlant.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class PhoneBookPage {

    private static final SelenideElement BTN_LOGOUT = $("p>a[href = 'logout.php']");
    private static final SelenideElement BTN_ADD_NOTE = $(".firefinder-match[href = 'phoneBookAdd.php']");
    private static final SelenideElement TITLE = $("body>h1>center");  //TODO remove?

    public ElementsCollection getListNote() {

        SelenideElement rootList = $("table>tbody");
        //ElementsCollection list = $$("table>tbody>tr").shouldHaveSize(25);
        //System.out.println(list.size());
        //return list;
        ElementsCollection list = $$(byXpath("//table/tbody/tr"));
        System.out.println(list.size());
        return list;
    }

    public ContactAddPage clickPhoneBookAdd() {
        return page(ContactAddPage.class);
    }

    public LoginPage logout() {

        BTN_LOGOUT.should(Condition.visible).click();
        return page(LoginPage.class);
    }
}
