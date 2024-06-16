package ru.iteco.fmhandroid.ui.data.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class Helper {

    public static Faker faker = new Faker(new Locale("en"));

    public static String getValidLogin() {
        return ("login2");
    }

    public static String getValidPassword() {
        return ("password2");
    }

    public static String getValidLoginWithSpase() {
        return (" login2");
    }

    public static String getValidPasswordWithSpase() {
        return (" password2");
    }


    public static String generateInvalidLogin(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().username();
    }

    public static String generateInvalidPassword(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.internet().password();
    }

    public static String generateValidString(int stringLength) {
        return faker.regexify("[0-9a-zA-Z]{" + stringLength + "}");
    }
    public static String generateValidLoginPassvord(int stringLength) {
        return faker.regexify("[a-zA-Z]{" + stringLength + "}");
    }
    public static String generateValidText(int textLength) {
        return faker.regexify("[0-9 a-zA-Z]{" + textLength + "}");
    }

    public static String generateInvalidString(int stringLength) {
        return faker.regexify("[@!#$%^&*()_+=-}{]{" + stringLength + "}");
    }

    public static String generateNumber(int stringLength) {
        return faker.regexify("[0-9]{" + stringLength + "}");
    }

    public static String generateCategory() {
        String[] category = new String[]{
                "Объявление",
                "День рождения",
                "Зарплата",
                "Профсоюз",
                "Праздник",
                "Массаж",
                "Благодарность",
                "Нужна помощь"};
        return category[new Random().nextInt(category.length)];
    }

    public static String getCategory(int index) {
        String[] category = new String[]{
                "Объявление",
                "День рождения",
                "Зарплата",
                "Профсоюз",
                "Праздник",
                "Массаж",
                "Благодарность",
                "Нужна помощь"};
        return category[index - 1];
    }

    public static String setData(String data) {
        return data;
    }

    public static String generateDate(int shift) {
        String pattern = "dd.MM.yyyy";
        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern(pattern));
        return date;
    }

    public static String getСurrentDate() {
        String pattern = "dd.MM.yyyy";
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern(pattern));
        return date;
    }

    public static String getСurrentTime(int shift) {
        String pattern = "HH:mm";
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern(pattern));
        return time;
    }

    public static String generateTimeShiftMinute(int shift) {
        String pattern = "HH:mm";
        String time = LocalTime.now().plusMinutes(shift).format(DateTimeFormatter.ofPattern(pattern));
        return time;
    }

    public static String addTime(int hours, int minutes) {
        return hours + ":" + minutes;
    }

    public static String getSQLInjection(int index) {
        String[] category = new String[]{
                "' or '1' = '1",
                "'",
                "\"",
                "10 and 1=1",
                "10 and 1=2",
                "1 UNION ALL SELECT * FROM productCardTable",
                "10 ORDER BY 10--",
                "(select*from(select(sleep(20)))a)"};
        return category[index - 1];
    }
}




