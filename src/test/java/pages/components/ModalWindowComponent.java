package pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalWindowComponent {

    public final static String SUBMIT_TEXT = "Thanks for submitting the form";

    public ModalWindowComponent checkVisible() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg")
                .shouldHave(text(SUBMIT_TEXT));
        return this;
    }

    public ModalWindowComponent checkResult(String key, String value) {
        $(".table-responsive table").$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }
}
