package task_3;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm {
    public String firstName = "test1";
    public String lastName = "test2";
    public String email = "1@gmail.com";
    public int phoneNumber = 1234567890;
    public String currentAddress = "Address";

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void doRegisterFillForm() throws InterruptedException {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue(String.valueOf(phoneNumber));
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--009:not(.react-datepicker__day--outside-month)")
                .click();

        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/11.png"));
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        // submitting checks

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive table").$(byText("Student Name"))
                .parent().shouldHave(text(firstName + "\n" + lastName));
        $(".table-responsive table").$(byText("Student Email"))
                .parent().shouldHave(text(email));
        $(".table-responsive table").$(byText("Gender"))
                .parent().shouldHave(text("Female"));
        $(".table-responsive table").$(byText("Mobile"))
                .parent().shouldHave(text(String.valueOf(phoneNumber)));
        $(".table-responsive table").$(byText("Date of Birth"))
                .parent().shouldHave(text("09 September,2008"));
        $(".table-responsive table").$(byText("Subjects"))
                .parent().shouldHave(text("Hindi"));
        $(".table-responsive table").$(byText("Hobbies"))
                .parent().shouldHave(text("Sports"));
        $(".table-responsive table").$(byText("Picture"))
                .parent().shouldHave(text("11.png"));
        $(".table-responsive table").$(byText("Address"))
                .parent().shouldHave(text("Address"));
        $(".table-responsive table").$(byText("State and City"))
                .parent().shouldHave(text("NCR Delhi"));

        $("#closeLargeModal").click();
    }


}
