package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultsTableComponent;
import pages.components.UploadFileComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {

    public CalendarComponent calendarComponent = new CalendarComponent();
    public ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    public UploadFileComponent uploadFileComponent = new UploadFileComponent();

    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput =  $("#lastName"),
            emailInput =  $("#userEmail"),
            genderRadioButton =  $("#genterWrapper"),
            mobileInput =  $("#userNumber"),
            dateOfBirthInput =  $("#dateOfBirthInput"),
            subjectsInput =  $("#subjectsInput"),
            hobbiesCheckbox =  $("#hobbiesWrapper"),
            currentAddressTextArea =  $("#currentAddress"),
            stateList =  $("#state"),
            cityList =  $("#city"),
            selectFromList =  $("#stateCity-wrapper"),
            buttonSubmit =  $("#submit"),
            modalTitle =  $("#example-modal-sizes-title-lg");

    public RegistrationFormPage openPage (){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName (String value){
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName (String value){
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail (String value){
        emailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setGender (String value){
        genderRadioButton.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setNumber (String value){
        mobileInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setDateOfBirth (String day, String month, String year){
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setSubject (String value){
        subjectsInput.sendKeys(value);
        subjectsInput.pressEnter();

        return this;
    }

    public RegistrationFormPage setHobbie (String value){
        hobbiesCheckbox.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage uploadFile (String value){
        uploadFileComponent.uploadFile(value);

        return this;
    }

    public RegistrationFormPage setAddress (String value){
        currentAddressTextArea.setValue(value);

        return this;
    }

    public RegistrationFormPage setStateCity (String state, String city){
        stateList.click();
        selectFromList.$(byText(state)).click();
        cityList.click();
        selectFromList.$(byText(city)).click();

        return this;
    }

    public RegistrationFormPage setSubmit (){
        buttonSubmit.click();

        return this;
    }

    public RegistrationFormPage checkModalTitleResult (){
        modalTitle.shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    public RegistrationFormPage checkModalTableResult(String key, String value){
        resultsTableComponent.checkResult(key, value);

        return this;
    }
}
