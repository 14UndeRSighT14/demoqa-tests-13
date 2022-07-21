package tests;

import static utils.RandomUtils.*;

import com.github.javafaker.Faker;

public class TestData {

    public final static String FIRST_NAME = "Slava",
            LAST_NAME = "Testov",
            USER_EMAIL = "SlavaTestov@mail.ru",
            GENDER = "Male",
            USER_NUMBER = "9879999999",
            MONTH_OF_BIRTH = "May",
            YEAR_OF_BIRTH = "1989",
            DAY_OF_BIRTH = "14",
            SUBJECT = "Maths",
            HOBBY = "Sports",
            FILE_NAME = "Screen.png",
            CURRENT_ADDRESS = "Current address",
            STATE = "Rajasthan",
            CITY = "Jaipur";

    Faker faker = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String gender = getGender();
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public String dayOfBirth = getDayOfBirth();
    public String monthOfBirth = getMonthOfBirth();
    public String yearOfBirth = getYearOfBirth();

    public String subject = getSubject();
    public String hobby = getHobby();
    public String fileName = "Screen.png";
    public String currentAddress = faker.address().fullAddress();
    public String state = getState();
    public String city = getCity(state);


}
