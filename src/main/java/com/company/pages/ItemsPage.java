package com.company.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ItemsPage extends BasePage {
    public ItemsPage (WebDriver driver){
        this.pageName = "--раздел карточек товара--";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        js = (JavascriptExecutor) driver;
    }

    @FindBy(xpath="//h1")
    private WebElement pageHeader;

    @FindBy(xpath="//*[@id='catalogGoodsBlock'][contains(@class,'b-products__list')]")
    private WebElement itemList;

    public void clickToMenuLink(String linkName,WebDriver driver){
        WebElement clickPart = listSideMenu.findElement(By.xpath("//li/a[@data-gtm-eventcontent = '" + linkName +"']"));
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + clickPart.getLocation().y + ")");
        clickPart.click();
    }

    public boolean checkHeader(String hName){
        return this.pageHeader.getText().equals(hName);
    }

    public void clickToItem(int number,WebDriver driver){
        String prefix;
        if(number == -1)
        {
            prefix = "last()";
        }else{
            prefix = Integer.toString(number);
        }
        String xpath = "section[" + prefix +"]/div";
        WebElement clickPart = itemList.findElement(By.xpath(xpath));
        this.setAttribute(itemList.findElement(By.xpath("section[" + prefix +"]/div/a")),"target","_self");
        System.out.println(itemList.findElement(By.xpath("section[" + prefix +"]/div/a")).getAttribute("target"));
        clickPart.click();
    }

    public String allElementsIsPresent(){
        String returnMassage = "";
        if(listSideMenu !=null)
        {
            returnMassage +="Боковая панель присутствует на " + pageName +"!\n";
        }
        else
        {
            returnMassage +="Боковая панель отсутствует на " + pageName + "!\n";
        }
        if(searchInputField !=null)
        {
            returnMassage +="Поле поиска присутствует на " + pageName +"!\n";
        }
        else
        {
            returnMassage +="Поле поиска отсутствует на " + pageName +"!\n";
        }
        if(searchInputBut !=null)
        {
            returnMassage +="Кнопка поиска присутствует на " + pageName +"!\n";
        }
        else
        {
            returnMassage +="Кнопка поиска отсутствует на " + pageName + "!\n";
        }
        if(pageHeader !=null)
        {
            returnMassage +="Заголовок присутствует на " + pageName +"!\n";
        }
        else
        {
            returnMassage +="Заголовок отсутствует на " + pageName + "!\n";
        }
        if(itemList !=null)
        {
            returnMassage +="Товары присутствуют на " + pageName +"!\n";
        }
        else
        {
            returnMassage +="Товары отсутствуют на " + pageName + "!\n";
        }
        return returnMassage;
    }

}
