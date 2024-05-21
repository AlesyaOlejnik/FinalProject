package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private static final String pagePath = "/dashboard";

    private static final By toolbarLocator = By.id("//*[@data-testid='toolbar-main']");

    public SelenideElement getToolbar() {
        return $(toolbarLocator);
    }
}
