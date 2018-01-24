package com.loyalToPlant.helper;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.loyalToPlant.helper.HeaderPhoneBook.REMOVE;

public class Contact {

    private ElementsCollection contactInfo;

    Contact(SelenideElement contactRootSelector) {

        this.contactInfo = contactRootSelector.findAll("td").shouldHaveSize(5); // Количество полей контакта 5
    }

    public void checkAttribute(HeaderPhoneBook columnName, String expectedString) {

        String actualValueAttribute = contactInfo.get(columnName.getNumber()).getText();
        Assert.assertEquals(actualValueAttribute, expectedString);
    }

    public void deleteContact() {

        contactInfo.get(REMOVE.getNumber()).find(By.tagName("a")).click();
    }
}
