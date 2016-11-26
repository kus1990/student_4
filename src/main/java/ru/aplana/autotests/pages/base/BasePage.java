package ru.aplana.autotests.pages.base;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * Created by maximgugaev on 26.11.16.
 */
public class BasePage extends PageObject {

    @FindBy(xpath="//h1")
    private WebElement pageHeader;

    @FindBy(xpath="(.//*[@id='b-dropdown-catalog-menu']//ul[contains(@class,'b-list_catalog-menu')])[1]")
    protected WebElement listSideMenu;

    @FindBy(id="searchField")
    protected WebElement searchInputField;

    public String isMenuOnPage(){
        if(listSideMenu.isDisplayed())
        {
            return "Боковая панель присутствует на главной странице!\n";
        }
        else
        {
            return "Боковая панель отсутствует на главной странице!\n";
        }
    }

    public String isSearchFieldOnPage(){
        if(searchInputField.isDisplayed())
        {
            return "Поле поиска присутствует на главной странице!\n";
        }
        else
        {
            return "Поле поиска отсутствует на главной странице!\n";
        }
    }

    public String checkHeaderPresent(){
        if(pageHeader.isDisplayed())
        {
            return "Заголовок присутствует на странице!\n";
        }
        else
        {
            return "Заголовок не присутствует на странице!\n";
        }
    }

    public boolean checkHeader(String hName){
        Assert.assertEquals("Получен неправильный заголовок", hName, this.pageHeader.getText());
        return pageHeader.getText().equals(hName);
    }

    public void setAttribute(WebElement element, String attName, String attValue) {
        ((JavascriptExecutor) ThucydidesWebDriverSupport.getDriver()).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                element, attName, attValue);
    }
}
