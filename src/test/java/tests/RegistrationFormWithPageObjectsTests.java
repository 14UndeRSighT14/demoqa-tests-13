package tests;

import org.junit.jupiter.api.Test;

public class RegistrationFormWithPageObjectsTests extends TestBase {

    TestData testData = new TestData();
    @Test
    void successTest() {

        registrationFormPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.gender)
                .setNumber(testData.userNumber)
                .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .setSubject(testData.subject)
                .setHobbie(testData.hobby)
                .uploadFile(testData.fileName)
                .setAddress(testData.currentAddress)
                .setStateCity(testData.state, testData.city)
                .setSubmit();

        registrationFormPage.checkModalTitleResult().checkModalTableResult("Student Name", testData.firstName + " " + testData.lastName).
                checkModalTableResult("Student Email", testData.userEmail).
                checkModalTableResult("Gender", testData.gender).
                checkModalTableResult("Mobile", testData.userNumber).
                checkModalTableResult("Date of Birth", testData.dayOfBirth + " " +testData.monthOfBirth + "," + testData.yearOfBirth).
                checkModalTableResult("Subjects", testData.subject).
                checkModalTableResult("Hobbies", testData.hobby).
                checkModalTableResult("Picture", testData.fileName).
                checkModalTableResult("Address", testData.currentAddress).
                checkModalTableResult("State and City", testData.state + " " + testData.city);
    }
}
