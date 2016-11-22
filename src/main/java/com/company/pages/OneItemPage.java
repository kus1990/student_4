package com.company.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OneItemPage extends BasePage {
    public OneItemPage (WebDriver driver){
        this.pageName = "--раздел одного товара--";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        js = (JavascriptExecutor) driver;
    }

    private String pageName;
    @FindBy(xpath="(.//*[@id='b-dropdown-catalog-menu']//ul[contains(@class,'b-list_catalog-menu')])[1]")
    private WebElement listSideMenu;

    @FindBy(id="searchField")
    private WebElement searchInputField;

    @FindBy(id="mainSearchButton")
    private WebElement searchInputBut;

    @FindBy(xpath="//h1")
    private WebElement pageHeader;

    @FindBy(xpath="//li[contains(@class,'b-art')]/span[2]")
    private WebElement itemArt;

    public void setFindText(String textSearch){
        searchInputField.sendKeys(textSearch);
    }

    public void clickToMenuLink(String linkName,WebDriver driver){
        WebElement clickPart = listSideMenu.findElement(By.xpath("//li/a[@data-gtm-eventcontent = '" + linkName +"']"));
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + clickPart.getLocation().y + ")");
        clickPart.click();
    }

    public boolean checkHeader(String hName){
        return this.pageHeader.getText().toLowerCase().equals(hName.toLowerCase());
    }

    public boolean checkHeaderContains(String hName){
        return this.pageHeader.getText().toLowerCase().contains(hName.toLowerCase());
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
        if(itemArt !=null)
        {
            returnMassage +="Артикул присутствуют на " + pageName +"!\n";
        }
        else
        {
            returnMassage +="Артикул отсутствуют на " + pageName + "!\n";
        }
        return returnMassage;
    }

    public void setAttribute(WebElement element, String attName, String attValue) {
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                element, attName, attValue);
    }

    public void clickFindText(){
        searchInputBut.click();
    }
}
