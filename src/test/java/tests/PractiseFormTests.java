package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class PractiseFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1280x1024";
    }

    @Test
    void successTest() {
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
        String state = "Rajasthan";
        String city = "Jaipur";

        open("/automation-practice-form");

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
        $(byText(dayOfBirth)).click();

        $("#subjectsInput").sendKeys(subject);
        $("#subjectsInput").pressEnter();

        $("#hobbiesWrapper").$(byText(hobby)).click();

        $("#uploadPicture").uploadFromClasspath(fileName);

        $("#currentAddress").setValue(currentAddress);

        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();

        $("#submit").click();

        $(".modal-content").shouldHave(text("Thanks for submitting the form"),
                text(firstName+" "+lastName),text(userEmail),text(gender),
                text(userNumber),text(dayOfBirth+" "+monthOfBirth+","+yearOfBirth),text(subject),
                text(hobby),text(fileName),text(currentAddress),text(state+" "+city));

    }
}
