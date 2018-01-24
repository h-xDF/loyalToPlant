package com.loyalToPlant.test;

import com.loyalToPlant.helper.HeaderPhoneBook;
import com.loyalToPlant.page.ContactAddPage;
import com.loyalToPlant.page.DeletePage;
import org.testng.annotations.Test;

import static com.loyalToPlant.helper.Helper.parameters;

public class ValidationValueContactTest extends BaseTest {

    private void testPositiveRun(String testName, String testPhone, String testBirthday, String testPostal) {

        ContactAddPage contactAddPage = phoneBookPage.clickPhoneBookAdd();
        contactAddPage.enterValue(testName,testPhone,testBirthday,testPostal);
        phoneBookPage = contactAddPage.clickBack();

        phoneBookPage.checkAttribute(0, HeaderPhoneBook.NAME_CONTACT, testName);
        phoneBookPage.checkAttribute(0, HeaderPhoneBook.PHONE_NUMBER, testPhone);
        phoneBookPage.checkAttribute(0, HeaderPhoneBook.BIRTHDAY, testBirthday);
        phoneBookPage.checkAttribute(0, HeaderPhoneBook.INDEX_NUMBER, testPostal);

        DeletePage deletePage = phoneBookPage.deleteContact(0);
        phoneBookPage = deletePage.backPhoneBook();
    }

    @Test(priority = 2)
    public void logIn() {

        loginPage.checkLoginForm();
        phoneBookPage = loginPage.loginAs(parameters.getProperty("loginTest"), parameters.getProperty("passwordTest"));
    }

    @Test(priority = 3, dependsOnMethods = "logIn")
    public void positiveTest() {

        String testName = "Name";
        String testPhone = "81234567889";
        String testBirthday = "2018-01-01";
        String testPostal = "7854";

        testPositiveRun(testName, testPhone, testBirthday, testPostal);
    }

    @Test(priority = 4)
    public void specACII() {

        String testName = "どういうわけか";
        String testPhone = "$%^%e";
        String testBirthday = "1111-11-11";
        String testPostal = "%R%Ъ";

        testPositiveRun(testName, testPhone, testBirthday, testPostal);
    }
}
