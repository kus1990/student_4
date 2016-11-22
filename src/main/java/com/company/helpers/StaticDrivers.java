package com.company.helpers;

import com.company.data.browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StaticDrivers {
    public static WebDriver GetDriver()
    {
        String drw = PropertyParser.loadProperty("driverManage");
        browsers ntr = browsers.valueOf(drw);
        String workingDir = System.getProperty("user.dir");

        switch (ntr) {
            case chrome:
                System.setProperty("webdriver.chrome.driver", workingDir + "/drivers/chromedriver");
                return new ChromeDriver();
            case firefox:
                System.setProperty("webdriver.firefox.marionette", workingDir + "/drivers/geckodriver");
                return new FirefoxDriver();
            default:
                System.setProperty("webdriver.chrome.driver", workingDir + "/drivers/chromedriver");
                return new ChromeDriver();
        }
    }
}
