package task_3;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
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
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue(String.valueOf(phoneNumber));
        $("#dateOfBirthInput").click();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/11.png"));
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#submit").click();

        // submitting checks

        // Student Name
        $x("//td[2]").shouldHave(text(firstName + "\n" + lastName));
        // Student Email
        $x("//tr[2]/td[2]").shouldHave(text(email));
        // Gender
        $x("//tr[3]/td[2]").shouldHave(text("Female"));
        // Mobile
        $x("//tr[4]/td[2]").shouldHave(text(String.valueOf(phoneNumber)));
        // Date of Birth
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM,yyyy");
        String text = dtf.format(LocalDateTime.now());
        System.out.println(text);
        $x("//tr[5]/td[2]").shouldHave(text(text));
        // Subjects
        $x("//tr[6]/td[2]").shouldHave(text("Hindi"));
        // Hobbies
        $x("//tr[7]/td[2]").shouldHave(text("Sports"));
        // Picture
        $x("//tr[8]/td[2]").shouldHave(text("11.png"));
        //Address
        $x("//tr[9]/td[2]").shouldHave(text("Address"));
        // State and City
        $x("//tr[10]/td[2]").shouldHave(text("NCR Delhi"));

        $("#closeLargeModal").click();
    }


}
