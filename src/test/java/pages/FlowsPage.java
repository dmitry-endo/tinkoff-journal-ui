package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class FlowsPage {

    private final SelenideElement flowsPageWrapper = $("[data-app-name='flows-page']");

    @Step("Открываем страницу Потоки")
    public FlowsPage openPage() {
        open("/flows");

        return this;
    }

    @Step("Проверяем заголовок страницы Потоки")
    public FlowsPage checkFlowsPageTitleAndParagraph(String title, String paragraph) {
        flowsPageWrapper.$("h1").shouldHave(text(title));
        flowsPageWrapper.$("p").shouldHave(text(paragraph));

        return this;
    }

    @Step("Проверяем, что присутствуют блоки с темами: {0}")
    public FlowsPage checkFlowsPageCategories(String[] values) {
        List<String> allTexts = flowsPageWrapper.$$("[class*='_container_'] div").texts();
        assertThat(allTexts).contains(values);

        return this;
    }

    @Step("Проверяем, что количество категорий больше {0}")
    public FlowsPage checkFlowsPageSizeGreaterThan(int value) {
        flowsPageWrapper.$$("[class*='_container_'] div").shouldHave(sizeGreaterThan(value));

        return this;
    }
}
