package ru.aplana.autotests.halpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StaticDrivers {
    public enum browsers {
        chrome,
        firefox
    }
    public static WebDriver GetDriver()
    {
        WebDriver driver;
        String drw = PropertyParser.loadProperty("driverManage");
        browsers ntr = browsers.valueOf(drw);
        String workingDir = System.getProperty("user.dir");

        switch (ntr) {
            case chrome:
                System.setProperty("webdriver.chrome.driver", workingDir + "/drivers/chromedriver");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                return driver;
            case firefox:
                System.setProperty("webdriver.firefox.marionette", workingDir + "/drivers/geckodriver");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                return driver;
            default:
                System.setProperty("webdriver.chrome.driver", workingDir + "/drivers/chromedriver");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                return driver;
        }
    }
}
