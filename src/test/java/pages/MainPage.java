package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPage {

    private final SelenideElement newsFeedWrapper = $("[data-level-type='news']");
    private final SelenideElement sectionsWrapper = $("[aria-label='Разделы']");
    private final SelenideElement notificationsWindowWrapper = $("[class^='_notificationWrap']");
    private final SelenideElement notificationsIcon = $("[aria-label='Уведомления']");
    private final SelenideElement loginModalWindowWrapper = $("[aria-labelledby='dialog-title']");
    private final SelenideElement profileIcon = $("[aria-label='Авторизоваться']");
    private final ElementsCollection headerNavTabs = $$("[aria-label='Основная навигация'] a");
    private final SelenideElement searchIcon = $("[aria-label='Поиск']");
    private final SelenideElement searchInput = $("[aria-label='Поле поиска']");
    private final SelenideElement searchSuggestWrapper = $("[class^='_suggest']");
    private final ElementsCollection suggestQueriesList = $$("[class^='_suggest'] li");

    @Step("Открываем главную страницу")
    public MainPage openPage() {
        open("/");

        return this;
    }

    @Step("Проверяем, что новостная лента видна и имеет заголовок")
    public MainPage newsFeedVisibleAndHasText(String value) {
        newsFeedWrapper.shouldBe(visible).shouldHave(text(value));

        return this;
    }

    @Step("Кликаем на новостную ленту")
    public MainPage clickOnNewsLabel(String value) {
        newsFeedWrapper.find(byText(value)).click();

        return this;
    }

    @Step("Проверяем количество основных вкладок навигации в хедере")
    public MainPage checkNavTabsSize(int value) {
        headerNavTabs.shouldHave(size(value));

        return this;
    }

    @Step("Проверяем названия основных вкладок навигации в хедере")
    public MainPage checkNavTabsLabels(String label1, String label2, String label3) {
        headerNavTabs.shouldHave(exactTexts(label1, label2, label3));

        return this;
    }

    @Step("Проверяем, что окошко с уведомлениями скрыто")
    public MainPage notificationsWindowShouldNotBeVisible() {
        notificationsWindowWrapper.shouldNotBe(visible);

        return this;
    }

    @Step("Проверяем, что окошко с уведомлениями появилось")
    public MainPage notificationsWindowShouldBeVisible() {
        notificationsWindowWrapper.shouldBe(visible);

        return this;
    }

    @Step("Кликаем на колокольчик в хедере")
    public MainPage clickNotificationBell() {
        notificationsIcon.click();

        return this;
    }

    @Step("Открываем страницу Потоки")
    public MainPage clickShowAll() {
        sectionsWrapper.find(byTagAndText("a", "Смотреть все")).click();

        return this;
    }

    @Step("Проверяем, что модальное окно для входа в профиль скрыто")
    public MainPage loginModalWindowShouldNotBeVisible() {
        loginModalWindowWrapper.shouldNotBe(visible);

        return this;
    }

    @Step("Проверяем, что модальное окно для входа в профиль появилось")
    public MainPage loginModalWindowShouldBeVisible() {
        loginModalWindowWrapper.shouldBe(visible);

        return this;
    }

    @Step("Открываем модальное окно для входа в профиль")
    public MainPage clickProfileIcon() {
        profileIcon.click();

        return this;
    }

    @Step("Кликаем на иконку поиска")
    public MainPage clickSearchIcon() {
        searchIcon.click();

        return this;
    }

    @Step("Вводим поисковой запрос {0}, жмем Enter")
    public MainPage enterSearchQuery(String value) {
        searchInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Проверяем, что меню с предлагаемыми запросами скрыто")
    public MainPage suggestQueriesShouldNotBeVisible() {
        searchSuggestWrapper.shouldHave(attribute("data-open", "false"));

        return this;
    }

    @Step("Проверяем, что меню с предлагаемыми запросами появилось")
    public MainPage suggestQueriesShouldBeVisible() {
        searchSuggestWrapper.shouldHave(attribute("data-open", "true"));

        return this;
    }

    @Step("Проверяем размер меню с предлагаемыми запросами")
    public MainPage checkSuggestQueriesListSize(int value) {
        suggestQueriesList.shouldHave(size(value));

        return this;
    }
}
