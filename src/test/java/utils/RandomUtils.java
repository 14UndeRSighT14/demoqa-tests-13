package utils;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.github.javafaker.Faker;

public class RandomUtils {

    private static String emailDomain = "@qa.guru";
    private static Faker faker = new Faker();

    public static String getRandomString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }

        return result.toString();
    }

    public static String getRandomMessage(int min, int max) {
        String[] words = {"and", "or", "but", "because",
                "red", "white", "Jane", "John", "Bobby",
                "man", "woman", "fish", "elephant", "unicorn",
                "a", "the", "every", "some", "any", "all",
                "big", "tiny", "pretty", "bald", "small",
                "runs", "jumps", "talks", "sleeps", "walks",
                "loves", "hates", "sees", "knows", "looks for", "finds",
                ", ", ", ", ", ", ". ", ". "};

        StringBuilder message = new StringBuilder();
        int messageLength = getRandomInt(min, max);
        while (message.length() < messageLength) {
            int wordIndex = getRandomInt(0, words.length - 1);
            message.append(words[wordIndex] + " ");
        }

        String readyMessage = StringUtils.capitalize(message.toString())
                .replace("  ", " ")
                .replace(" ,", ",")
                .replace(" .", ".").trim();

        return readyMessage;
    }

    public static int getRandomInt(int min, int max) {
        Random r = new Random();

        return r.nextInt((max - min) + 1) + min;
    }

    public static String getRandomPhone() {
        return getRandomLong(11111111111111111L, 99999999999999999L) + "";
    }

    public static Long getRandomLong(Long min, Long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }

    public static String getRandomEmail() {
        long timestamp = new Timestamp(System.currentTimeMillis()).getTime();
        return getRandomString(5) + timestamp + emailDomain;
    }

    public static String getDateOfBirth(){
        String pattern = "dd MMMMM yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, new Locale("EN"));

        return sdf.format(faker.date().birthday());
    }

    public static String getMonthOfBirth(){

        return getDateOfBirth().split(" ")[1];
    }

    public static String getDayOfBirth(){

        return getDateOfBirth().split(" ")[0];
    }

    public static String getYearOfBirth(){

        return getDateOfBirth().split(" ")[2];
    }

    public static String getGender(){
        String[] genders = {"Male", "Female", "Other"};
        int randomInt = getRandomInt(1,3);

        return genders[randomInt-1];
    }

    public static String getSubject(){
        String[] subjects = {"Maths", "Chemistry", "Computer Science", "Commerce",
                "Physics", "Accounting", "Social Studies", "Economics", "Civics",
                "Arts", "Biology","English", "History", "Hindi"};
        int randomInt = getRandomInt(1,14);

        return subjects[randomInt-1];
    }

    public static String getHobby(){
        String[] hobbies = {"Sports", "Reading", "Music"};
        int randomInt = getRandomInt(1,3);

        return hobbies[randomInt-1];
    }

    public static String getState(){
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        int randomInt = getRandomInt(1,4);

        return states[randomInt-1];
    }


    public static String getCity(String state) {
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