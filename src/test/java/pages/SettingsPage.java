package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.$;

public class SettingsPage implements BasePage {

    private final By projectsButtonLocator = By.xpath("//*[@data-testid='item-projects']");

    public SelenideElement getProjectsButton() {
        return $(projectsButtonLocator).shouldBe(clickable);
    }

    public ProjectPage goToProjectPage() {
        getProjectsButton().click();
        isPageOpened();
        return new ProjectPage();
    }


    @Override
    public By getPageIdentifier() {
        return projectsButtonLocator;
    }
}
