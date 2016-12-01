package ru.aplana.autotests.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import ru.aplana.autotests.pages.base.BasePage;

public class CatalogPage extends BasePage {

    @FindBy(xpath="//div[contains(@class,'col-main-section')]/section[contains(@class,'h-sect-margin1-bottom')]/div[contains(@class,'row')]")
    private WebElement catalogList;

    @FindBy(xpath="//div[contains(@class,'col-main-section')]/section[contains(@class,'h-sect-margin1-bottom')]/div[contains(@class,'row')]/div/ul/li/a[@data-gtm-eventcontent=\"Зимний спорт\"]")
    private WebElement wintertSportLink;

    @FindBy(xpath="//div[contains(@class,'col-main-section')]/section[contains(@class,'h-sect-margin1-bottom')]/div[contains(@class,'row')]/div/ul/li/a[@data-gtm-eventcontent='Горнолыжный спорт']")
    private WebElement skySportLink;

    @FindBy(xpath="//div[contains(@class,'col-main-section')]/section[contains(@class,'h-sect-margin1-bottom')]/div[contains(@class,'row')]/div/ul/li/a[@data-gtm-eventcontent='Горные лыжи']")
    private WebElement skySportPartLink;

    public String clickToWinterSport(){
        try {
            wintertSportLink.click();
            System.out.println("good");
            return "Кнопка зимний спорт учпешно нажата!\n";
        } catch (NullPointerException exp){
            System.out.println("error");
            return "Кнопка зимний спорт не нажата, возможно элемент не определён!\n";
        }
    }

    public String clickToSkySport(){
        try {
            skySportLink.click();
            return "Кнопка горнолыжный спорт учпешно нажата!\n";
        } catch (NullPointerException exp){
            return "Кнопка горнолыжный спорт не нажата, возможно элемент не определён!\n";
        }
    }

    public String clickToSkyPart(){
        try {
            skySportPartLink.click();
            return "Кнопка горнолыжный спорт учпешно нажата!\n";
        } catch (NullPointerException exp){
            return "Кнопка горнолыжный спорт не нажата, возможно элемент не определён!\n";
        }
    }
}
