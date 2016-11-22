package com.company.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class UlmartMainPage extends BasePage {
    public UlmartMainPage(WebDriver driver){
        this.pageName = "--главная--";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 1000);
    }

    private String pageName;
    @FindBy(xpath="(//*[@id='b-dropdown-catalog-menu']//ul[contains(@class,'b-list_catalog-menu')])[1]")
    private WebElement listSideMenu;

    @FindBy(id="searchField")
    private WebElement searchInputField;

    @FindBy(id="mainSearchButton")
    private WebElement searchInputBut;

    public void setFindText(String textSearch){
        searchInputField.sendKeys(textSearch);
    }

    public void clickToMenuLink(String linkName,WebDriver driver){
        WebElement clickPart = listSideMenu.findElement(By.xpath("//li/a[@data-gtm-eventcontent = '" + linkName +"']"));
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + clickPart.getLocation().y + ")");
        clickPart.click();
    }

    public String allElementsIsPresent(){
        String returnMassage = "";
        if(listSideMenu !=null)
        {
            returnMassage +="Боковая панель присутствует на главной странице!\n";
        }
        else
        {
            returnMassage +="Боковая панель отсутствует на главной странице!\n";
        }
        if(searchInputField !=null)
        {
            returnMassage +="Поле поиска присутствует на главной странице!\n";
        }
        else
        {
            returnMassage +="Поле поиска отсутствует на главной странице!\n";
        }
        if(searchInputBut !=null)
        {
            returnMassage +="Кнопка поиска присутствует на главной странице!\n";
        }
        else
        {
            returnMassage +="Кнопка поиска отсутствует на главной странице!\n";
        }
        return returnMassage;
    }
    public void clickFindText(){
        searchInputBut.click();
    }
}
