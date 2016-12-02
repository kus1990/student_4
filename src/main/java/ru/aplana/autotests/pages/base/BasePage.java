package ru.aplana.autotests.pages.base;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class BasePage extends PageObject {

    protected JavascriptExecutor js = (JavascriptExecutor) ThucydidesWebDriverSupport.getDriver();

    public void setAttribute(WebElement element, String attName, String attValue) {
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                element, attName, attValue);
    }

    public void scrollToElement(WebElement elem){
        js.executeScript("window.scrollTo(" + elem.getLocation().x  +"," + elem.getLocation().y + ")");
    }
}
