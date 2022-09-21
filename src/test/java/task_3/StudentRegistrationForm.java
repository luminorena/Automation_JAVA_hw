package task_3;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
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

    @AfterAll
    static void TearDown() {
        $("#closeLargeModal").click();
    }



   /*
    @Test
    void doRegisterIndividualChecks() {
        //Name
        $("#firstName")
                .shouldHave(Condition
                        .cssValue("background-image"
                                , "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8' viewBox='0 0 8 8'%3e%3cpath fill='%2328a745' d='M2.3 6.73L.6 4.53c-.4-1.04.46-1.4 1.1-.8l1.1 1.4 3.4-3.8c.6-.63 1.6-.27 1.2.7l-4 4.6c-.43.5-.8.4-1.1.1z'/%3e%3c/svg%3e\")"));
        $("#lastName")
                .shouldHave(Condition
                        .cssValue("background-image"
                                , "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8' viewBox='0 0 8 8'%3e%3cpath fill='%2328a745' d='M2.3 6.73L.6 4.53c-.4-1.04.46-1.4 1.1-.8l1.1 1.4 3.4-3.8c.6-.63 1.6-.27 1.2.7l-4 4.6c-.43.5-.8.4-1.1.1z'/%3e%3c/svg%3e\")"));
        //Email - в идеале надо генерить данные, а потом проверять по регулярке совпадение
        $("#userEmail")
                .shouldHave(Condition
                        .cssValue("background-image"
                                , "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8' viewBox='0 0 8 8'%3e%3cpath fill='%2328a745' d='M2.3 6.73L.6 4.53c-.4-1.04.46-1.4 1.1-.8l1.1 1.4 3.4-3.8c.6-.63 1.6-.27 1.2.7l-4 4.6c-.43.5-.8.4-1.1.1z'/%3e%3c/svg%3e\")"));
        Boolean emailRegex = Pattern
                .matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", email);
        Assertions.assertTrue(emailRegex);

        // Gender
        $x("\"//div[@id='genterWrapper']/div[2]/div[2]/label\"")
                .shouldHave(Condition
                        .cssValue("color", "#28a745"));
        // Mobile
        $("#userNumber")
                .shouldHave(Condition
                        .cssValue("background-image"
                                , "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8' viewBox='0 0 8 8'%3e%3cpath fill='%2328a745' d='M2.3 6.73L.6 4.53c-.4-1.04.46-1.4 1.1-.8l1.1 1.4 3.4-3.8c.6-.63 1.6-.27 1.2.7l-4 4.6c-.43.5-.8.4-1.1.1z'/%3e%3c/svg%3e\")"));
        Boolean phoneRegex = Pattern
                .matches("\\d*", String.valueOf(phoneNumber));
        Assertions.assertTrue(phoneRegex);
        // Date of Birth
        $("#dateOfBirthInput")
                .shouldHave(Condition
                        .cssValue("background-image"
                                , "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8' viewBox='0 0 8 8'%3e%3cpath fill='%2328a745' d='M2.3 6.73L.6 4.53c-.4-1.04.46-1.4 1.1-.8l1.1 1.4 3.4-3.8c.6-.63 1.6-.27 1.2.7l-4 4.6c-.43.5-.8.4-1.1.1z'/%3e%3c/svg%3e\")"));
        // Subjects
        $("#subjectsInput").shouldHave(text("Hindi"));
        // Hobbies
        $x("//div[@id='hobbiesWrapper']/div[2]/div/label")
                .shouldHave(Condition
                        .cssValue("background-image"
                                , "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8' viewBox='0 0 8 8'%3e%3cpath fill='%2328a745' d='M2.3 6.73L.6 4.53c-.4-1.04.46-1.4 1.1-.8l1.1 1.4 3.4-3.8c.6-.63 1.6-.27 1.2.7l-4 4.6c-.43.5-.8.4-1.1.1z'/%3e%3c/svg%3e\")"));

        // picture
        $("#uploadPicture").shouldHave(text("11.png"));
        // current address
        $("#currentAddress").shouldHave(text(currentAddress));
        // state and city
        $("#react-select-3-input").shouldHave(text("NCR"));
        $("#react-select-4-input").shouldHave(text("Delhi"));


    }

    */

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


    }

    @Test
    void SubmittingFormChecks() {
        // Student Name
        $x("//td[2]").shouldHave(Condition.attribute(firstName + "\n" + lastName));
        // Student Email
        $x("//tr[2]/td[2]").shouldHave(Condition.attribute(email));
        // Gender
        $x("//tr[3]/td[2]").shouldHave(Condition.attribute("Female"));
        // Mobile
        $x("//tr[4]/td[2]").shouldHave(Condition.attribute(String.valueOf(phoneNumber)));
        // Date of Birth
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM, yyyy");
        String text = dtf.format(LocalDateTime.now());
        System.out.println(text);
        $x("//tr[5]/td[2]").shouldHave(text(text));
        // Subjects
        $x("//tr[6]/td[2]").shouldHave(Condition.attribute("Hindi"));
        // Hobbies
        $x("//tr[7]/td[2]").shouldHave(Condition.attribute("Sports"));
        // Picture
        $x("//tr[8]/td[2]").shouldHave(Condition.attribute("11.png"));
        //Address
        $x("//tr[9]/td[2]").shouldHave(Condition.attribute("Address"));
        // State and City
        $x("//tr[10]/td[2]").shouldHave(Condition.attribute("NCR Delhi"));

    }

}
