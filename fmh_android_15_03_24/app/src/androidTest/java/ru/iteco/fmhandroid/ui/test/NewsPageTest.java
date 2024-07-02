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
import ru.iteco.fmhandroid.ui.data.page.ControlPanelPage;
import ru.iteco.fmhandroid.ui.data.page.MenuBar;
import ru.iteco.fmhandroid.ui.data.page.NewsFilterPage;
import ru.iteco.fmhandroid.ui.data.page.NewsPage;

@DisplayName("Сценарии тестирования страницы News")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsPageTest {
    AuthorizationPage authPage = new AuthorizationPage();
    NewsPage newsPage = new NewsPage();
    MenuBar menuBar = new MenuBar();
    NewsFilterPage filterPage = new NewsFilterPage();
    ControlPanelPage controlPanel = new ControlPanelPage();
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            menuBar.openNewsPage();
            newsPage.waitingPageLoad();
        } catch (Exception e) {
            authPage.authUser();
            menuBar.openNewsPage();
            newsPage.waitingPageLoad();
        }
    }

    @Epic("Позитивный")
    @Description("Видимость элементов страницы")
    @Test
    public void shouldVisiblePageElements() {
        newsPage.pageVisible();
    }


    @Epic("Позитивный")
    @Description("Сортировка новостей")
    @Test
    public void shouldBeSortedElements() {
        newsPage.clickSort();
    }

    @Test
    @Epic("Позитивный")
    @Description("Открытие фильтра и проверка видимости элементов")
    public void shouldVisibleFilterPageElements() {
        newsPage.clickFilter();
        filterPage.pageVisible();
    }

    @Test
    @Epic("Позитивный")
    @Description("Открытие страницы ControlPanel и проверка видимости элементов")
    public void pageVisibleControlPanel() {
        newsPage.clickControlPanel();
        controlPanel.pageVisible();
    }

    @Test
    @Epic("Позитивный")
    @Description("Разворачивание первой 1 и 7 новости")
    public void shouldViewFirstNews() {
        newsPage.clickView(0);
        newsPage.clickView(6);
    }

}
