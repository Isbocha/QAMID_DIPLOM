package ru.iteco.fmhandroid.ui.test;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.data.Helper;
import ru.iteco.fmhandroid.ui.data.page.AuthorizationPage;
import ru.iteco.fmhandroid.ui.data.page.MainPage;
import ru.iteco.fmhandroid.ui.data.page.MenuBar;

@DisplayName("Сценарии тестирования страницы авторизации")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationPageTest {
    private AuthorizationPage authPage = new AuthorizationPage();
    private MenuBar menuBar = new MenuBar();
    private MainPage mainPage = new MainPage();
    private View decorView;

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            authPage.waitingPageLoad();
        } catch (Exception e) {
            menuBar.exitProfile();
            authPage.waitingPageLoad();
        }
    }

    @After
    public void after1() {
        try {
            menuBar.exitProfile();
        } catch (Exception e) {
        }
    }

    @Epic("Позитивный")
    @Description("Проверка видимости и кликабельности элементов страницы")
    @Test
    public void shouldVisibleAndClickablePageElements() {
        authPage.pageVisible();
        authPage.pageClickable();
    }

    @Epic("Позитивный")
    @Description("Авторизация с валидным логином и валидным паролем (успешная аутентификация)")
    @Test
    public void shouldAuthUserAndMainPageVisible() {
        authPage.addLogin(Helper.getValidLogin());
        authPage.addPassword(Helper.getValidPassword());
        authPage.clickButton();
        mainPage.pageVisible();
        menuBar.pageVisible();
    }


    @Epic("Негативный")
    @Description("Авторизация с валидным но неверным логином и валидным паролем")
    @Test
    public void shouldErrorMessageVisible() {
        authPage.addLogin(Helper.generateInvalidLogin("en"));
        authPage.addPassword(Helper.getValidPassword());
        authPage.clickButton();
        authPage.errorMessageText("Something went wrong. Try again later.", decorView);
    }


    @Epic("Негативный")
    @Description("Авторизация с валидным логином и валидным но неверным паролем ")
    @Test
    public void shouldErrorMessageVisible2() {
        authPage.addLogin(Helper.getValidLogin());
        authPage.addPassword(Helper.generateInvalidPassword("en"));
        authPage.clickButton();
        authPage.errorMessageText("Something went wrong. Try again later.", decorView);
    }


    @Epic("Негативный")
    @Description("Авторизация с пустыми полями логина и пароля")
    @Test
    public void shouldErrorMessageVisible3() {
        authPage.clickButton();
        authPage.errorMessageText("Login and password cannot be empty", decorView);
    }

    @Epic("Негативный")
    @Description("Авторизация с пустыми полями логина и пароля (ввод и удаление данных)")
    @Test
    public void shouldErrorMessageVisible4() {
        authPage.addLogin(Helper.getValidLogin());
        authPage.addPassword(Helper.getValidPassword());
        authPage.deleteLogin();
        authPage.deletePassword();
        authPage.clickButton();
        authPage.errorMessageText("Login and password cannot be empty", decorView);
    }

    @Epic("Негативный")
    @Description("Авторизация с пустым полем логина и валидным паролем")
    @Test
    public void shouldErrorMessageVisible5() {
        authPage.addPassword(Helper.getValidPassword());
        authPage.clickButton();
        authPage.errorMessageText("Login and password cannot be empty", decorView);
    }


    @Epic("Негативный")
    @Description("Авторизация с пустым полем пароля и валидным логином")
    @Test
    public void shouldErrorMessageVisible6() {
        authPage.addLogin(Helper.getValidLogin());
        authPage.clickButton();
        authPage.errorMessageText("Login and password cannot be empty", decorView);
    }


    @Epic("Негативный")
    @Description("Авторизация с пробелом в начале валидного логина и валидным паролем")
    @Test
    public void shouldErrorMessageVisible7() {
        authPage.addLogin(Helper.getValidLoginWithSpase());
        authPage.addPassword(Helper.getValidPassword());
        authPage.clickButton();
        authPage.errorMessageText("Something went wrong. Try again later.", decorView);
    }

    @Epic("Негативный")
    @Description("Авторизация с невалидным логином и паролем (на кириллице) ")
    @Test
    public void shouldErrorMessageVisible8() {
        authPage.addLogin(Helper.generateInvalidLogin("ru"));
        authPage.addPassword(Helper.generateInvalidPassword("ru"));
        authPage.clickButton();
        authPage.errorMessageText("Login and password cannot be empty", decorView);
    }

    @Epic("Негативный")
    @Description("Авторизация с невалидным логином и паролем (спецсимволы) ")
    @Test
    public void shouldErrorMessageVisible9() {
        authPage.addLogin(Helper.generateInvalidString(7));
        authPage.addPassword(Helper.generateInvalidString(7));
        authPage.clickButton();
        authPage.errorMessageText("Login and password cannot be empty", decorView);
    }

    @Epic("Негативный")
    @Description("Авторизация с валидным логином и паролем длиною 21 символов ")
    @Test
    public void shouldErrorMessageVisible10() {
        authPage.addLogin(Helper.generateValidLoginPassvord(21));
        authPage.addPassword(Helper.generateValidLoginPassvord(21));
        authPage.clickButton();
        authPage.errorMessageText("Something went wrong. Try again later.", decorView);
    }

    @Epic("Негативный")
    @Description("Применение  SQL- инъекции ( 1 вариант)")
    @Test
    public void shouldErrorMessageVisible11() {
        authPage.addLogin(Helper.getSQLInjection(1));
        authPage.addPassword(Helper.getSQLInjection(1));
        authPage.clickButton();
        authPage.errorMessageText("Something went wrong. Try again later.", decorView);
    }

}

