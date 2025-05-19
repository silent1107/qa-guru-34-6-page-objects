package pages.components;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

    public void checkResult(String key, String value) {
        $(byTagAndText("td", key)).sibling(0).shouldHave(exactText(value));
    }

}
