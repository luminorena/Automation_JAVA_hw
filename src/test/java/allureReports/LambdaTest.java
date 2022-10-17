package allureReports;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.name;

public class LambdaTest {

    public static final String REPOSITORY = "luminorena/Automation_JAVA_hw";
    public static final String CHECKEDTABNAME = "Issues";

    @Test
    public void lambdaTest() {
        step("Открыть главную страницу", () -> {
            open("https://github.com/");
        });
        step("Найти репозиторий + REPOSITORY", () -> {
            $(name("q")).setValue(REPOSITORY).pressEnter();
        });
        step("Перейти в репозиторий + REPOSITORY", () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Проверить, что репозиторий + REPOSITORY + содержит" +
                "название  + CHECKEDTABNAME", () -> {
            $(".js-repo-nav").shouldHave(Condition.text(CHECKEDTABNAME));
        });

    }
}
