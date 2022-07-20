package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.*;

public class RegistrationFormWirhRandomUtilsTests extends TestBase {
// Перенести в TestData
    String firstName = getRandomString(10);
    String lastName = getRandomString(10);
    String userEmail = getRandomEmail();
    String gender = "Male";
    String userNumber = "9879999999";
    String monthOfBirth = "May";
    String yearOfBirth = "1989";
    String dayOfBirth = "14";
    String subject = "Maths";
    String hobby = "Sports";
    String fileName = "Screen.png";
    String currentAddress = getRandomMessage(10, 100);
    String state = "Rajasthan";
    String city = "Jaipur";

    @Test
    void successTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");


        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);

        $("#userEmail").setValue(userEmail);

        $("#genterWrapper").$(byText(gender)).click();

        $("#userNumber").setValue(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day--0" + dayOfBirth + ":not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").sendKeys(subject);
        $("#subjectsInput").pressEnter();

        $("#hobbiesWrapper").$(byText(hobby)).click();

        $("#uploadPicture").uploadFromClasspath("img/" + fileName);

        $("#currentAddress").setValue(currentAddress);

        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        checkTable("Student Name", firstName + " " + lastName);
        checkTable("Student Email", userEmail);
        checkTable("Gender", gender);
        checkTable("Mobile", userNumber);
        checkTable("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth);
        checkTable("Subjects", subject);
        checkTable("Hobbies", hobby);
        checkTable("Picture", fileName);
        checkTable("Address", currentAddress);
        checkTable("State and City", state + " " + city);
    }

    void checkTable(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
    }
}
