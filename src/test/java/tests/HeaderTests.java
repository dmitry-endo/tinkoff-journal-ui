package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

@Tag("tj_header_tests")
@Owner("dmitry_endo")
@Feature("Хедер")
@DisplayName("Тесты для сайта Т-Ж")
public class HeaderTests extends BaseTest {

    private final MainPage mainPage = new MainPage();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка появления модального окна входа в профиль")
    void loginModalWindowShouldAppearTest() {

        mainPage.openPage()
                .loginModalWindowShouldNotBeVisible()
                .clickProfileIcon()
                .loginModalWindowShouldBeVisible();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Проверка названия и количества основных вкладок навигации в хедере")
    void headerNavigationTabsShouldHaveExactLabelsAndSizeTest() {

        mainPage.openPage()
                .checkNavTabsSize(3)
                .checkNavTabsLabels("Учебник", "Приложение", "Сообщество");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка появления окошка с уведомлениями")
    void clickOnBellIconShouldOpenNotificationWindowTest() {

        mainPage.openPage()
                .notificationsWindowShouldNotBeVisible()
                .clickNotificationBell()
                .notificationsWindowShouldBeVisible();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Проверка появления и размера меню с предлагаемыми запросами после нажатия на поиск")
    void clickOnSearchShouldShowSuggestQueriesWithExpectedSizeTest() {

        mainPage.openPage()
                .suggestQueriesShouldNotBeVisible()
                .clickSearchIcon()
                .suggestQueriesShouldBeVisible()
                .checkSuggestQueriesListSize(5);
    }
}
