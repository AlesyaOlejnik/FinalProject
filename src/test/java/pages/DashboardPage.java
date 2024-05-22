package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DashboardPage {
    private static final String pagePath = "/dashboard";

    public void openPage() {
        open(pagePath);
    }
    private static final By skipButton = By.id("//*[@data-testid='toolbar-main']");

    public SelenideElement getSkipButton() {
        return $(skipButton);
    }
}
