package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectPage implements BasePage {

    public static final By PROJECT_PAGE_IDENTIFIER = By.xpath("//*[@class='sc-ivgKhA gmkXAH']");

    public static final By PROJECTS_LIST = By.xpath("//*[contains(@class, 'table-row')]");

    public static final By DELETE_LP_BUTTON_LOCATOR = (By.xpath("(//button[@data-testid='button-more_single:delete'])[last()]"));

    @Override
    public By getPageIdentifier() {
        return PROJECT_PAGE_IDENTIFIER;
    }

    public SelenideElement getDeleteLPButton() {
        return $(DELETE_LP_BUTTON_LOCATOR).shouldBe(clickable);
    }

    public ElementsCollection getProjectsList() {
        return  $$(PROJECTS_LIST);
    }



}
