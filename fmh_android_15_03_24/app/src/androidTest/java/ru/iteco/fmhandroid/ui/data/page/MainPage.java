package ru.iteco.fmhandroid.ui.data.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.hasChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsNot.not;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.data.Utility;

public class MainPage {
    private final ViewInteraction title = onView(withText("News"));
    private final ViewInteraction allNewsButton = onView(withId(R.id.all_news_text_view));
    private final ViewInteraction cardNews = onView(Utility.childAtPosition(allOf(withId
            (R.id.all_news_cards_block_constraint_layout)), 0));
    private final ViewInteraction imageNews = onView(withId(R.id.category_icon_image_view));
    private final ViewInteraction dateNews = onView(withId(R.id.news_item_date_text_view));
    private final ViewInteraction titleNews = onView(withId(R.id.news_item_title_text_view));
    private final ViewInteraction textNews = onView(withId(R.id.news_item_description_text_view));
    private final ViewInteraction viewAllNewsButton = onView(withId(R.id.expand_material_button));
    private final ViewInteraction viewNewsImage = onView(withId(R.id.view_news_item_image_view));
    private final ViewInteraction viewNewsButton = onView(withId(R.id.news_list_recycler_view));

    //@Step("Ожидание загрузки страницы")
    public void waitingPageLoad() {
        Allure.step("Ожидание загрузки страницы");
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.all_news_text_view, 7000));
    }

    //    @Step("Проверка видимости элементов на странице")
    public void pageVisible() {
        Allure.step("Проверка видимости элементов на странице");
        title.check(matches(isDisplayed()));
//        title.check(matches(ViewMatchers.withText("News")));
        allNewsButton.check(matches(isDisplayed()));
        allNewsButton.check(matches(withText("ALL NEWS")));
        viewAllNewsButton.check(matches(isDisplayed()));
        //        cardNews.check(matches(isDisplayed()));
//        imageNews.check(matches(isDisplayed()));
//        dateNews.check(matches(isDisplayed()));
//        titleNews.check(matches(isDisplayed()));
//        textNews.check(matches(not(isDisplayed())));
//        viewNewsImage.check(matches(isDisplayed()));
//        viewNewsButton.check(matches(isDisplayed()));
//        allNewsVisible(); //проверить как отработает переиспользование метода
//     viewNews.perform(actionOnItemAtPosition(0, matches(ViewMatchers.isDisplayed())));
    }

    //    @Step("Проверка кликабельности элементов на странице")
    public void pageClickable() {
        Allure.step("Проверка кликабельности элементов на странице");
        allNewsButton.check(matches(isClickable()));
        viewAllNewsButton.check(matches(isClickable()));
    }

    //    @Step("Проверка что часть элементов скрыта элементов на странице")
    public void pageInisible() {
        Allure.step("Проверка что часть элементов скрыта элементов на странице");
        title.check(matches(isDisplayed()));
        title.check(matches(withText("News")));
        viewAllNewsButton.check(matches(isDisplayed()));
        allNewsInvisible();
    }

    //    @Step("Разворачивание/сворачивание всех новостей")
    public void clickViewAllNews() {
        Allure.step("Разворачивание/сворачивание всех новостей");
        viewAllNewsButton.perform((click()));
    }

    //    @Step("Проверка видимости раздела All News на странице MainPage")
    public void allNewsVisible() {
        Allure.step("Проверка видимости раздела All News на странице MainPage");
        cardNews.check(matches(isDisplayed()));
        imageNews.check(matches(isDisplayed()));
        dateNews.check(matches(isDisplayed()));
        titleNews.check(matches(isDisplayed()));
        textNews.check(matches(not(isDisplayed())));
        viewNewsButton.check(matches(isDisplayed()));
//        viewNews.perform(actionOnItemAtPosition(0, matches(ViewMatchers.isDisplayed())));
    }

    //    @Step ("Проверка что скрыты все элементы  All News на странице MainPage")
    public void allNewsInvisible() {
        Allure.step("Проверка что скрыты все элементы  All News на странице MainPage");
        cardNews.check(matches(not(isDisplayed())));
        imageNews.check(matches(not(isDisplayed())));
        dateNews.check(matches(not(isDisplayed())));
        titleNews.check(matches(not(isDisplayed())));
        textNews.check(matches(not(isDisplayed())));
        viewNewsImage.check(matches(not(isDisplayed())));
        viewNewsButton.check(doesNotExist());

    }

    //    @Step("Разворачивание карточки новости по заданной позиции")
    public void clickView(int position) {
        Allure.step("Разворачивание карточки новости по заданной позиции");
        cardNews.perform(actionOnItemAtPosition(position, click()));
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.news_item_description_text_view, 7000));

    }

    //    @Step("Проверка колличества карточек новостей")
    public void childCount(int child) {
        Allure.step("Проверка колличества карточек новостей");
        cardNews.check(matches(hasChildCount(child)));
    }

    //    @Step("Проверка видимости текста новости после разворачивания блока новости")
    public void textNewsVisible() {
        Allure.step("Проверка видимости текста новости после разворачивания блока новости");
        textNews.check(matches(isDisplayed()));
    }


    //    @Step("Проверка невидимости текста новости после сворачивания блока новости")
    public void textNewsInvisible() {
        Allure.step("Проверка невидимости текста новости после сворачивания блока новости");
        textNews.check(matches(not(isDisplayed())));
    }

    //    @Step("Переход в раздел All news")
    public NewsPage openAllNews() {
        Allure.step("Переход в раздел All news");
        allNewsButton.perform(click());
        return new NewsPage();
    }

}
