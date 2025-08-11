package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class NewsPage {

    private final SelenideElement flowPageWrapper = $("[data-app-name='flow-page']");

    @Step("Проверяем заголовок страницы в новостной ленте")
    public NewsPage checkNewsFeedTitleAndParagraph(String title, String paragraph) {
        flowPageWrapper.$("h1").shouldHave(text(title));
        flowPageWrapper.$("p").shouldHave(text(paragraph));

        return this;
    }
}
