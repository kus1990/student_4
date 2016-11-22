package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

abstract public class BasePage {
    protected JavascriptExecutor js;

    protected String pageName;

    @FindBy(xpath="(.//*[@id='b-dropdown-catalog-menu']//ul[contains(@class,'b-list_catalog-menu')])[1]")
    protected WebElement listSideMenu;

    @FindBy(id="searchField")
    protected WebElement searchInputField;

    @FindBy(id="mainSearchButton")
    protected WebElement searchInputBut;

    public boolean checkUrl(WebDriver driver,String url){
        return driver.getCurrentUrl().equals(url);
    }

    public void setAttribute(WebElement element, String attName, String attValue) {
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                element, attName, attValue);
    }

    public void clickToMenuLink(String linkName,WebDriver driver){
        WebElement clickPart = listSideMenu.findElement(By.xpath("//li/a[@data-gtm-eventcontent = '" + linkName +"']"));
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + clickPart.getLocation().y + ")");
        clickPart.click();
    }

    public void setFindText(String textSearch){
        searchInputField.sendKeys(textSearch);
    }
}
