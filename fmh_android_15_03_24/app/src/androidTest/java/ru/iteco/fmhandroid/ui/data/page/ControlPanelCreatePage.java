package ru.iteco.fmhandroid.ui.data.page;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.data.Helper;
import ru.iteco.fmhandroid.ui.data.data.Utility;

public class ControlPanelCreatePage {

    private final ViewInteraction creatingTitle = Espresso.onView(withId(R.id.custom_app_bar_title_text_view));
    private final ViewInteraction newsTitle = Espresso.onView(withId(R.id.custom_app_bar_sub_title_text_view));
    private final ViewInteraction categoryBox = Espresso.onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    private final ViewInteraction categoryView = Espresso.onView(withId(com.google.android.material.R.id.text_input_end_icon));
    private final ViewInteraction titleBox = Espresso.onView(withId(R.id.news_item_title_text_input_edit_text));
    private final ViewInteraction publicationDate = Espresso.onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    private final ViewInteraction time = Espresso.onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    private final ViewInteraction description = Espresso.onView(withId(R.id.news_item_description_text_input_edit_text));
    private final ViewInteraction switcher = Espresso.onView(withId(R.id.switcher));
    private final ViewInteraction saveButton = Espresso.onView(withId(R.id.save_button));
    private final ViewInteraction cancelButton = Espresso.onView(withId(R.id.cancel_button));
    private final ViewInteraction cancelButtonMessage = Espresso.onView(withId(android.R.id.message));
    private final ViewInteraction cancelCancelButton = Espresso.onView(withId(android.R.id.button2));
    private final ViewInteraction cancelOkButton = Espresso.onView(withId(android.R.id.button1));
    private final ViewInteraction alertCategory = Espresso.onView(withId(com.google.android.material.R.id.text_input_start_icon));
    private final ViewInteraction alertOther = Espresso.onView(withId(com.google.android.material.R.id.text_input_end_icon));

    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.custom_app_bar_title_text_view, 7000));
    }

    public void pageVisible() {
        Allure.step("Проверка видимости элементов на странице");
        creatingTitle.check(matches(isDisplayed()));
        creatingTitle.check(matches(withText("Creating")));
        newsTitle.check(matches(isDisplayed()));
        newsTitle.check(matches(withText("News")));
        categoryBox.check(matches(isDisplayed()));
//        categoryBox.check(matches(withText("Category")));
//        categoryView.check(matches(isDisplayed()));
        titleBox.check(matches(isDisplayed()));
//        titleBox.check(matches(withText("Title")));
        publicationDate.check(matches(isDisplayed()));
//        publicationDate.check(matches(withText("Publication date")));
        time.check(matches(isDisplayed()));
//        time.check(matches(withText("Time")));
        description.check(matches(isDisplayed()));
//        description.check(matches(withText("Description")));
        switcher.check(matches(isDisplayed()));
        switcher.check(matches(withText("Active")));
        saveButton.check(matches(isDisplayed()));
        saveButton.check(matches(withText("SAVE")));
        cancelButton.check(matches(isDisplayed()));
        cancelButton.check(matches(withText("CANCEL")));
    }

    public void pageClickable() {
        Allure.step("Проверка кликабельности элементов на странице");
        categoryBox.check(matches(isClickable()));
        titleBox.check(matches(isClickable()));
        publicationDate.check(matches(isClickable()));
        time.check(matches(isClickable()));
        description.check(matches(isClickable()));
        switcher.check(matches(isClickable()));
        saveButton.check(matches(isClickable()));
        cancelButton.check(matches(isClickable()));
    }

    public void cancelWindowVisible() {
        Allure.step("Видимости элементов в модальном окне");
        cancelButtonMessage.check(matches(isDisplayed()));
        cancelButtonMessage.check(matches(withText("The changes won't be saved, do you really want to log out?")));
        cancelCancelButton.check(matches(isDisplayed()));
        cancelCancelButton.check(matches(withText("CANCEL")));
        cancelOkButton.check(matches(isDisplayed()));
        cancelOkButton.check(matches(withText("OK")));
    }

    public void createNews() {
        Allure.step("Создание первой новости");
        categoryBox.perform(replaceText(Helper.getCategory(5)));
        titleBox.perform(replaceText("Groundhog Day"));
        publicationDate.perform(replaceText(Helper.generateDate(0)));
        time.perform(replaceText(Helper.addTime(17, 20)));
        description.perform(replaceText("День сурка (англ. Groundhog Day) — традиционный праздник в США и Канаде, отмечаемый ежегодно 2 февраля."));
        saveButton.perform(click());
    }

    public void createNews2() {
        Allure.step("Создание второй новости");
        categoryBox.perform(replaceText(Helper.getCategory(1)));
        titleBox.perform(replaceText("Найден котенок"));
        publicationDate.perform(replaceText(Helper.getСurrentDate()));
        time.perform(replaceText(Helper.getСurrentTime(0)));
        description.perform(replaceText("Найден рыжый котенок"));
        closeSoftKeyboard();
        saveButton.perform(click());
    }

}

