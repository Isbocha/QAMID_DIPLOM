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
import ru.iteco.fmhandroid.ui.data.page.MenuBar;
import ru.iteco.fmhandroid.ui.data.page.OurMissionPage;

@DisplayName("Сценарии тестирования страницы OurMissionPage")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class OurMissionPageTest {
    private AuthorizationPage authPage = new AuthorizationPage();
    private MenuBar menuBar = new MenuBar();
    private OurMissionPage ourMissionPage = new OurMissionPage();
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            menuBar.openOurMission();
            ourMissionPage.waitingPageLoad();
        } catch (Exception e) {
            authPage.authUser();
            menuBar.openOurMission();
            ourMissionPage.waitingPageLoad();
        }
    }

    @Epic("Позитивный")
    @Description("проверка видимости  элементов страницы")
    @Test
    public void shouldVisiblePageElements() {
        ourMissionPage.pageVisible();
    }

    @Epic("Позитивный")
    @Description("Разворацивание карточки цитаты по заданной позиции и проверка видимости текста")
    @Test
    public void shouldBeTextVisibleOnPosition2() {
        ourMissionPage.clickView(2);
        ourMissionPage.textCardVisible("Все сотрудники хосписа - это адвокаты пациента, его прав и потребностей. Поиск путей решения различных задач - это и есть хосписный индивидуальный подход к паллиативной помощи.");
    }

    @Epic("Позитивный")
    @Description("Разворацивание карточки цитаты по заданной позиции и проверка видимости текста")
    @Test
    public void shouldBeTextVisibleOnPosition0() {
        ourMissionPage.clickView(0);
        ourMissionPage.textCardVisible("\"Ну, идеальное устройство мира в моих глазах. Где никто не оценивает, никто не осудит, где говоришь, и тебя слышат, где, если страшно, тебя обнимут и возьмут за руку, а если холодно тебя согреют.” Юля Капис, волонтер");
    }

}
