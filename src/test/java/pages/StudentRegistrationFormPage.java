package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ModalWindowComponent;
import tests.TestBase;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormPage extends TestBase {

    public final static String TITLE_TEXT = "Student Registration Form";
    // Components
    private  CalendarComponent calendarComponent = new CalendarComponent();
    private ModalWindowComponent modalWindowComponent = new ModalWindowComponent();
    // Elements
    private SelenideElement
             firstNameInput = $("#firstName")
            ,lastNameInput = $("#lastName")
            ,emailInput = $("#userEmail")
            ,genderRadioButton = $("#genterWrapper")
            ,phoneNumber = $("#userNumber")
            ,subjectMultiSelect = $("#subjectsInput")
            ,hobbiesCheckBox = $("#hobbiesWrapper")
            ,uploadFile = $("#uploadPicture")
            ,currentAddress = $("#currentAddress")
            ,stateComboBox = $("#state")
            ,cityComboBox = $("#city")
            ,submitButton =$("#submit")
            ,closeModalButton =  $("#closeLargeModal");

    // Actions
    public StudentRegistrationFormPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    return this;
    }


    public StudentRegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public StudentRegistrationFormPage clearFirstName() {
        firstNameInput.clear();
        return this;
    }


    public StudentRegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public StudentRegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public StudentRegistrationFormPage setGender(String value) {
        genderRadioButton.$(byText(value)).click();
        return this;
    }

    public StudentRegistrationFormPage setPhoneNumber(String value) {
        phoneNumber.setValue(value);
        return this;
    }

    public StudentRegistrationFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day,month, year);
        return this;
    }

    public StudentRegistrationFormPage setSubjects (String value) {
        subjectMultiSelect.setValue(value).pressEnter();
        return this;
    }

    public StudentRegistrationFormPage setHobbies (String value) {
        hobbiesCheckBox.$(byText(value)).click();
        return this;
    }

    public StudentRegistrationFormPage setFileUpload(String path) {
        uploadFile.uploadFile(new File(path));
        return this;
    }
    public StudentRegistrationFormPage setAddress (String value) {
        currentAddress.setValue(value);
        return this;
    }

    public StudentRegistrationFormPage setStateAndCity (String state, String city) {
        stateComboBox.click();
        stateComboBox.$(byText(state)).click();
        cityComboBox.click();
        cityComboBox.$(byText(city)).click();
        return this;
    }

    public StudentRegistrationFormPage clickSubmit () {
        submitButton.scrollTo().click();
        return this;
    }

    public StudentRegistrationFormPage closeModalWindow(){
        closeModalButton.click();
        return this;
    }

    public StudentRegistrationFormPage checkModalWindowVisible() {
        modalWindowComponent.checkVisible();
        return this;
    }

    public StudentRegistrationFormPage checkResult(String key, String value){
        modalWindowComponent.checkResult(key, value);
        return this;
    }



}
