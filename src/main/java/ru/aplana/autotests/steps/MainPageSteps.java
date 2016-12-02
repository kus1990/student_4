package ru.aplana.autotests.steps;

import net.thucydides.core.annotations.Step;

import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import ru.aplana.autotests.pages.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class MainPageSteps {

    MainPage mainPage;
    SingleItem singleItem;
    MarketPage marketPage;
    ItemListPage itemListPage;
    CatalogPage catalogPage;


   @Step("Открыта главная страница {0}")
   public void setUpBrowser(String browserUrl){
       String workingDir = System.getProperty("user.dir");
       System.setProperty("webdriver.firefox.marionette", workingDir + File.separator + "drivers" + File.separator +"geckodriver");
       ThucydidesWebDriverSupport.getDriver().manage().window().maximize();
       ThucydidesWebDriverSupport.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       ThucydidesWebDriverSupport.getDriver().get(browserUrl);
   }

    @Step("Перейти в яндекс маркет")
    public void goToMarket(){
        mainPage.clickToMarketPart();
    }

    @Step("Выбрать раздел {0}")
    public void goToComplexPart(String linkName){
        marketPage.complexMenuClick(linkName);
    }

    @Step("Выбрать {0}")
    public void goToComplexSubPart(String linkName){
        marketPage.complexSubMenuClick(linkName);
    }

    @Step("Задать минимальную стоимость {0}")
    public void setMinPrice(int price){
        catalogPage.setMinimumPrice(price);
    }

    @Step("Выбрать: {0}")
    public void setCompanyList(String cList){
        catalogPage.setCompanyListByParam(cList);
    }

    @Step("Нажать кнопку применить")
    public void goToSearchResult(){
        catalogPage.clickToApplyPart();
    }

    @Step("Проверить количество элементов:{0}")
    public void chekElCount(int elCount){
        itemListPage.checkItemsListSize(elCount);
    }

    @Step("Запомнить {0} элемент в списке")
    public void storeFirstElement(int elindex){
        itemListPage.storeElementHeader(elindex);
    }

    @Step("Ввести в поисковую строку запомненное значение")
    public void setSearchString(){
        itemListPage.searchActurlHeader();
    }

    @Step("Проверить наименование товара")
    public void checkItemHeader(){
        singleItem.checkHeader(itemListPage.getActualHeader());
    }

}
