package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;

public class RegistrationFormWithTestDataTests extends TestBase {
    @Test
    void successTest() {


        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");


        $("#firstName").setValue(FIRST_NAME);
        $("#lastName").setValue(LAST_NAME);

        $("#userEmail").setValue(USER_EMAIL);

        $("#genterWrapper").$(byText(GENDER)).click();

        $("#userNumber").setValue(USER_NUMBER);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(MONTH_OF_BIRTH);
        $(".react-datepicker__year-select").selectOption(YEAR_OF_BIRTH);
        $(".react-datepicker__day--0" + DAY_OF_BIRTH + ":not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").sendKeys(SUBJECT);
        $("#subjectsInput").pressEnter();

        $("#hobbiesWrapper").$(byText(HOBBY)).click();

        $("#uploadPicture").uploadFromClasspath("img/" + FILE_NAME);

        $("#currentAddress").setValue(CURRENT_ADDRESS);

        $("#state").click();
        $("#stateCity-wrapper").$(byText(STATE)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(CITY)).click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        checkTable("Student Name", FIRST_NAME + " " + LAST_NAME);
        checkTable("Student Email", USER_EMAIL);
        checkTable("Gender", GENDER);
        checkTable("Mobile", USER_NUMBER);
        checkTable("Date of Birth", DAY_OF_BIRTH + " " + MONTH_OF_BIRTH + "," + YEAR_OF_BIRTH);
        checkTable("Subjects", SUBJECT);
        checkTable("Hobbies", HOBBY);
        checkTable("Picture", FILE_NAME);
        checkTable("Address", CURRENT_ADDRESS);
        checkTable("State and City", STATE + " " + CITY);
    }

    void checkTable(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
    }
}
