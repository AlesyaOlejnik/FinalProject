package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.By;


import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.*;
import static pages.ProjectPage.PROJECTS_LIST;

public class ProjectStep extends BaseStep {

    public void addProject() {

    }

    public void deleteLastProject() {
        choseLastProject();
        clickDeleteLPButton();
        $(By.xpath("//*[@data-testid='button-affirm']")).shouldBe(clickable).click();
    }

    public String getProjectLastName() {
        String projectName = projectPage.getProjectsList()
                .shouldHave(sizeGreaterThan(0))
                .last()
                .getText();
        return projectName;
    }

    public void choseLastProject() {
        projectPage.getProjectsList()
                .shouldHave(sizeGreaterThan(0))
                .last()
                .click();
    }

    public void clickDeleteLPButton() {
        projectPage.getDeleteLPButton().click();
    }

    public int projectsCount() {
        return $$(PROJECTS_LIST).shouldHave(sizeGreaterThan(0)).size();
    }

    public String getLastKey() {
        String projectName = projectPage.getDescriptionList()
                .shouldHave(sizeGreaterThan(0))
                .get(projectPage.getDescriptionList().size() - 2)
                .getText();
        return projectName;
    }

    public String getLastDescription() {
        String projectName = projectPage.getDescriptionList()
                .shouldHave(sizeGreaterThan(0))
                .last()
                .getText();
        return projectName;
    }



}
