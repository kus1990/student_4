package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.ulmart.ru/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCase() throws Exception {
    driver.get(baseUrl + "/");
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//li[contains(@class, 'b-list__item')]/a[@data-gtm-eventcontent = 'Спорт и Туризм']"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//li[contains(@class, 'b-list__item')]/a[@data-gtm-eventcontent = 'Спорт и Туризм']")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//li[contains(@class, 'b-list__item')]/a[@data-gtm-eventcontent = 'Зимний спорт']"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//li[contains(@class, 'b-list__item')]/a[@data-gtm-eventcontent = 'Зимний спорт']")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//li[contains(@class, 'b-list__item')]/a[@data-gtm-eventcontent = 'Горнолыжный спорт']"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//li[contains(@class, 'b-list__item')]/a[@data-gtm-eventcontent = 'Горнолыжный спорт']")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [getEval | (window.document.getElementById('catalogGoodsBlock').querySelectorAll('section')[window.document.getElementById('catalogGoodsBlock').querySelectorAll('section').length - 1]).querySelector('div > .must_be_href').getAttribute('href') | ]]
    // ERROR: Caught exception [ERROR: Unsupported command [openWindow | ${nphref} | 10]]
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | 10 | ]]
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//h1"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    assertTrue(driver.findElement(By.xpath("//h1")).getText().matches("^[\\s\\S]*Горные лыжи[\\s\\S]*$"));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
