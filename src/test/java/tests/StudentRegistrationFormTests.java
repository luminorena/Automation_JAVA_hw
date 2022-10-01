package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

import static com.codeborne.selenide.Selenide.$;

public class StudentRegistrationFormTests {

    StudentRegistrationFormPage studentRegistrationFormPage
            = new StudentRegistrationFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void doRegisterFillForm() throws InterruptedException {
        studentRegistrationFormPage.openPage()
                .setFirstName("Kolya")
                .setLastName("Petrov")
                .setEmail("petrov@yandex.ru")
                .setGender("Male")
                .setPhoneNumber("1234567890")
                .setBirthDate("09", "September", "2006")
                .setSubjects("Hindi")
                .setHobbies("Sports")
                .setFileUpload("src/test/resources/11.png")
                .setAddress("currentAddress")
                .setStateAndCity("NCR", "Delhi");
                $("#submit").click();

        // submitting checks

        studentRegistrationFormPage.checkModalWindowVisible()
                        .checkResult("Student Name", "Kolya" + "\n" + "Petrov")
                        .checkResult("Student Email", "petrov@yandex.ru")
                        .checkResult("Gender", "Male")
                        .checkResult("Mobile", "1234567890")
                        .checkResult("Date of Birth", "09" + ' ' + "September" + ',' + "2006")
                        .checkResult("Subjects", "Hindi")
                        .checkResult("Hobbies", "Sports")
                        .checkResult("Picture","11.png")
                        .checkResult("Address", "Address")
                        .checkResult("State and City", "NCR Delhi");
        $("#closeLargeModal").click();
    }

    @Test
    void doRegisterWithMinimumDataForm() throws InterruptedException {
        studentRegistrationFormPage.openPage()
                .setFirstName("Kolya")
                .setLastName("Petrov")
                .setEmail("petrov@yandex.ru")
                .setGender("Male")
                .setPhoneNumber("1234567890");

        $("#submit").click();

        // submitting checks

        studentRegistrationFormPage.checkModalWindowVisible()
                .checkResult("Student Name", "Kolya" + "\n" + "Petrov")
                .checkResult("Student Email", "petrov@yandex.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890");
        $("#closeLargeModal").click();
    }


}
