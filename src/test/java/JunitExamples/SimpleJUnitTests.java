package JunitExamples;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import data.Locale;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SimpleJUnitTests {

    @ValueSource(strings = {"selenide","Junit"} )
    @ParameterizedTest(name = "Проверка числа результатов поиска для запроса {0}")
    void yandexSearchTest(String testData){
        Configuration.holdBrowserOpen = true;
        open("https://ya.ru");
        $("#text").setValue(testData);
        $("button[type='submit']").click();
        $$("li.serp-item")
                .shouldHave(CollectionCondition.size(10))
                .first().shouldHave(text(testData));

    }

    @CsvSource( {"Selenide, Selenide - это фреймворк для автоматизированного тестирования",
            "Junit, В этом туториале по JUnit 5 рассказывается о том"})

    @ParameterizedTest(name = "Проверка числа результатов поиска для запроса {0}")
    void yandexSearchDifferentParamsTest(String searchQuery, String expectedText){
        Configuration.holdBrowserOpen = true;
        open("https://ya.ru");
        $("#text").setValue(searchQuery);
        $("button[type='submit']").click();
        $$("li.serp-item")
                .shouldHave(CollectionCondition.size(11))
                .first().shouldHave(text(expectedText));

    }

    static Stream<Arguments> selenideButtonsTestDataProvider(){
        return Stream.of(
                Arguments.of(Locale.EN, List.of("Quick start"
                        ,"Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes")),
                Arguments.of(Locale.RU, List.of("С чего начать?",
                        "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы"))
        );
    }
    @MethodSource ("selenideButtonsTestDataProvider")
    @ParameterizedTest (name = "Проверка отображения названия кнопок для локали: {0}")
    void selenideButtonsTest(Locale locale, List<String> buttonsTexts) {
        open("https://selenide.org/");
        // $$ - ищет все элементы, удовлетворяющие селектору
        $$("#languages a").find(text(locale.name())).click();
        $$(".main-menu-pages a").filter(visible)
                .shouldHave(CollectionCondition.texts(buttonsTexts));

    }

    @EnumSource(Locale.class)
    @ParameterizedTest
    void checkLocaleTest(Locale locale) {
        open("https://selenide.org/");
        $$("#languages a").find(text(locale.name())).shouldBe(visible);

    }



}
