package ru.aplana.autotests.pages;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

public class MarketPage extends PageObject {

    public void complexMenuClick(String linkName){
            ThucydidesWebDriverSupport.getDriver().findElement(By.xpath("//li[@data-department = '" + linkName + "']/a")).click();
    }

    public void complexSubMenuClick(String linkName){
            ThucydidesWebDriverSupport.getDriver().findElement(By.xpath("//div[@class='catalog-menu__list']/a[text()='" + linkName + "']")).click();
    }
}
