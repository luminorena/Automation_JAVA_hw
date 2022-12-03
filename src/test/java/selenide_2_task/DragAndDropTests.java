package selenide_2_task;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests {
    @Test
    void dragAndDropTests() {
        Configuration.holdBrowserOpen = true;
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // Не работает
        actions().moveToElement($("#column-a"))
                .clickAndHold()
                .moveToElement($("#column-b"))
                .release().perform();

        // Работает
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a").shouldHave(text("B"));


    }
}
