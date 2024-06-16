//package ru.iteco.fmhandroid.ui.test;
//
//import androidx.test.ext.junit.rules.ActivityScenarioRule;
//import androidx.test.filters.LargeTest;
//
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.runner.RunWith;
//
//import io.qameta.allure.android.runners.AllureAndroidJUnit4;
//import io.qameta.allure.kotlin.junit4.DisplayName;
//import ru.iteco.fmhandroid.ui.AppActivity;
//import ru.iteco.fmhandroid.ui.data.page.AuthorizationPage;
//import ru.iteco.fmhandroid.ui.data.page.ControlPanelEditPage;
//import ru.iteco.fmhandroid.ui.data.page.ControlPanelPage;
//import ru.iteco.fmhandroid.ui.data.page.MenuBar;
//import ru.iteco.fmhandroid.ui.data.page.NewsPage;
//
//
//@DisplayName("Сценарии тестирования страницы ControlPanelEdit")
//@LargeTest
//@RunWith(AllureAndroidJUnit4.class)
//public class ControlPanelEditTest {
//    private AuthorizationPage authPage = new AuthorizationPage();
//    private NewsPage newsPage = new NewsPage();
//    private MenuBar menuBar = new MenuBar();
//    private ControlPanelPage controlPanel = new ControlPanelPage();
//    private ControlPanelEditPage controlPanelEditPage = new ControlPanelEditPage();
//
//    @Rule
//    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
//            new ActivityScenarioRule<>(AppActivity.class);
//
//    @Before
//    public void setUp() {
//        try {
//            menuBar.openNewsPage();
//            newsPage.clickControlPanel();
//            controlPanel.clickEdit();
//            controlPanelEditPage.waitingPageLoad();
//        } catch (Exception e) {
//            authPage.authUser();
//            menuBar.openNewsPage();
//            newsPage.clickControlPanel();
//            controlPanel.clickEdit();
//            controlPanelEditPage.waitingPageLoad();
//        }
//    }
//
////    @Epic("Позитивный")
////    @Description("Видимость элементов страницы")
////    @Test
////    public void pageVisibleTesSt() {
////        controlPanelEditPage.pageVisible();
////    }
//
//
//}
