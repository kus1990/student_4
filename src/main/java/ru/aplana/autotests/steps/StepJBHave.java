package ru.aplana.autotests.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class StepJBHave {

    @Steps
    MainPageSteps mainSteps;

    @Given("перейти на $pageurl")
    public void goToMainPage(String pageUrl){
        mainSteps.setUpBrowser(pageUrl);
    }

    @When("перейти в яндекс маркет")
    public void goToMarketStory(){
        mainSteps.goToMarket();
    }

    @When("Выбрать раздел $linkn")
    public void goToComplexPartStory(String linkn){
        mainSteps.goToComplexPart(linkn);
    }

    @When("Выбрать подраздел $linkn")
    public void goToComplexSubPart(String linkn){
        mainSteps.goToComplexSubPart(linkn);
    }

    @When("задать минимальную стоимость $mprice")
    public void setMinPriceStory(int mprice){
        mainSteps.setMinPrice(mprice);
    }

    @When("выбрать компании: $clist")
    public void setCompanyeListStory(String cList){
        mainSteps.setCompanyList(cList);
    }

    @When("нажать кнопку применить")
    public void goToSearchResultStory(){
        mainSteps.goToSearchResult();
    }

    @Then("проверить количество элементов:$count")
    public void chekElCountStory(int count){
        mainSteps.chekElCount(count);
    }

    @When("запомнить $elindex элемент в списке")
    public void storeFirstElementStory(int elindex){
        mainSteps.storeFirstElement(elindex);
    }

    @When("ввести в поисковую строку запомненное значение и найти")
    public void setSearchStringStory(){
        mainSteps.setSearchString();
    }

    @Then("проверить наименование товара")
    public void checkItemHeaderStory(){
        mainSteps.checkItemHeader();
    }

}
