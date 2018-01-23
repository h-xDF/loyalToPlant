package com.loyalToPlant.test;

import com.loyalToPlant.page.ContactAddPage;
import org.testng.annotations.Test;

import static com.loyalToPlant.helper.Helper.parameters;

public class BasicScenarioTest extends BaseTest{

    @Test(priority = 2)
    public void badLogin() {

        loginPage = phoneBookPage.logout();
        loginPage.checkLoginForm();
        loginPage.loginAs(parameters.getProperty("loginTest"), "BAD_PASSWORD");
        loginPage.checkLoginForm();
    }

    @Test(priority = 3, dependsOnMethods = "badLogin")
    public void logIn() {

        phoneBookPage = loginPage.loginAs(parameters.getProperty("loginTest"), parameters.getProperty("passwordTest"));
        //CHECK TITTLE
    }

    @Test(priority = 4, dependsOnMethods = "logIn")
    public void creteContact() {

        ContactAddPage contactAddPage = phoneBookPage.clickPhoneBookAdd();
        // added space
    }
}
