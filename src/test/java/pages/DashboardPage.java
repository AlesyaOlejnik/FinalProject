package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private static final String pagePath = "/dashboard";


    private static final By TOOLBAR_LOCATOR = By.cssSelector("[data-testid='toolbar-main']");
    private static final By PROJECT_SETTINGS_LOCATOR = By.xpath("//*[@data-testid='item-settings']");


    public SelenideElement getToolbarButton() {
        return $(TOOLBAR_LOCATOR);
    }

    public SelenideElement getProjectSettingsButton() {
        return $(PROJECT_SETTINGS_LOCATOR);
    }
}
