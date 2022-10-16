package AllureReports;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.name;

public class SteppedTest {

    @Step("Открыть главную страницу")
    public SteppedTest openMainPage() {
        open("https://github.com/");
        return this;
    }

    @Step("Найти репозиторий {repository}")
    public SteppedTest findRepository(String repository) {
        $(name("q")).setValue(repository).pressEnter();
        return this;
    }

    @Step("Перейти в репозиторий {repository}")
    public SteppedTest goToRepository(String repository) {
        $(linkText(repository)).click();
        return this;
    }

    @Step("Проверить, что репозиторий {repository} содержит" +
            "название  {repoName}")
    public SteppedTest checkRepoName(String repoName) {
        $(".js-repo-nav").shouldHave(Condition.text(repoName));
        return this;
    }


}

