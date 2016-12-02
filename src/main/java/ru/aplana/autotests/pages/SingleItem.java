package ru.aplana.autotests.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class SingleItem extends PageObject {

    @FindBy(xpath="//h1[@itemprop='name']")
    private WebElement itemHeader;

    public void checkHeader(String iname){
        Assert.assertEquals("Не совпадает заголовок", iname, itemHeader.getText());
    }

}

