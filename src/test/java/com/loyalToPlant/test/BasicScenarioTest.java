package com.loyalToPlant.test;

import com.codeborne.selenide.ElementsCollection;
import com.loyalToPlant.page.ContactAddPage;
import com.loyalToPlant.page.DeletePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.loyalToPlant.helper.Helper.parameters;

public class BasicScenarioTest extends BaseTest{

    @Test(priority = 2)
    public void badLogin() {

        //loginPage = phoneBookPage.logout();
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

       // for(int i = 0; i < 30; i++) {
        /*try {
            phoneBookPage.deleteContact(0);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        /*ElementsCollection contact = $$(byXpath("//table/tbody/tr")).get(0).findAll("td");
        System.out.println(contact);
        System.out.println(contact.size());
        System.out.println(contact.get(4));
        System.out.println(contact.get(4).getText()); //find(By.tagName("a"))
        //contact.get(4).find(By.tagName("a")).click();
        sleep(500);*/

            phoneBookPage.deleteContact(0);
        //}
        //ContactAddPage contactAddPage = phoneBookPage.clickPhoneBookAdd();

        // added space
    }
}
