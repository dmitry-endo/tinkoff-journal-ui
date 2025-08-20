package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;
import pages.SearchPage;

@Tag("tj_tests")
@Owner("dmitry_endo")
@Feature("Поиск")
@DisplayName("Тесты для сайта Т-Ж")
public class SearchTests extends BaseTest {

    private final MainPage mainPage = new MainPage();
    private final SearchPage searchPage = new SearchPage();

    @ValueSource(strings = {"qa", "java", "python"})
    @ParameterizedTest(name = "Поисковой запрос {0} должен выдавать результаты")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка успешного поискового запроса")
    void successfulSearchTest(String inputQuery) {

        mainPage.openPage()
                .clickSearchIcon()
                .enterSearchQuery(inputQuery);

        searchPage.inputFieldShouldHaveEnteredValue(inputQuery)
                .searchResultsCountShouldAppear();
    }

    @ValueSource(strings = {"...", "abcdefg"})
    @ParameterizedTest(name = "Поисковой запрос {0} не должен выдавать результаты")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка неуспешного поискового запроса")
    void unsuccessfulSearchTest(String inputQuery) {

        mainPage.openPage()
                .clickSearchIcon()
                .enterSearchQuery(inputQuery);

        searchPage.inputFieldShouldHaveEnteredValue(inputQuery)
                .searchResultsCountShouldNotAppear();

    }
}
