package ru.aplana.autotests.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import ru.aplana.autotests.pages.base.BasePage;

import java.util.List;

public class ItemListPage extends BasePage {

    @FindBy(xpath="//div[contains(@class,'snippet-list')]/div[contains(@class,'n-snippet-card')]")
    private List<WebElement> items;

    @FindBy(xpath="//input[@id='header-search']")
    private WebElement searchField;

    @FindBy(xpath="//form[contains(@class,'header2__search')]//button")
    private WebElement searchBtn;

    private String actualElementHeader;

    public void checkItemsListSize(int cnt){
        Assert.assertEquals("Получено некоррекстное количество элементов", cnt, items.size());
    }

    public String getActualHeader(){
        return actualElementHeader;
    }

    public void clickSearchBtn(){ searchBtn.click(); }

    public void storeElementHeader(int elindex){
        actualElementHeader = ThucydidesWebDriverSupport.getDriver().findElement(By.xpath("(//div[contains(@class,'snippet-list')]/div[contains(@class,'n-snippet-card')])[" + elindex +"]//span[@class='snippet-card__header-text']")).getText();
    }

    public void searchActurlHeader(){
        searchField.sendKeys(actualElementHeader);
        this.clickSearchBtn();
    }

}
