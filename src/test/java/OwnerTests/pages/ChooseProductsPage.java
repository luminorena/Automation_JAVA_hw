package OwnerTests.pages;

import OwnerTests.config.WebConfig;
import OwnerTests.data.ItemName;
import OwnerTests.data.MainElements;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class ChooseProductsPage {

    private final SelenideElement searchInput = $("#searchInput");
    private final SelenideElement goodsName = $(".goods-name");
    private final SelenideElement searchResult = $(".searching-results__title");
    private final ElementsCollection filter = $$("#filters .filter");
    private final ElementsCollection filterItem = $$(".filter__item");
    private final ElementsCollection localeList = $$("a.navbar-pc__link.j-wba-header-item");

    public void openMainPage(){
        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());
        open(config.baseUrl());
        String expectedTitle = "Wildberries - модный интернет магазин";
        String actualTitle = title();
        Assertions.assertEquals(expectedTitle, actualTitle);
    }

    public void searchItem(String testData){
        searchInput.setValue(testData).pressEnter();
        goodsName.shouldHave(text(testData));
    }

    public void parametrizedCsvSearch(String searchQuery, String resultString ){
        searchInput.setValue(searchQuery).pressEnter();
        searchResult.shouldHave(text(resultString));
    }

    public void parametrizedArraySearch(ItemName itemName, List<String> objects) {
        searchInput.setValue(itemName.getTitle()).pressEnter();
        filter.get(0)
                .$$(".filter__item") // If I put filterItem here, it won't work. Why?
                .first(2)
                .shouldHave(CollectionCondition.texts(objects));
    }

    public void locale(MainElements mainElements) {
        localeList.find(text(mainElements.getTitle())).shouldBe(visible);
    }


}
