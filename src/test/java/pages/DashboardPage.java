package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DashboardPage implements BasePage {


    private static final By TOOLBAR_LOCATOR = By.cssSelector("[data-testid='toolbar-main']");
    private static final By PROJECT_SETTINGS_LOCATOR = By.xpath("//*[@data-testid='item-settings']");
    private static final By TEST_CASE_BUTTON = By.cssSelector("[data-testid='item-testcases']");

    public SelenideElement getToolbarButton() {
        return $(TOOLBAR_LOCATOR);
    }

    public SelenideElement getProjectSettingsButton() {
        return $(PROJECT_SETTINGS_LOCATOR);
    }

    @Override
    public By getPageIdentifier() {
        return TOOLBAR_LOCATOR;
    }

    public void clickTestCaseButton() {
        $(TEST_CASE_BUTTON).shouldBe(clickable).click();
    }
}
