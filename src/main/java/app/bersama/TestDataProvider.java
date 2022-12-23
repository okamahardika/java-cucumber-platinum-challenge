package app.bersama;

import com.github.javafaker.Faker;

import java.util.Locale;

import static java.io.FileDescriptor.in;

public class TestDataProvider {
    private static final Faker faker = new Faker();

    public static String getRandomUserName() {
        return faker.name().firstName();
    }

    public static String getRandomDescription(){
        return faker.lorem().paragraph();
    }

    public static String getRandomProductName(){
        return faker.commerce().productName();
    }

    public static String getRandomPrice(){
        return getRandomStringMatchingPattern("[1-9]{2}"+"000");
    }

    public static String getRandomPasswordNumber() {
        return getRandomStringMatchingPattern("[A-Z]\\d{8}");
    }

    public static String getRandomStringMatchingPattern(String pattern) {
        return faker.regexify(pattern);
    }

    public static String getRandomEmail() {
        return getRandomStringMatchingPattern("[a-z]{5}\\d{3}") + ".binar@academy.com";
    }
}
