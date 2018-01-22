package com.loyalToPlant.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    private static final SelenideElement USERNAME_INPUT = $(By.id("email"));
    private static final SelenideElement PASSWORD_INPUT = $(By.id("pass"));
    private static final SelenideElement SIGN_IN_BUTTON = $("button[class='gradbutton green']");
    private static final SelenideElement LOGIN_FORM = $("form[action = 'login.php']");

    public void checkLoginForm() {

        Assert.assertTrue(LOGIN_FORM.isDisplayed());
        Assert.assertTrue(LOGIN_FORM.isEnabled());
    }

    public PhoneBookPage loginAs(String username, String password) {

        USERNAME_INPUT.should(Condition.visible).setValue(username);
        PASSWORD_INPUT.should(Condition.visible).setValue(password);
        SIGN_IN_BUTTON.should(Condition.visible).click();

        return page(PhoneBookPage.class);
    }
}
