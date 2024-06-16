package ru.iteco.fmhandroid.ui.data.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.data.Utility;

public class ControlPanelFilterPage {
    private final ViewInteraction title = Espresso.onView(ViewMatchers.withId(R.id.filter_news_title_text_view));
    private final ViewInteraction category = Espresso.onView(ViewMatchers.withId(R.id.news_item_category_text_auto_complete_text_view));
    private final ViewInteraction viewCategory = Espresso.onView(ViewMatchers.withId(com.google.android.material.R.id.text_input_end_icon));
    private final ViewInteraction startDate = Espresso.onView(ViewMatchers.withId(R.id.news_item_publish_date_start_text_input_edit_text));
    private final ViewInteraction endDate = Espresso.onView(ViewMatchers.withId(R.id.news_item_publish_date_end_text_input_edit_text));
    private final ViewInteraction checkBoxActive = Espresso.onView(ViewMatchers.withId(R.id.filter_news_active_material_check_box));
    private final ViewInteraction checkBoxNotActive = Espresso.onView(ViewMatchers.withId(R.id.filter_news_inactive_material_check_box));
//    private final ViewInteraction okButtonCalendar = Espresso.onView(ViewMatchers.withId(android.R.id.button1));


//    //        private final ViewInteraction currentDate = Espresso.onView(ViewMatchers.allOf(IsInstanceOf.instanceOf(android.widget.TextView::class.java));
//    private final ViewInteraction canselButtonCalendar = Espresso.onView(ViewMatchers.withId(android.R.id.button2));
//    private final ViewInteraction okButtonCalendar = Espresso.onView(ViewMatchers.withId(android.R.id.button1));

    private final ViewInteraction filterButton = Espresso.onView(ViewMatchers.withId(R.id.filter_button));
    private final ViewInteraction cancelButtonFilter = Espresso.onView(ViewMatchers.withId(R.id.cancel_button));

    private final ViewInteraction emptyNewsImage = onView(withId(R.id.empty_news_list_image_view));
    private final ViewInteraction emptyNewsTitle = onView(withId(R.id.empty_news_list_text_view));
    //    private final ViewInteraction refreshButton = onView(withId(R.id.news_retry_material_button));
    private final ViewInteraction refreshButton = onView(withText("REFRESH"));

    private final ViewInteraction errorMessage = onView(withId(android.R.id.message));
    private final ViewInteraction errorMessageOkButton = onView(withId(android.R.id.button1));

    //    @Step("Ожидание загрузки страницы")
    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.filter_news_title_text_view, 7000));
    }


    //    @Step("Проверка видимости элементов на странице")
    public void pageVisible() {
        Allure.step("Проверка видимости элементов на странице");
        title.check(matches(isDisplayed()));
        title.check(matches(ViewMatchers.withText("Filter news")));
        category.check(matches(isDisplayed()));
//        category.check(matches(ViewMatchers.withText("Category")));
//        viewCategory.check(matches(isDisplayed()));
        startDate.check(matches(isDisplayed()));
//        startDate.check(matches(ViewMatchers.withText("DD.MM.YYYY")));
        endDate.check(matches(isDisplayed()));
//        endDate.check(matches(ViewMatchers.withText("DD.MM.YYYY")));
        checkBoxActive.check(matches(isDisplayed()));
        checkBoxActive.check(matches(ViewMatchers.withText("Active")));
        checkBoxNotActive.check(matches(isDisplayed()));
        checkBoxNotActive.check(matches(ViewMatchers.withText("Not active")));
        filterButton.check(matches(isDisplayed()));
        filterButton.check(matches(ViewMatchers.withText("FILTER")));
        cancelButtonFilter.check(matches(isDisplayed()));
        cancelButtonFilter.check(matches(ViewMatchers.withText("CANCEL")));
    }

    //    @Step("Проверка кликабельности элементов на странице")
    public void pageClicable() {
        Allure.step("Проверка кликабельности элементов на странице");
//        title.check(matches(isClickable()));
        category.check(matches(isClickable()));
        startDate.check(matches(isClickable()));
        endDate.check(matches(isClickable()));
        checkBoxActive.check(matches(isClickable()));
        checkBoxNotActive.check(matches(isClickable()));
        filterButton.check(matches(isClickable()));
        cancelButtonFilter.check(matches(isClickable()));
    }

    //    @Step("Ввод категории")
    public void addCategory(String data) {
        Allure.step("Ввод категории");
        category.perform(replaceText(data));
    }

    //    @Step("Ввод даты начала")
    public void addStartDate(String value) {
        Allure.step("Ввод даты начала");
        startDate.perform(replaceText(value), closeSoftKeyboard());
    }

    //    @Step("Ввод даты окончания")
    public void addEndDate(String value) {
        Allure.step("Ввод даты окончания");
        endDate.perform(replaceText(value), closeSoftKeyboard());
    }

    //    @Step("Нажатие на чек-бокс Active")
    public void clickActiveCheckBox() {
        Allure.step("Нажатие на чек-бокс Active");
        checkBoxActive.perform(click());
    }

    //    @Step("Нажатие на чек-бокс NotActive")
    public void clickNotActiveCheckBox() {
        Allure.step("Нажатие на чек-бокс NotActive");
        checkBoxNotActive.perform(click());
    }

    //    @Step("Проверка видимости страницы без новостей")
    public void emptyNewsVisible() {
        Allure.step("Проверка видимости страницы без новостей");
        emptyNewsImage.check(matches(isDisplayed()));
        emptyNewsTitle.check(matches(isDisplayed()));
        emptyNewsTitle.check(matches(ViewMatchers.withText("There is nothing here yet�")));
        refreshButton.check(matches(isDisplayed()));
        refreshButton.check(matches(ViewMatchers.withText("REFRESH")));
    }

    //    @Step("Проверка видимости кнопки REFRESH")
    public void clickRefreshVisible() {
        Allure.step("Проверка видимости кнопки REFRESH");
        refreshButton.check(matches(isDisplayed()));
    }

    //    @Step("Нажатие на кнопку REFRESH")
    public void clickRefresh() {
        Allure.step("Нажатие на кнопку REFRESH");
        refreshButton.perform(click());
    }

    //    @Step("Нажатие на кнопку CANCEL")
    public void clickCancel() {
        Allure.step("Нажатие на кнопку CANCEL");
        cancelButtonFilter.perform(click());
    }

    //    @Step("Нажатие на кнопку FILTER")
    public void clickFilter() {
        Allure.step("Нажатие на кнопку FILTER");
        filterButton.perform(click());
    }

    //    @Step("Видимость модального окна с текстом ошибки")
    public void errorVisible() {
        Allure.step("Видимость модального окна с текстом ошибки");
        errorMessage.check(matches(isDisplayed()));
        errorMessage.check(matches(withText("Wrong period")));
        errorMessageOkButton.check(matches(isDisplayed()));
        errorMessageOkButton.check(matches(withText("OK")));
    }

    //    @Step("Закрытие модального окна с текстом ошибки")
    public void clickErrorMessageOkButton() {
        Allure.step("Закрытие модального окна с текстом ошибки");
        errorMessageOkButton.perform(click());
    }
}

