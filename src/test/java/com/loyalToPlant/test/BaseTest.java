package com.loyalToPlant.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.loyalToPlant.page.LoginPage;
import com.loyalToPlant.page.PhoneBookPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.Selenide.open;
import static com.loyalToPlant.helper.Helper.parameters;

public class BaseTest {

    private static final String homeURL = parameters.getProperty("URL");
    protected LoginPage loginPage;
    protected PhoneBookPage phoneBookPage;

    private String pathDriver;
    private String keyPropertyWebDriver;

    private enum Browser {
        FIREFOX,
        CHROME
    }

    private enum Platform {
        WIN,
        UNIX
    }

    @Parameters({"browserName", "platformName"})
    @BeforeClass(alwaysRun = true)
    public void setUp(Browser browserName, Platform platformName) {


        if(platformName == null || browserName == null) { throw  new IllegalArgumentException("not run parameters");}

        switch (browserName) {

            case CHROME:

                keyPropertyWebDriver = "webdriver.chrome.driver";
                Configuration.browser = "chrome";
                switch (platformName) {
                    case WIN:
                        pathDriver = "pathDriverChromeWin";
                        Configuration.browser = "chrome";
                        break;
                    case UNIX:
                        pathDriver = "pathDriverChromeLinux";
                        break;
                }
                break;

            case FIREFOX:

                keyPropertyWebDriver = "webdriver.firefox.marionette"; // TODO gecko?
                Configuration.browser = "gecko";
                switch (platformName) {
                    case WIN:
                        pathDriver = "pathDriverFirefoxWin";
                        break;
                    case UNIX:
                        pathDriver = "pathDriverFirefoxLinux";
                        break;
                }
                break;
        }

        System.setProperty(keyPropertyWebDriver, parameters.getProperty(pathDriver));

        loginPage = open(homeURL, LoginPage.class);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (WebDriverRunner.getWebDriver() != null) {
            WebDriverRunner.getWebDriver().quit();
        }
    }
}

