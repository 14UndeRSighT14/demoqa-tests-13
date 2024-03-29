package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormWithParamsTests extends TestBase {
    @ValueSource(strings = {"Sports", "Reading", "Music"})
    @ParameterizedTest(name = "При добавление студента было выбрано хобби {0}, в результатах отображается хобби {0}")
    void successTestValueSource(String testData) {
        String firstName = "Slava";
        String lastName = "Testov";
        String userEmail = "SlavaTestov@mail.ru";
        String gender = "Male";
        String userNumber = "9879999999";
        String monthOfBirth = "May";
        String yearOfBirth = "1989";
        String dayOfBirth = "14";
        String subject = "Maths";
        String fileName = "Screen.png";
        String currentAddress = "Current address";
        String state = "Rajasthan";
        String city = "Jaipur";

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

        $("#hobbiesWrapper").$(byText(testData)).click();

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
        checkTable("Hobbies", testData);
        checkTable("Picture", fileName);
        checkTable("Address", currentAddress);
        checkTable("State and City", state + " " + city);
    }


    @CsvFileSource(resources = "/test_data/1.csv")
    @ParameterizedTest(name = "При добавление студента был выбран штат {0} и город {1}, в результатах отображается штат {0} и город {1}")
    void successTestCsvSource(String state, String city) {
        String firstName = "Slava";
        String lastName = "Testov";
        String userEmail = "SlavaTestov@mail.ru";
        String gender = "Male";
        String userNumber = "9879999999";
        String monthOfBirth = "May";
        String yearOfBirth = "1989";
        String dayOfBirth = "14";
        String subject = "Maths";
        String hobby = "Sports";
        String fileName = "Screen.png";
        String currentAddress = "Current address";

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
