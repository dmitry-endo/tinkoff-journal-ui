package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private final SelenideElement searchInput = $("[placeholder='Что вам найти?']");
    private final SelenideElement searchCount = $("[class^='_searchCount']");

    @Step("Проверяем, что в поле для ввода присутствует значение {0}")
    public SearchPage inputFieldShouldHaveEnteredValue(String value) {
        searchInput.shouldHave(attribute("value", value));

        return this;
    }

    @Step("Проверяем, что счетчик результатов поиска присутствует")
    public SearchPage searchResultsCountShouldAppear() {
        searchCount.should(exist);

        return this;
    }

    @Step("Проверяем, что счетчик результатов поиска отсутствует")
    public SearchPage searchResultsCountShouldNotAppear() {
        searchCount.shouldNot(exist);

        return this;
    }
}
