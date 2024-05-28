package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.*;
import static pages.ProjectPage.PROJECTS_LIST;

public class ProjectSteps extends BaseStep {

    public void addProject() {

    }

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

}
