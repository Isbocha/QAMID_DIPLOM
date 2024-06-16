package ru.iteco.fmhandroid.ui.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

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
import ru.iteco.fmhandroid.ui.data.page.ControlPanelEditPage;
import ru.iteco.fmhandroid.ui.data.page.ControlPanelFilterPage;
import ru.iteco.fmhandroid.ui.data.page.ControlPanelPage;
import ru.iteco.fmhandroid.ui.data.page.MenuBar;
import ru.iteco.fmhandroid.ui.data.page.NewsPage;


@DisplayName("Сценарии тестирования страницы ControlPanel")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ControlPanelTest {
    private AuthorizationPage authPage = new AuthorizationPage();
    private NewsPage newsPage = new NewsPage();
    private MenuBar menuBar = new MenuBar();
    private ControlPanelPage controlPanel = new ControlPanelPage();
    private ControlPanelFilterPage controlPanelFilterPage = new ControlPanelFilterPage();
    private ControlPanelCreatePage controlPanelCreatePage = new ControlPanelCreatePage();
    private ControlPanelEditPage controlPanelEditPage = new ControlPanelEditPage();
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            menuBar.openNewsPage();
            newsPage.clickControlPanel();
            controlPanel.waitingPageLoad();
        } catch (Exception e) {
            authPage.authUser();
            menuBar.openNewsPage();
            newsPage.clickControlPanel();
            controlPanel.waitingPageLoad();
        }
    }

    @Epic("Позитивный")
    @Description("Проверка видимость и кликабельности элементов страницы")
    @Test
    public void shouldVisibleAndClickablePageElements() {
        controlPanel.pageVisible();
        controlPanel.pageClickable();
    }

    @Epic("Позитивный")
    @Description("Разворачивание карточки новости по заданной позиции")
    @Test
    public void shouldBeViewNewsOnPosition() {
        controlPanel.scroll(2);
        controlPanel.clickView(2);
    }

    @Epic("Позитивный")
    @Description("Сортировка")
    @Test
    public void shouldBeSortingNews() {
        controlPanel.clickSort();
    }

    @Epic("Позитивный")
    @Description("Открытие страницы фильтрации")
    @Test
    public void shouldBeControlPanelFilterPageVisible() {
        controlPanel.clickFilter();
        controlPanelFilterPage.pageVisible();
        controlPanelFilterPage.clickCancel();
    }

    @Epic("Позитивный")
    @Description("Открытие страницы создания новости")
    @Test
    public void shouldBeControlPanelCreatePageVisible() {
        controlPanel.clickCreate();
        controlPanelCreatePage.pageVisible();
    }


    @Epic("Позитивный")
    @Description("Создать новость и проверить ее видимость на странице")
    @Test
    public void shouldBeVisibleNewCreateNews() {
        onView(withText("Groundhog Day")).check(doesNotExist());
        controlPanel.clickCreate();
        controlPanelCreatePage.createNews();
//        controlPanel.checkViewNews(0);
        controlPanel.textVisible("Groundhog Day");
    }

}
