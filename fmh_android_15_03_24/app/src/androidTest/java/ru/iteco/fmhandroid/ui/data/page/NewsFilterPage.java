package ru.iteco.fmhandroid.ui.data.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.data.Utility;

public class NewsFilterPage {
    private final ViewInteraction title = onView(withId(R.id.filter_news_title_text_view));
    private final ViewInteraction category = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    private final ViewInteraction viewCategory = onView(withId(com.google.android.material.R.id.text_input_end_icon));
    private final ViewInteraction startDate = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    private final ViewInteraction endDate = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    //    private final ViewInteraction canselButtonCalendar = onView(withId(android.R.id.button2));
//    private final ViewInteraction okButtonCalendar = onView(withId(android.R.id.button1));
    private final ViewInteraction filterButton = onView(withId(R.id.filter_button));
    private final ViewInteraction cancelButtonFilter = onView(withId(R.id.cancel_button));
    private final ViewInteraction emptyNewsImage = onView(withId(R.id.empty_news_list_image_view));
    private final ViewInteraction emptyNewsTitle = onView(withId(R.id.empty_news_list_text_view));
    private final ViewInteraction refreshButton = onView(withId(R.id.news_retry_material_button));
    private final ViewInteraction errorMessage = onView(withId(android.R.id.message));
    private final ViewInteraction errorMessageOkButton = onView(withId(android.R.id.button1));

    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.filter_news_title_text_view, 7000));
    }

    public void pageVisible() {
        Allure.step("Проверка видимости элементов на странице");
        title.check(matches(isDisplayed()));
        title.check(matches(withText("Filter news")));
        category.check(matches(isDisplayed()));
//        category.check(matches(ViewMatchers.withText("Category")));
//        viewCategory.check(matches(isDisplayed()));
        startDate.check(matches(isDisplayed()));
//        startDate.check(matches(withText("DD.MM.YYYY")));
        endDate.check(matches(isDisplayed()));
//        endDate.check(matches(ViewMatchers.withText("DD.MM.YYYY")));
        filterButton.check(matches(isDisplayed()));
        filterButton.check(matches(withText("FILTER")));
        cancelButtonFilter.check(matches(isDisplayed()));
        cancelButtonFilter.check(matches(withText("CANCEL")));
    }

    public void addCategory(String data) {
        Allure.step("Ввод категории");
        category.perform(replaceText(data));
    }

    public void addStartDate(String value) {
        Allure.step("Ввод даты начала");
        startDate.perform(replaceText(value), closeSoftKeyboard());
    }

    public void addEndDate(String value) {
        Allure.step("Ввод даты окончания");
        endDate.perform(replaceText(value), closeSoftKeyboard());
    }

    public void clickFilter() {
        Allure.step("Нажатие на кнопку FILTER");
        filterButton.perform(click());
    }

    public void clickCancel() {
        Allure.step("Нажатие на кнопку CANCEL");
        cancelButtonFilter.perform(click());
    }

    public void emptyNewsVisible() {
        Allure.step("Проверка видимости страницы без новостей");
        emptyNewsImage.check(matches(isDisplayed()));
        emptyNewsTitle.check(matches(isDisplayed()));
        emptyNewsTitle.check(matches(withText("There is nothing here yet�")));
        refreshButton.check(matches(isDisplayed()));
        refreshButton.check(matches(withText("REFRESH")));
    }

    public void clickRefresh() {
        Allure.step("Нажатие на кнопку REFRESH");
        refreshButton.perform(click());
    }

    public void errorVisible() {
        Allure.step("Проверка видимости модального окна с текстом ошибки");
        errorMessage.check(matches(isDisplayed()));
        errorMessage.check(matches(withText("Wrong period")));
        errorMessageOkButton.check(matches(isDisplayed()));
        errorMessageOkButton.check(matches(withText("OK")));
    }

    public void clickErrorMessageOkButton() {
        Allure.step("Закрытие модального окна с текстом ошибки");
        errorMessageOkButton.perform(click());
    }
}


