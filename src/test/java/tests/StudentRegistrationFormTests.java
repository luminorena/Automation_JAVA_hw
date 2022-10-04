package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;


public class StudentRegistrationFormTests extends TestBase {

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
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phone)
                .setBirthDate(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobbies)
                .setFileUpload("src/test/resources/" + filePath)
                .setAddress(currentAddress)
                .setStateAndCity(state, city)
                .clickSubmit();


        // submitting checks

        studentRegistrationFormPage.checkModalWindowVisible()
                .checkResult("Student Name", firstName + "\n" + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phone)
                .checkResult("Date of Birth", day + ' ' + month + ',' + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", filePath)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city)
                .closeModalWindow();
    }

    @Test
    void doRegisterWithMinimumDataForm() throws InterruptedException {
        studentRegistrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phone)
                .clickSubmit();

        // submitting checks

        studentRegistrationFormPage.checkModalWindowVisible()
                .checkResult("Student Name", firstName + "\n" + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phone)
                .closeModalWindow();
    }


}
