package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectPage implements BasePage {

    public static final By PROJECTS_LIST = By.xpath("//*[contains(@class, 'table-row')]");

    @Override
    public By getPageIdentifier() {
        return PROJECTS_LIST;
    }
}
