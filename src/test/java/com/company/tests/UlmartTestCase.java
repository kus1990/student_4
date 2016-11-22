package com.company.tests;

import com.company.pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import com.company.helpers.StaticDrivers;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static org.junit.Assert.fail;

public class UlmartTestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private static Logger log = Logger.getLogger(UlmartTestCase.class.getName());

  @Before
  public void setUp() throws Exception {
    driver = StaticDrivers.GetDriver();
    baseUrl = "https://www.ulmart.ru/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void ulmartTest() throws Exception {
    driver.get(baseUrl);

    UlmartMainPage mainUl = PageFactory.initElements(driver, UlmartMainPage.class);
    log.info(mainUl.allElementsIsPresent());
    mainUl.clickToMenuLink("Спорт и Туризм",driver);
    UlmartCatalogNavigationPage catalogUl = PageFactory.initElements(driver, UlmartCatalogNavigationPage.class);
    log.info(catalogUl.allElementsIsPresent());
    if(catalogUl.checkUrl(driver, "https://www.ulmart.ru/catalog/tourism_goods")){
      log.info("Адрес сайта == https://www.ulmart.ru/catalog/tourism_goods");
    }
    if(catalogUl.checkHeader("Спорт и Туризм")){
      log.info("Заголовок - спорт и туризм!");
    }

    catalogUl.clickToPart("Зимний спорт",driver);
    log.info(catalogUl.allElementsIsPresent());
    if(catalogUl.checkUrl(driver, "https://www.ulmart.ru/catalog/98606")){
      log.info("Адрес сайта == https://www.ulmart.ru/catalog/98606");
    }
    if(catalogUl.checkHeader("Зимний спорт")){
      log.info("Заголовок - зимний спорт!");
    }

    catalogUl.clickToPart("Горнолыжный спорт",driver);

    ItemsPage itemsUl = PageFactory.initElements(driver, ItemsPage.class);
    log.info(itemsUl.allElementsIsPresent());
    if(itemsUl.checkHeader("Горные лыжи")){
      log.info("Заголовок - горные лыжи!");
    }
    itemsUl.clickToItem(-1,driver);

    OneItemPage singleItem = PageFactory.initElements(driver, OneItemPage.class);
    log.info(singleItem.allElementsIsPresent());
    if(singleItem.checkHeaderContains("горные лыжи")){
      log.info("Заголовок содержит горные лыжи!");
    }
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
