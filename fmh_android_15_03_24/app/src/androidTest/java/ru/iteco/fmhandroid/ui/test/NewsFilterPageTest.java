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
import ru.iteco.fmhandroid.ui.data.data.Helper;
import ru.iteco.fmhandroid.ui.data.page.AuthorizationPage;
import ru.iteco.fmhandroid.ui.data.page.MenuBar;
import ru.iteco.fmhandroid.ui.data.page.NewsFilterPage;
import ru.iteco.fmhandroid.ui.data.page.NewsPage;


@DisplayName("Сценарии тестирования страницы NewsFilterPage")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsFilterPageTest {
    AuthorizationPage authPage = new AuthorizationPage();
    NewsPage newsPage = new NewsPage();
    MenuBar menuBar = new MenuBar();
    NewsFilterPage newsFilterPage = new NewsFilterPage();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            menuBar.openNewsPage();
            newsPage.clickFilter();
            newsFilterPage.waitingPageLoad();
        } catch (Exception e) {
            authPage.authUser();
            menuBar.openNewsPage();
            newsPage.clickFilter();
            newsFilterPage.waitingPageLoad();
        }
    }


    @Epic("Позитивный")
    @Description("Выбор первой категории из списка, заполнение даты начала, даты окончания и нажатие на кнопку фильтрации")
    @Test
    public void shouldBeFilterNewsVisible() {
        newsFilterPage.addCategory(Helper.getCategory(1));
        newsFilterPage.addStartDate(Helper.generateDate(-15));
        newsFilterPage.addEndDate(Helper.getСurrentDate());
        newsFilterPage.clickFilter();
    }


    @Epic("Позитивный")
    @Description("Выбор третей категории из списка, заполнение даты начала, даты окончания и нажатие на кнопку фильтрации")
    @Test
    public void shouldBeFilterNewsVisible2() {
        newsFilterPage.addCategory(Helper.getCategory(3));
        newsFilterPage.addStartDate(Helper.generateDate(-2));
        newsFilterPage.addEndDate(Helper.getСurrentDate());
        newsFilterPage.clickFilter();
    }


    @Epic("Негативный")
    @Description("Заполнени даты окончания и нажатие на кнопку фильтра")
    @Test
    public void shouldBeErrorMessageVisible() {
        newsFilterPage.addEndDate(Helper.getСurrentDate());
        newsFilterPage.clickFilter();
        newsFilterPage.errorVisible();
    }

    @Epic("Позитивный")
    @Description("Выбор третей категории из списка, заполнение даты начала, даты окончания и нажатие на кнопку закррытия")
    @Test
    public void shouldBeFilterWindowIsClosed() {
        newsFilterPage.addCategory(Helper.getCategory(3));
        newsFilterPage.addStartDate(Helper.generateDate(-2));
        newsFilterPage.addEndDate(Helper.getСurrentDate());
        newsFilterPage.clickCancel();
        newsPage.pageVisible();
    }
}
