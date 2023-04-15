package OwnerTests.tests;

import OwnerTests.data.ItemName;
import OwnerTests.data.MainElements;
import OwnerTests.pages.ChooseProductsPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;


public class WildberriesParamsTests extends TestBase {
    ChooseProductsPage productsPage = new ChooseProductsPage();

   @Test
    void openMainPage(){
      productsPage.openMainPage();
    }


    @ValueSource(strings = {"платье", "брюки"})
    @ParameterizedTest(name = "Проверка поиска по категориям для запроса {0}")
    void searchItemsTests(String testData) {
        productsPage.openMainPage();
        productsPage.searchItem(testData);
    }


    @CsvSource({"платье, По запросу «платье» найдено", "брюки, По запросу «брюки» найдено"})
    @ParameterizedTest(name = "Проверка отображения результатов по запросу {0}")
    void checkGeneralResultsTests(String searchQuery, String resultString) {
        productsPage.openMainPage();
        productsPage.parametrizedCsvSearch(searchQuery, resultString);
    }

    static Stream<Arguments> arraySearchTestData() {
        return Stream.of(
                Arguments.of(ItemName.valueOf("DRESS"), List.of("Крестильные платья"
                        , "Крестильные платья для малышей")),
                Arguments.of(ItemName.valueOf("TROUSERS"), List.of("Брюки",
                        "Брюки для малышей"))
        );
    }


    @MethodSource("arraySearchTestData")
    @ParameterizedTest(name = "Проверка совпадения массива объектов по запросу {0}")
    void checkArraySearchTests(ItemName itemName, List<String> objects) {
        productsPage.openMainPage();
        productsPage.parametrizedArraySearch(itemName, objects);
    }


    @EnumSource(MainElements.class)
    @ParameterizedTest
    void checkLocale(MainElements mainElements) {
        productsPage.openMainPage();
        productsPage.locale(mainElements);

    }


}
