package com.company.tests;

import com.company.base.BaseTest;
import com.company.pages.*;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class UlmartTestCase extends BaseTest {

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

}
