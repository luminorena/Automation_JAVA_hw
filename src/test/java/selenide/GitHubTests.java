package selenide;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTests {
    @Test
    void softAssertionsFindPageTests() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
        $x("//a[contains(text(),'SoftAssertions')]")
               .shouldHave(text("SoftAssertions"));
        $$(".details-reset a").findBy(text("SoftAssertions")).click();
        $(".markdown-body")
                .shouldHave(text("com.codeborne.selenide.junit5.SoftAssertsExtension"));
    }
}
