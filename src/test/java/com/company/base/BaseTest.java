package com.company.base;

import com.company.helpers.StaticDrivers;
import com.company.tests.UlmartTestCase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static org.junit.Assert.fail;


public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl;
    protected StringBuffer verificationErrors = new StringBuffer();
    protected static Logger log = Logger.getLogger(UlmartTestCase.class.getName());

    @Before
    public void setUp() throws Exception {
        driver = StaticDrivers.GetDriver();
        baseUrl = "https://www.ulmart.ru/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
