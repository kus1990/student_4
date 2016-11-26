package ru.aplana.autotests.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import ru.aplana.autotests.pages.base.BasePage;

public class ItemListPage extends BasePage {

    @FindBy(xpath="//*[@id='catalogGoodsBlock'][contains(@class,'b-products__list')]")
    private WebElement itemList;

    @FindBy(xpath="//*[@id='catalogGoodsBlock'][contains(@class,'b-products__list')]/section[last()]//div[contains(@class,'b-product__title')]/span/a")
    private WebElement lastItemLink;

    public void clickToLastElement(){
        try {
            setAttribute(lastItemLink,"target","_self");
            System.out.println(lastItemLink);
            System.out.println(lastItemLink.getAttribute("target"));
            System.out.println(lastItemLink.getAttribute("href"));
            lastItemLink.click();
        } catch (NullPointerException exp){
        }
    }

}
