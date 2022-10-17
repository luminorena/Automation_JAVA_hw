package allureReports;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.name;

public class SelenideTest {

    @Test
    public void testIssueName() {
        open("https://github.com/");
        $(name("q")).setValue("luminorena/Automation_JAVA_hw").pressEnter();
        $(linkText("luminorena/Automation_JAVA_hw")).click();
        $(".js-repo-nav").shouldHave(Condition.text("Issues"));

    }
}
