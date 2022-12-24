package parametrizedTests.tests;

import org.junit.jupiter.api.Disabled;
import parametrizedTests.data.ItemName;
import parametrizedTests.data.MainElements;
import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class WildberriesParamsTests {
    @Disabled
    @ValueSource(strings = {"платье", "брюки"})
    @ParameterizedTest(name = "Проверка поиска по категориям для запроса {0}")
    void searchItemsTests(String testData) {
        open("https://www.wildberries.ru/");
        $("#searchInput").setValue(testData).pressEnter();
        $(".goods-name").shouldHave(text(testData));
    }
    @Disabled
    @CsvSource({"платье, По запросу «платье» найдено", "брюки, По запросу «брюки» найдено"})
    @ParameterizedTest(name = "Проверка отображения результатов по запросу {0}")
    void checkGeneralResultsTests(String searchQuery, String resultString) {
        open("https://www.wildberries.ru/");
        $("#searchInput").setValue(searchQuery).pressEnter();
        $(".searching-results__title").shouldHave(text(resultString));
    }

    static Stream<Arguments> arraySearchTestData() {
        return Stream.of(
                Arguments.of(ItemName.valueOf("DRESS"), List.of("Крестильные платья"
                        , "Крестильные платья для малышей")),
                Arguments.of(ItemName.valueOf("TROUSERS"), List.of("Брюки",
                        "Брюки для малышей"))
        );
    }
    @Disabled
    @MethodSource("arraySearchTestData")
    @ParameterizedTest(name = "Проверка совпадения массива объектов по запросу {0}")
    void checkArraySearchTests(ItemName itemName, List<String> objects) {
        open("https://www.wildberries.ru/");
        $("#searchInput").setValue(itemName.getTitle()).pressEnter();
        $$("#filters .filter").get(0)
                .$$(".filter__item")
                .first(2)
                .shouldHave(CollectionCondition.texts(objects));
    }
    @Disabled
    @EnumSource(MainElements.class)
    @ParameterizedTest
    void checkLocale(MainElements mainElements) {
        open("https://www.wildberries.ru/");
        $$("a.navbar-pc__link.j-wba-header-item")
                .find(text(mainElements.getTitle())).shouldBe(visible);

    }


}
