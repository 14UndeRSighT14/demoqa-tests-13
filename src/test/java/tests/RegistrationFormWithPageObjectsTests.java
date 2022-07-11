package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormWithPageObjectsTests extends TestBase {

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

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject)
                .setHobbie(hobby)
                .uploadFile(fileName)
                .setAddress(currentAddress)
                .setStateCity(state, city)
                .setSubmit();

        registrationFormPage.checkModalTitleResult().checkModalTableResult("Student Name", firstName + " " + lastName).
                checkModalTableResult("Student Email", userEmail).
                checkModalTableResult("Gender", gender).
                checkModalTableResult("Mobile", userNumber).
                checkModalTableResult("Date of Birth", dayOfBirth + " " +monthOfBirth + "," + yearOfBirth).
                checkModalTableResult("Subjects", subject).
                checkModalTableResult("Hobbies", hobby).
                checkModalTableResult("Picture", fileName).
                checkModalTableResult("Address", currentAddress).
                checkModalTableResult("State and City", state + " " + city);
    }
}
