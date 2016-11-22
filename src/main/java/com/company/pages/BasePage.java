package com.company.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

abstract public class BasePage {
    protected JavascriptExecutor js;

    public boolean checkUrl(WebDriver driver,String url){
        return driver.getCurrentUrl().equals(url);
    }

}
