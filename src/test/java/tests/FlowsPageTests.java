package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FlowsPage;
import pages.MainPage;

@Tag("tj_main_tests")
@Owner("dmitry_endo")
@Feature("Страница Потоки")
@DisplayName("Тесты для сайта Т-Ж")
public class FlowsPageTests extends BaseTest {

    private final MainPage mainPage = new MainPage();
    private final FlowsPage flowsPage = new FlowsPage();

    @Test
    @Story("Основной контент")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка основных категорий на странице Потоки")
    void flowsPageShouldHaveExpectedCategoriesTest() {
        String title = "Потоки";
        String paragraph = "Все темы, о которых мы пишем в журнале";
        String[] categories = new String[]{"Инвестиции", "Путешествия", "Эмиграция", "Что делать?",
                "Дневники", "Россия", "Недвижимость", "Бизнес",
                "Правовая грамотность", "Спорт и фитнес", "Поп-культура", "Общество"};

        mainPage.openPage()
                .clickShowAll();

        flowsPage.checkFlowsPageTitleAndParagraph(title, paragraph)
                .checkFlowsPageCategories(categories);
    }

    @Test
    @Story("Основной контент")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Проверка количества категорий на странице Потоки")
    void checkFlowsPageSizeTest() {

        flowsPage.openPage()
                .checkFlowsPageSizeGreaterThan(100);
    }
}
