package ru.aplana.autotests.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.WebElement;
import ru.aplana.autotests.pages.base.BasePage;

import java.util.List;

public class CatalogPage extends BasePage {

    @FindBy(xpath="//input[@id='glf-pricefrom-var']")
    private WebElement priceFrom;

    @FindBy(xpath="//div[@class='n-filter-panel-aside__apply']/button")
    private WebElement applyBtn;

    public String clickToApplyPart(){
        if(applyBtn.isDisplayed()){
            applyBtn.click();
            return "Кнопка маркет нажата!\n";
        } else{
            return "Кнопка маркет не нажата, возможно элемент не определён!\n";
        }
    }

    public void setMinimumPrice(int price){
        priceFrom.sendKeys(price + "");
    }


    public void complexClick(String linkName){
            ThucydidesWebDriverSupport.getDriver().findElement(By.xpath("//span[contains(@class,'checkbox')]/label[text()='" + linkName + "']")).click();
    }

    public void setCompanyListByParam(String cList){
        for(String retval : cList.split(",")){
            this.complexClick(retval);
        }
    }



}
