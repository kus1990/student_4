package ru.aplana.autotests.steps;

import net.thucydides.core.annotations.Step;
import ru.aplana.autotests.pages.CatalogPage;
import ru.aplana.autotests.pages.ItemListPage;
import ru.aplana.autotests.pages.ItemPage;
import ru.aplana.autotests.pages.MainPage;

public class MainPageSteps {

    MainPage mainPage;
    ItemPage itemPage;
    ItemListPage itemListPage;
    CatalogPage catalogPage;


    @Step("Проверить элементы главной страницы")
    public String checkMainPageElementsStep(){
        return mainPage.isMenuOnPage() + mainPage.isSearchFieldOnPage();
    }

    @Step("Проверить элементы на странице навигации")
    public String checkNavPageElementsStep(){ return catalogPage.checkHeaderPresent();}

    @Step("Проверить элементы на странице списка товаров")
    public String checkItemListElementsStep(){ return itemListPage.checkHeaderPresent();}

    @Step("Проверить элементы на странице одного товара")
    public String checkOneItemElementsStep(){ return itemPage.checkHeaderPresent();}

    @Step("Нажать на кнопку {0} в меню на главной странице")
    public String clickToMenuPartStep(String linkName){
        if(linkName.equals("спорт и туризм"))
        {
            return mainPage.clickToSportPart();
        }
        else
        {
            return mainPage.clickToMenuLink(linkName);
        }
    }


    @Step("Проверить совпадение заголовка с {0} на странице списка товаров")
    public String checkHeaderStep(String pagename){
        if(itemListPage.checkHeader(pagename)){
            return "Заголовок правильный";
        }else{
            return "неправильный заголовок";
        }
    }

    @Step("Проверить совпадение заголовка с {0} на странице навигации")
    public String checkHeaderNavStep(String pagename){
        if(catalogPage.checkHeader(pagename)){
            return "Заголовок правильный";
        }else{
            return "неправильный заголовок";
        }
    }

    @Step("Проверить совпадение заголовка с {0} на странице одного товара")
    public String checkHeaderOneItemStep(String pagename){
        if(itemPage.checkHeader(pagename)){
            return "Заголовок правильный";
        }else{
            return "неправильный заголовок";
        }
    }

    @Step("Нажать на раздел {0} навигации")
    public String clickToPartStep(String partname){
        if(partname.equals("зимний спорт"))
        {
            return catalogPage.clickToWinterSport();
        }
        else if(partname.equals("горнолыжный спорт"))
        {
            return catalogPage.clickToSkySport();
        }
        return "ошибка";
    }

    @Step("Нажать на последний элемент страницы списка товаров")
    public void clickToLastElementPart(){
        itemListPage.clickToLastElement();
    }

}
