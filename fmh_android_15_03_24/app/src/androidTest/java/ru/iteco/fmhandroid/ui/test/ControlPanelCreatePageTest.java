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
import ru.iteco.fmhandroid.ui.data.page.ControlPanelCreatePage;
import ru.iteco.fmhandroid.ui.data.page.ControlPanelPage;
import ru.iteco.fmhandroid.ui.data.page.MenuBar;
import ru.iteco.fmhandroid.ui.data.page.NewsPage;


@DisplayName("Сценарии тестирования страницы ControlPanelCreatePageTest")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ControlPanelCreatePageTest {
    private AuthorizationPage authPage = new AuthorizationPage();
    private NewsPage newsPage = new NewsPage();
    private MenuBar menuBar = new MenuBar();
    private ControlPanelPage controlPanel = new ControlPanelPage();
    private ControlPanelCreatePage controlPanelCreatePage = new ControlPanelCreatePage();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            menuBar.openNewsPage();
            newsPage.clickControlPanel();
            controlPanel.clickCreate();
            controlPanelCreatePage.waitingPageLoad();
        } catch (Exception e) {
            authPage.authUser();
            menuBar.openNewsPage();
            newsPage.clickControlPanel();
            controlPanel.clickCreate();
            controlPanelCreatePage.waitingPageLoad();
        }
    }

    @Epic("Позитивный")
    @Description("Проверка видимости и кликабельности элементов страницы")
    @Test
    public void shouldVisiblePageElements() {
        controlPanelCreatePage.pageVisible();
        controlPanelCreatePage.pageClickable();
    }


    @Epic("Позитивный")
    @Description("Создание новости и проверка видимости созданной новости")
    @Test
    public void shouldBeCreateAndVisibleNews() {
        controlPanelCreatePage.createNews2();
        controlPanel.waitingPageLoad();
//        controlPanel.clickSort();
        controlPanel.titleNewsVisible("Найден котенок");
    }

}
