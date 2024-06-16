package ru.iteco.fmhandroid.ui.test;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.page.AboutPage;
import ru.iteco.fmhandroid.ui.data.page.AuthorizationPage;
import ru.iteco.fmhandroid.ui.data.page.MenuBar;
import ru.iteco.fmhandroid.ui.data.page.NewsPage;
import ru.iteco.fmhandroid.ui.data.page.OurMissionPage;

@DisplayName("Сценарии тестирования панели управления")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class MenuBarTest {
    AuthorizationPage authPage = new AuthorizationPage();
    MenuBar menuBar = new MenuBar();
    AboutPage aboutPage = new AboutPage();
    NewsPage newsPage = new NewsPage();
    OurMissionPage ourMissionPage = new OurMissionPage();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            menuBar.waitingPageLoad();
        } catch (Exception e) {
            authPage.authUser();
            menuBar.waitingPageLoad();
        }
    }

    @Epic("Позитивный")
    @Description("Проверка видимости и кликабельности элементов страницы")
    @Test
    public void shouldVisibleAndClickablePageElements() {
        menuBar.pageVisible();
        menuBar.pageClickable();
    }

    @Epic("Позитивный")
    @Description("Открытие меню и проверка видимости меню")
    @Test
    public void shouldBeMainMenuVisible() {
        menuBar.openMenu();
        menuBar.mainMenuVisible();
    }


    @Epic("Позитивный")
    @Description("Переход на страницу News")
    @Test
    public void shouldBeNewsPageVisible() {
        menuBar.openNewsPage();
        newsPage.pageVisible();
    }


    @Epic("Позитивный")
    @Description("Переход на страницу AboutPage")
    @Test
    public void shouldBeAboutPageVisible() {
        menuBar.openAboutPage();
        aboutPage.pageVisible();
    }


    @Epic("Позитивный")
    @Description("Переход на страницу OurMission")
    @Test
    public void shouldBeOurMissionVisible() {
        menuBar.openOurMission();
        ourMissionPage.pageVisible();
    }

    @Epic("Позитивный")
    @Description("Открытие меню профиля и проверка видимости элементов")
    @Test
    public void shouldBeProfileMenuVisible() {
        menuBar.openProfileMenu();
        menuBar.profileMenuVisible();
    }

}
