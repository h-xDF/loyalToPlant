package com.loyalToPlant.test;

import com.loyalToPlant.helper.HeaderPhoneBook;
import com.loyalToPlant.page.ContactAddPage;
import com.loyalToPlant.page.DeletePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.loyalToPlant.helper.Helper.parameters;

public class BasicScenarioTest extends BaseTest{

    private String testName = "name";
    private String testPhone = "phone";
    private String testBirthday = "1111-11-11";
    private String testPostal = "postal";

    @Test(priority = 2)
    public void badLogin() {

        loginPage.checkLoginForm();
        loginPage.loginAs(parameters.getProperty("loginTest"), "BAD_PASSWORD");
        loginPage.checkLoginForm();
    }

    @Test(priority = 3, dependsOnMethods = "badLogin")
    public void logIn() {

        phoneBookPage = loginPage.loginAs(parameters.getProperty("loginTest"), parameters.getProperty("passwordTest"));
        phoneBookPage.checkTittlePage("Телефонная");
    }

    @Test(priority = 4, dependsOnMethods = "logIn")
    public void createContact() {

        int oldCount = phoneBookPage.getSizePhoneBook();

        ContactAddPage contactAddPage = phoneBookPage.clickPhoneBookAdd();
        contactAddPage.enterValue(testName,testPhone,testBirthday,testPostal);
        phoneBookPage = contactAddPage.clickBack();

        int newCount = phoneBookPage.getSizePhoneBook();

        Assert.assertEquals(newCount, oldCount + 1);
    }

    @Test(priority = 5, dependsOnMethods = "createContact")
    public void checkContact() {

        phoneBookPage.checkAttribute(0, HeaderPhoneBook.NAME_CONTACT, testName);
        phoneBookPage.checkAttribute(0, HeaderPhoneBook.PHONE_NUMBER, testPhone);
        phoneBookPage.checkAttribute(0, HeaderPhoneBook.BIRTHDAY, testBirthday);
        phoneBookPage.checkAttribute(0, HeaderPhoneBook.INDEX_NUMBER, testPostal);
    }

    @Test(priority = 6, dependsOnMethods = "checkContact")
    public void deletingContact() {

        DeletePage deletePage = phoneBookPage.deleteContact(0);
        phoneBookPage = deletePage.backPhoneBook();
    }

    @Test(priority = 7, dependsOnMethods = "deletingContact")
    public void logOut() {

        loginPage = phoneBookPage.logout();
        loginPage.checkLoginForm();
    }
}
