package ru.aplana.autotests.steps;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.aplana.autotests.halpers.PropertyParser;

public class StepJBHave {
    public enum browsers {
        chrome,
        firefox
    }

    @Steps
    MainPageSteps mainSteps;

    @Given("открыта главная страница")
    public void openHomePage(){
        String drw = PropertyParser.loadProperty("driverManage");
        browsers ntr = browsers.valueOf(drw);
        String workingDir = System.getProperty("user.dir");

      /*  switch (ntr) {
            case chrome:
                System.setProperty("webdriver.chrome.driver", workingDir + "/drivers/chromedriver");
            case firefox:
                System.setProperty("webdriver.firefox.marionette", workingDir + "/drivers/geckodriver");
            default:
                System.setProperty("webdriver.chrome.driver", workingDir + "/drivers/chromedriver");
        }*/

        String baseUrl = PropertyParser.loadProperty("stageURL");
        ThucydidesWebDriverSupport.getDriver().get(baseUrl);
    }

    @Then("проверить элементы главной страницы")
    public void checkMainPageElements(){
        mainSteps.checkMainPageElementsStep();
    }

    @Then("проверить элементы на странице навигации")
    public void checkNavPageElements(){ mainSteps.checkNavPageElementsStep();}

    @Then("проверить элементы на странице списка товаров")
    public void checkItemListElements(){ mainSteps.checkItemListElementsStep();}

    @Then("проверить элементы на странице одного товара")
    public void checkOneItemElements(){mainSteps.checkOneItemElementsStep();}

    @When("нажать на кнопку $linkName в меню на главной странице")
    public void clickToMenuPart(String linkName){
        mainSteps.clickToMenuPartStep(linkName);
    }

    @Then("проверить совпадение заголовка с $pagename на странице списка товаров")
    public void checkHeader(String pagename){
       mainSteps.checkHeaderStep(pagename);
    }

    @Then("проверить совпадение заголовка с $pagename на странице навигации")
    public void checkHeaderNav(String pagename){
        mainSteps.checkHeaderNavStep(pagename);
    }

    @Then("проверить совпадение заголовка с $pagename на странице одного товара")
    public void checkHeaderOneItem(String pagename){ mainSteps.checkHeaderOneItemStep(pagename);}

    @When("нажать на раздел $partname навигации")
    public void clickToPart(String partname){
        mainSteps.clickToPartStep(partname);
    }

    @When("нажать на последний элемент в списке товаров")
    public void clickToLastElement(){
        mainSteps.clickToLastElementPart();
    }
}
