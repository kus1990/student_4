package com.company.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class UlmartCatalogNavigationPage extends BasePage {
    public UlmartCatalogNavigationPage(WebDriver driver){
        this.pageName = "--раздел навигации--";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 1000);
    }

    @FindBy(xpath="//h1")
    private WebElement pageHeader;

    @FindBy(xpath="//div[contains(@class,'col-main-section')]/section[contains(@class,'h-sect-margin1-bottom')]/div[contains(@class,'row')]")
    private WebElement catalogList;

    public boolean checkHeader(String hName){
        return pageHeader.getText().equals(hName);
    }

    public void clickToPart(String linkName,WebDriver driver){
        String xpath = "(//span[contains(text(),'"+ linkName +"')])[2]/parent::a ";
        WebElement clickPart = listSideMenu.findElement(By.xpath(xpath));
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + clickPart.getLocation().y + ")");
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
        if(catalogList !=null)
        {
            returnMassage +="Каталог присутствует на " + pageName +"!\n";
        }
        else
        {
            returnMassage +="Каталог отсутствует на " + pageName + "!\n";
        }
        return returnMassage;
    }
}
