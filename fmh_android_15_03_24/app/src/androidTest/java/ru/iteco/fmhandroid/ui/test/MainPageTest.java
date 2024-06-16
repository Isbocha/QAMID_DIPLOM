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
import ru.iteco.fmhandroid.ui.data.page.AuthorizationPage;
import ru.iteco.fmhandroid.ui.data.page.MainPage;
import ru.iteco.fmhandroid.ui.data.page.NewsPage;

@DisplayName("Сценарии тестирования MainPage")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class MainPageTest {
    AuthorizationPage authPage = new AuthorizationPage();
    MainPage mainPage = new MainPage();
    NewsPage newsPage = new NewsPage();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            mainPage.waitingPageLoad();
        } catch (Exception e) {
            authPage.waitingPageLoad();
            authPage.authUser();
            mainPage.waitingPageLoad();
        }
    }

    @Epic("Позитивный")
    @Description("Видимость и кликабельность элементов страницы")
    @Test
    public void shouldVisibleAndClickablePageElements() {
        mainPage.pageVisible();
        mainPage.pageClickable();
    }

    @Epic("Позитивный")
    @Description("Развернуть карточки всех трех новостей")
    @Test
    public void shouldBeViewAllCardNews() {
        mainPage.clickView(0);
        mainPage.clickView(1);
        mainPage.clickView(2);
    }

    @Epic("Позитивный")
    @Description("Проверка что на странице  три карточки новостей")
    @Test
    public void shouldBeCountCardNews() {
        mainPage.childCount(3);
    }

    @Epic("Позитивный")
    @Description("Переход в раздел AllNews")
    @Test
    public void shouldBeNewsPageVisible() {
        mainPage.openAllNews();
        newsPage.waitingPageLoad();
        newsPage.pageVisible();
    }

}
