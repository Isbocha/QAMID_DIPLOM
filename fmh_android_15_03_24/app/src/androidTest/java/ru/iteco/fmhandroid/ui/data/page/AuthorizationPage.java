package ru.iteco.fmhandroid.ui.data.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.data.Helper;
import ru.iteco.fmhandroid.ui.data.data.Utility;

public class AuthorizationPage {


    //    private final ViewInteraction title2 = onView(withId(R.id.nav_host_fragment));
    private final ViewInteraction title = onView(withText("Authorization"));
    private final ViewInteraction loginField = onView(withHint("Login"));
    private final ViewInteraction passwordField = onView(withHint("Password"));
    private final ViewInteraction button = onView(withId(R.id.enter_button));

    //    @Step("Ожидание загрузки страницы")
    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.enter_button, 5000));
    }

    //    @Step("Проверка видимости элементов на странице")
    public void pageVisible() {
        Allure.step("Проверка видимости элементов на странице");
        title.check(matches(isDisplayed()));
        loginField.check(matches(isDisplayed()));
        passwordField.check(matches(isDisplayed()));
        button.check(matches(isDisplayed()));
        button.check(matches(ViewMatchers.withText("SIGN IN")));
    }

    //    @Step("Проверка кликабельности элементов на странице")
    public void pageClickable() {
        Allure.step("Проверка кликабельности элементов на странице");
        loginField.check(matches(isClickable()));
        passwordField.check(matches(isClickable()));
        button.check(matches(isClickable()));
    }

    //    @Step("Ввод логина")
    public void addLogin(String login) {
        Allure.step("Ввод логина");
        loginField.perform(replaceText(login), closeSoftKeyboard());
    }

    //    @Step("Удаление логина")
    public void deleteLogin() {
        Allure.step("Удаление логина");
        loginField.perform(clearText(), closeSoftKeyboard());
    }

    //    @Step("Ввод пароля")
    public void addPassword(String password) {
        Allure.step("Ввод пароля");
        passwordField.perform(replaceText(password), closeSoftKeyboard());
    }

    //    @Step("Удаление пароля")
    public void deletePassword() {
        Allure.step("Удаление пароля");
        passwordField.perform(clearText(), closeSoftKeyboard());
    }

    //    @Step("Авторизация пользователя")
    public void authUser() {
        Allure.step("Авторизация пользователя");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.login_text_input_layout, 5000));
        addLogin(Helper.getValidLogin());
        addPassword(Helper.getValidPassword());
        clickButton();
    }

    //    @Step("Нажатие кнопки SIGN IN")
    public void clickButton() {
        Allure.step("Нажатие кнопки SIGN IN");
        button.perform(click());
    }

    //    @Step("Появление окна с текстом ошибки")
    public void errorMessageText(String text, View decorView) {
        Allure.step("Появление окна с текстом ошибки");
        onView(withText(text))
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }

}


