package ru.aplana.autotests.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;
import ru.aplana.autotests.pages.base.BasePage;

public class MainPage extends BasePage {

    @FindBy(xpath="//a[@data-id='market']")
    protected WebElement marketLink;

    public String clickToMarketPart(){
        if(marketLink.isDisplayed()){
            marketLink.click();
            return "Кнопка маркет нажата!\n";
        } else {
            return "Кнопка маркет не нажата, возможно элемент не определён!\n";
        }
    }

}
