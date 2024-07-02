package ru.iteco.fmhandroid.ui.data.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.data.Utility;

public class MenuBar {
    private final ViewInteraction mainMenu = onView(withId(R.id.main_menu_image_button));
    //    private final ViewInteraction mainButton = onView(withId(R.id.menu_item_main));
//    private final ViewInteraction newsButton = onView(withId(R.id.menu_item_news));
//    private final ViewInteraction aboutButton = onView(withId(R.id.main_menu_image_button));
    private final ViewInteraction mainButton = onView(withText("Main"));
    private final ViewInteraction newsButton = onView(withText("News"));
    private final ViewInteraction aboutButton = onView(withText("About"));
    private final ViewInteraction image = onView(withId(R.id.trademark_image_view));
    private final ViewInteraction ourMissionButton = onView(withId(R.id.our_mission_image_button));
    private final ViewInteraction profileButton = onView(withId(R.id.authorization_image_button));
    //    private final ViewInteraction profileButton = onView(withId(R.id.container_custom_app_bar_include_on_fragment_main));
//    private final ViewInteraction logOut = onView(withId(android.R.id.content));
    private final ViewInteraction logOut = onView(withText("Log out"));

    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.main_menu_image_button, 5000));
    }

    public void pageVisible() {
        Allure.step("Проверка видимости элементов на странице");
        mainMenu.check(matches(isDisplayed()));
        image.check(matches(isDisplayed()));
        ourMissionButton.check(matches(isDisplayed()));
        profileButton.check(matches(isDisplayed()));
    }

    public void pageClickable() {
        Allure.step("Проверка кликабельности элементов на странице");
        mainMenu.check(matches(isClickable()));
        ourMissionButton.check(matches(isDisplayed()));
        profileButton.check(matches(isClickable()));
    }

    public void openMenu() {
        Allure.step("Открытие главного меню");
        mainMenu.perform(click());
    }

    public void mainMenuVisible() {
        Allure.step("Проверка видимости главного меню");
        mainButton.check(matches(isDisplayed()));
        newsButton.check(matches(isDisplayed()));
        aboutButton.check(matches(isDisplayed()));
    }

    public MainPage openMainPage() {
        Allure.step("Открытие страницы Main");
        mainMenu.perform(click());
        mainButton.perform(click());
        return new MainPage();
    }

    public NewsPage openNewsPage() {
        Allure.step("Открытие страницы News");
        waitingPageLoad();
        mainMenu.perform(click());
        newsButton.perform(click());
        return new NewsPage();
    }

    public AboutPage openAboutPage() {
        Allure.step("Отркытие страницы About");
        waitingPageLoad();
        mainMenu.perform(click());
        aboutButton.perform(click());
        return new AboutPage();
    }

    public OurMissionPage openOurMission() {
        Allure.step("Открытие страницы Our Mission");
        waitingPageLoad();
        ourMissionButton.perform(click());
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.our_mission_title_text_view, 7000));
        return new OurMissionPage();
    }

    public void openProfileMenu() {
        Allure.step("Открытие меню профиля");
        profileButton.perform(click());

    }

    public void profileMenuVisible() {
        Allure.step("Проверка видимости меню профиля");
        logOut.check(matches(isDisplayed()));
        logOut.check(matches(ViewMatchers.withText("Log out")));
    }

    public AuthorizationPage exitProfile() {
        Allure.step("Выход из профиля");
        waitingPageLoad();
        profileButton.perform(click());
        Utility.waitDisplayed(android.R.id.content, 7000);
        logOut.perform(click());
        return new AuthorizationPage();
    }
}
