package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FlowsPage;
import pages.MainPage;
import pages.NewsPage;

@Tag("tj_main_tests")
@Owner("dmitry_endo")
@Feature("Основной контент")
@DisplayName("Тесты для сайта Т-Ж")
public class MainPageTests extends BaseTest {

    private final MainPage mainPage = new MainPage();
    private final NewsPage newsPage = new NewsPage();

    @Test
    @Story("Главная страница")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Проверка новостной ленты на главной странице")
    void newsFeedShouldBeVisibleAndClickableTest() {
        String label = "Новости";
        String paragraph = "Рассказываем все важные новости и объясняем, как они влияют на жизнь";

        mainPage.openPage()
                .newsFeedVisibleAndHasText(label)
                .clickOnNewsLabel(label);

        newsPage.checkNewsFeedTitleAndParagraph(label, paragraph);
    }
}
