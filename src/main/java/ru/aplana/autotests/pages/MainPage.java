package ru.aplana.autotests.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.aplana.autotests.pages.base.BasePage;

public class MainPage extends BasePage {

    @FindBy(xpath="(.//*[@id='b-dropdown-catalog-menu']//ul[contains(@class,'b-list_catalog-menu')])[1]/li/a[contains(@data-gtm-eventcontent,'Спорт и Туризм')]")
    protected WebElement sportPart;

    public String clickToMenuLink(String linkName){
        WebElement clickPart = listSideMenu.findElement(By.xpath("//li/a[@data-gtm-eventcontent = '" + linkName +"']"));
        try {
            clickPart.click();
            return "Кнопка " + linkName + " учпешно нажата!\n";
        } catch (NullPointerException exp){
            return "Кнопка " + linkName + " не нажата, возможно элемент не определён!\n";
        }
    }

    public String clickToSportPart(){
        try {
            sportPart.click();
            return "Кнопка спорт и туризм учпешно нажата!\n";
        } catch (NullPointerException exp){
            return "Кнопка спорт и туризм не нажата, возможно элемент не определён!\n";
        }
    }

}
