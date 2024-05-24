package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.$;

public class SettingsPage {

    private final By projectsButtonLocator = By.xpath("//*[@data-testid='item-projects']");

    public SelenideElement getProjectsButton() {
        return $(projectsButtonLocator).shouldBe(clickable);
    }
}
