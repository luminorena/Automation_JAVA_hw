package selenide_lesson_1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class SelenideContributors {
    @Test
    void firstContributorTest(){
        open("https://github.com/selenide/selenide");
        $(".Layout-sidebar")
                .$(Selectors.byText("Contributors"))
                .ancestor(".BorderGrid-cell").$$("ul li")
                .first().hover();
        $$(".Popover-message").findBy(Condition.visible)
                .shouldHave(text("Andrei Solntsev"));
        sleep(5000);
    }
}
