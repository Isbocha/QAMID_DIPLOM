package ru.iteco.fmhandroid.ui.data.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.data.Utility;

public class OurMissionPage {

    private final ViewInteraction title = onView(withId(R.id.our_mission_title_text_view));
    private final ViewInteraction materialCard = onView(allOf(withId(R.id.our_mission_item_list_recycler_view), Utility.
            childAtPosition(withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")), 0)));
    private final ViewInteraction imageCard = onView(withId(R.id.our_mission_item_image_view));
    private final ViewInteraction itemTitle = onView(withId(R.id.our_mission_item_title_text_view));
    private final ViewInteraction itemTextCard = onView(allOf(withId(R.id.our_mission_item_description_text_view),
            withParent(withParent(withId(R.id.our_mission_item_material_card_view))),
            isDisplayed()));
    private final ViewInteraction viewCardButton = onView(withId(R.id.our_mission_item_open_card_image_button));

    public void waitingPageLoad() {
        onView(isRoot()).perform(Utility.waitDisplayed(R.id.our_mission_title_text_view, 7000));
    }

    //    @Step("Проверка видимости элементов на странице")
    public void pageVisible() {
        Allure.step("Проверка видимости элементов на странице");
        title.check(matches(isDisplayed()));
        title.check(matches(withText("Love is all")));
//        materialCard.check(matches(isDisplayed()));
//        imageCard.check(matches(isDisplayed()));
//        itemTitle.check(matches(isDisplayed()));
//        viewCardButton.check(matches(isDisplayed()));
//        itemTextCard.check(matches(not(isDisplayed())));
    }

    //    @Step("Разворачивание/сворачивание карточки с цитатой по заданной позиции")
    public void clickView(int position) {
        Allure.step("Разворачивание/сворачивание карточки с цитатой по заданной позиции");
        materialCard.perform(actionOnItemAtPosition(position, click()));
    }

    //    @Step("Проверка видимости текста после разворачивания карточки с цитатой")
    public void textCardVisible(String text) {
        Allure.step("Проверка видимости текста после разворачивания карточки с цитатой");
        itemTextCard.check(matches(withText(text)));
        itemTextCard.check(matches(isDisplayed()));
    }

    //    @Step("Проверка невидимости текста  после сворачивания  карточки с цитатой")
    public void textCardInvisible() {
        Allure.step("Проверка невидимости текста  после сворачивания  карточки с цитатой");
        itemTextCard.check(matches(not(isDisplayed())));
    }
}

