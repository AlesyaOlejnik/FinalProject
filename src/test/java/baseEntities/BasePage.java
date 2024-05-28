package baseEntities;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public interface BasePage {

    By getPageIdentifier();

    default void isPageOpened() {
        $(getPageIdentifier()).shouldBe(visible);
    }

}
