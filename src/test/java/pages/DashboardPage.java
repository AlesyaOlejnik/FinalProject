package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private static final String pagePath = "/dashboard";


    private static final String toolbar = "[data-testid='toolbar-main']";

    public SelenideElement getToolbarButton() {
        return $(toolbar);
    }
}
