package com.loyalToPlant.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.loyalToPlant.page.LoginPage;
import com.loyalToPlant.page.PhoneBookPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.loyalToPlant.helper.Helper.parameters;

public class First {

    @Test
    public void local() {

        //System.setProperty("webdriver.gecko.driver", parameters.getProperty("pathDriverFirefoxWin"));
        System.setProperty("webdriver.chrome.driver", parameters.getProperty("pathDriverChromeWin"));
        Configuration.browser = "chrome";
        String homeURL = parameters.getProperty("URL");

        LoginPage loginPage = open(homeURL, LoginPage.class);

        loginPage.checkLoginForm();

        PhoneBookPage phoneBookPage = loginPage.loginAs(parameters.getProperty("loginTest"), parameters.getProperty("passwordTest"));

        ElementsCollection list = phoneBookPage.getListNote();

        System.out.println(list.get(0).getText());
        List<WebElement> optionsList = list.get(0).findElementsByXPath("td");

        for (WebElement element : optionsList) {
            System.out.println(element.getText());
        }

        System.out.println("++++++++++");
        if (optionsList.get(1).getText().equals("")) {
            System.out.println("пусто");
        } else {
            System.out.println(optionsList.get(1).getText());
        }

        //optionsList.get(optionsList.size() - 1).findElement(By.tagName("a")).click(); // worked
        sleep(1000);
        //System.out.println(list.get(0).findElementsByXPath("td").size());
        //System.out.println(list.get(0).$$x("td").size());



    }
}
