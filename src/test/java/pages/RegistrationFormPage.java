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

    SelenideElement firstNameInput = $("#firstName");

    public RegistrationFormPage openPage (){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName (String value){
        $("#firstName").setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName (String value){
        $("#lastName").setValue(value);

        return this;
    }

    public RegistrationFormPage setGender (String value){
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setEmail (String value){
        $("#userEmail").setValue(value);

        return this;
    }

    public RegistrationFormPage setNumber (String value){
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationFormPage setDateOfBirth (String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setSubject (String value){
        $("#subjectsInput").sendKeys(value);
        $("#subjectsInput").pressEnter();

        return this;
    }

    public RegistrationFormPage setHobbie (String value){
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage uploadFile (String value){
        uploadFileComponent.uploadFile(value);

        return this;
    }

    public RegistrationFormPage setAddress (String value){
        $("#currentAddress").setValue(value);

        return this;
    }

    public RegistrationFormPage setStateCity (String state, String city){
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        return this;
    }

    public RegistrationFormPage setSubmit (){
        $("#submit").click();

        return this;
    }

    public RegistrationFormPage checkModalTitleResult (){
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    public RegistrationFormPage checkModalTableResult(String key, String value){
        resultsTableComponent.checkResult(key, value);

        return this;
    }
}
