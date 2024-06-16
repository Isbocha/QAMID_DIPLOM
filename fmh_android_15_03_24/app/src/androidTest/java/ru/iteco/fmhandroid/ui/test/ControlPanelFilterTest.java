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
import ru.iteco.fmhandroid.ui.data.page.ControlPanelFilterPage;
import ru.iteco.fmhandroid.ui.data.page.ControlPanelPage;
import ru.iteco.fmhandroid.ui.data.page.MenuBar;
import ru.iteco.fmhandroid.ui.data.page.NewsPage;


@DisplayName("Сценарии тестирования страницы ControlPanelFilter")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ControlPanelFilterTest {
    private AuthorizationPage authPage = new AuthorizationPage();
    private NewsPage newsPage = new NewsPage();
    private MenuBar menuBar = new MenuBar();
    private ControlPanelPage controlPanel = new ControlPanelPage();
    private ControlPanelFilterPage controlPanelFilterPage = new ControlPanelFilterPage();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            menuBar.waitingPageLoad();
            menuBar.openNewsPage();
            newsPage.clickControlPanel();
            controlPanel.clickFilter();
            controlPanelFilterPage.waitingPageLoad();
        } catch (Exception e) {
            authPage.authUser();
            menuBar.openNewsPage();
            newsPage.clickControlPanel();
            controlPanel.clickFilter();
            controlPanelFilterPage.waitingPageLoad();
        }
    }

    @Epic("Позитивный")
    @Description("Проверка видимости и кликабельности элементов страницы")
    @Test
    public void shouldVisibleAndClickablePageElements() {
        controlPanelFilterPage.pageVisible();
        controlPanelFilterPage.pageClicable();
    }

    @Epic("Негативный")
    @Description("Проверка видимости текста ошибки при фильтрации только по дате начала и закрытие модального окна")
    @Test
    public void shouldBeErrorTextWhenFilteringOnlyByStartDate() {
        controlPanelFilterPage.addStartDate(Helper.getСurrentDate());
        controlPanelFilterPage.clickFilter();
        controlPanelFilterPage.errorVisible();
        controlPanelFilterPage.clickErrorMessageOkButton();
        controlPanelFilterPage.pageVisible();
        controlPanelFilterPage.clickCancel();
    }

    @Epic("Позитивный")
    @Description("Фильтрация с установлением категории и и будущих дат и обновление страницы ")
    @Test
    public void ShouldBeRefreshButtonVisible() {
        controlPanelFilterPage.addCategory(Helper.getCategory(7));
        controlPanelFilterPage.addStartDate(Helper.generateDate(70));
        controlPanelFilterPage.addEndDate(Helper.generateDate(79));
        controlPanelFilterPage.clickFilter();
        controlPanelFilterPage.clickRefreshVisible();
    }

    @Epic("Позитивный")
    @Description("Фильтрация с использованием чек-бокса Active")
    @Test
    public void shouldBeFilteringWithCheckBoxActive() {
        controlPanelFilterPage.addCategory(Helper.getCategory(5));
        controlPanelFilterPage.addStartDate(Helper.generateDate(-770));
        controlPanelFilterPage.addEndDate(Helper.generateDate(2));
        controlPanelFilterPage.clickActiveCheckBox();
        controlPanelFilterPage.clickFilter();

    }

    @Epic("Позитивный")
    @Description("Отмена применения фильтрации")
    @Test
    public void shoutBeFilterClosureAndControlPanelPageVisible() {
        controlPanelFilterPage.addCategory(Helper.getCategory(5));
        controlPanelFilterPage.addStartDate(Helper.generateDate(-770));
        controlPanelFilterPage.addEndDate(Helper.generateDate(2));
        controlPanelFilterPage.clickCancel();
        controlPanel.pageVisible();
    }
}
