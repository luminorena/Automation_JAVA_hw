package selenide_2_task;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class GitHubTests {
    @Test
    void gitHubTests() {
        Configuration.holdBrowserOpen = true;
        open("https://github.com/");
        ($x("//li[2]/button")).hover();
        $x("//a[contains(text(),'Enterprise')]").click();
        $x("//h1").shouldHave(text("Build like the best"));

    }


}
