package selenide_1;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.name;

public class SelenideRepositorySearch {
    @Test
    void findSelenideRepository() {
        Configuration.holdBrowserOpen = true;
        open("https://github.com/");
        $(name("q")).setValue("selenide").pressEnter();
        $$(".repo-list li").first().$("a").click();

        $("#repository-container-header").shouldHave(text("selenide"));
        sleep(5000);


       /*  структура unit тестов:
         Arrange
         Act
         Assert*/

        /*Структура UI тестов
        Arrange
         Act
         Assert
         Act
         Assert
         Act
         Assert
        */

    }
}
