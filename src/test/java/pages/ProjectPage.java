package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectPage implements BasePage {

    public static final By PROJECTS_LIST = By.xpath("//*[contains(@class, 'table-row')]");

    public void deleteLastProject() {
        $$(PROJECTS_LIST)
                .shouldHave(sizeGreaterThan(0))
                .last()
                .click();
        $(By.xpath("(//button[@data-testid='button-more_single:delete'])[last()]")).shouldBe(clickable).click();
        $(By.xpath("//*[@data-testid='button-affirm']")).shouldBe(clickable).click();
    }

    public static String getProjectLastName() {
        String projectName = $$(PROJECTS_LIST)
                .shouldHave(sizeGreaterThan(0))
                .last()
                .getText();
        return projectName;
    }

    @Override
    public By getPageIdentifier() {
        return PROJECTS_LIST;
    }
}
