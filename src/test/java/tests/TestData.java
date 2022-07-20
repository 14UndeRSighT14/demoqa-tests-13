package tests;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Locale;

import static utils.RandomUtils.*;

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

    static Faker faker = new Faker();

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

    public String getDateOfBirth(){
        String pattern = "dd MMMMM yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, new Locale("EN"));

        return sdf.format(faker.date().birthday());
    }

    public String getMonthOfBirth(){

        return getDateOfBirth().split(" ")[1];
    }

    public String getDayOfBirth(){

        return getDateOfBirth().split(" ")[0];
    }

    public String getYearOfBirth(){

        return getDateOfBirth().split(" ")[2];
    }

    public String getGender(){
        String[] genders = {"Male", "Female", "Other"};
        int randomInt = getRandomInt(1,3);

        return genders[randomInt-1];
    }

    public String getSubject(){
        String[] subjects = {"Maths", "Chemistry", "Computer Science", "Commerce",
                "Physics", "Accounting", "Social Studies", "Economics", "Civics",
                "Arts", "Biology","English", "History", "Hindi"};
        int randomInt = getRandomInt(1,14);

        return subjects[randomInt-1];
    }

    public String getHobby(){
        String[] hobbies = {"Sports", "Reading", "Music"};
        int randomInt = getRandomInt(1,3);

        return hobbies[randomInt-1];
    }

    public String getState(){
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        int randomInt = getRandomInt(1,4);

        return states[randomInt-1];
    }


    public String getCity(String state) {
        String[] cities;
        String city;
        int randomInt;
        switch (state){
            case "NCR":
                cities = new String[]{"Delhi", "Gurgaon", "Noida"};
                randomInt = getRandomInt(1,3);
                city = cities[randomInt-1];
                break;
            case "Uttar Pradesh":
                cities = new String[]{"Agra", "Lucknow", "Merrut"};
                randomInt = getRandomInt(1,3);
                city = cities[randomInt-1];
                break;
            case "Haryana":
                cities = new String[]{"Karnal", "Panipat"};
                randomInt = getRandomInt(1,2);
                city = cities[randomInt-1];
                break;
            case "Rajasthan":
                cities = new String[]{"Jaipur", "Jaiselmer"};
                randomInt = getRandomInt(1,2);
                city = cities[randomInt-1];
                break;
            default:
                throw new IllegalStateException("Задано неправильное значение state: " + state);
        }

        return city;
    }
}
