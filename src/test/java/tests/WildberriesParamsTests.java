package tests;

import com.codeborne.selenide.Configuration;
import data.ItemName;
import data.MainElements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class WildberriesParamsTests {

    @ValueSource(strings = {"платье", "брюки"})
    @ParameterizedTest(name = "Проверка поиска по категориям для запроса {0}")
    void searchItemsTests(String testData){
        Configuration.holdBrowserOpen = true;
        open("https://www.wildberries.ru/");
        $("#searchInput").setValue(testData).pressEnter();
        $(".goods-name").shouldHave(text(testData));
    }

    @CsvSource({"платье, По запросу «платье» найдено", "брюки, По запросу «брюки» найдено"})
    @ParameterizedTest(name = "Проверка отображения результатов по запросу {0}")
    void checkGeneralResultsTests(String searchQuery, String resultString) {
        Configuration.holdBrowserOpen = true;
        open("https://www.wildberries.ru/");
        $("#searchInput").setValue(searchQuery).pressEnter();
        $(".searching-results__title").shouldHave(text(resultString));
    }

    static Stream<Arguments> arraySearchTestData() {
            return Stream.of(
                    Arguments.of(ItemName.платье, List.of("Крестильные платья"
                            , "Крестильные платья для малышей")),
                    Arguments.of(ItemName.брюки, List.of("Брюки",
                            "Брюки для малышей"))
            );
    }
    @MethodSource ("arraySearchTestData")
    @ParameterizedTest(name = "Проверка совпадения массива объектов по запросу {0}")
    void checkArraySearchTests(ItemName itemName, List<String> objects){
        Configuration.holdBrowserOpen = true;
        open("https://www.wildberries.ru/");
        $("#searchInput").setValue(itemName.name()).pressEnter();
        /*$$x("//fieldset/label")
                .filter(visible)
                .shouldHave(CollectionCondition.texts(objects));*/
        List<String> texts = $$x("//fieldset/label")
                .filter(visible).texts();
        Assertions.assertEquals(objects, texts);

    }

    @EnumSource(MainElements.class)
    @ParameterizedTest
    void checkLocale(MainElements mainElements) {
        Configuration.holdBrowserOpen = true;
        open("https://www.wildberries.ru/");
        $$("a.navbar-pc__link.j-wba-header-item")
                .find(text(mainElements.name())).shouldBe(visible);

    }

}
