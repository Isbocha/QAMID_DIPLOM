package ru.iteco.fmhandroid.ui.test;

import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;

import android.content.Intent;

import androidx.test.espresso.intent.Intents;
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
import ru.iteco.fmhandroid.ui.data.page.OurMissionPage;

@DisplayName("Сценарии тестирования страницы AboutPage")
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AboutPageTest {
    private AuthorizationPage authPage = new AuthorizationPage();
    private MenuBar menuBar = new MenuBar();
    private AboutPage aboutPage = new AboutPage();
    private OurMissionPage ourMissionPage = new OurMissionPage();
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        try {
            menuBar.openAboutPage();
//            aboutPage.waitingPageLoad();
        } catch (Exception e) {
            authPage.authUser();
//            authPage.waitingPageLoad();
            menuBar.openAboutPage();
            aboutPage.waitingPageLoad();
        }
    }

    @Epic("Позитивный")
    @Description("Проверка видимости и кликабельности элементов страницы")
    @Test
    public void shouldVisibleAndClickablePageElements() {
        aboutPage.pageVisible();
        aboutPage.pageClickable();
    }

    @Epic("Позитивный")
    @Description("Открытие ссылки Privacy Policy")
    @Test
    public void shouldOpeningPrivacyPolicyLink() {
        Intents.init();
        aboutPage.clickPrivacyPolicyLinc();
        intended(hasData("https://vhospice.org/#/privacy-policy"));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();
    }

    @Epic("Позитивный")
    @Description("Открытие ссылки Terms of use")
    @Test
    public void shouldOpeningTermsOfUseLink() {
        Intents.init();
        aboutPage.clickTermsOfUseLinc();
        intended(hasData("https://vhospice.org/#/terms-of-use"));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();
    }

    @Epic("Позитивный")
    @Description("Возврат на предыдущую страницу и проверка видимости предыдущей страницы")
    @Test
    public void shouldReturnAndVisiblePageElements() {
        aboutPage.clickBackButton();
        menuBar.openOurMission();
        menuBar.openAboutPage();
        aboutPage.pageVisible();
        aboutPage.clickBackButton();
        ourMissionPage.pageVisible();
    }
}


