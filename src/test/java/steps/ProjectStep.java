package steps;

import baseEntities.BaseStep;
import lombok.SneakyThrows;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.*;
import static pages.ProjectPage.PROJECTS_LIST;

public class ProjectStep extends BaseStep {

    @SneakyThrows
    public void deleteLastProject() {
        choseLastProject();
        clickDeleteLPButton();
        $("[data-testid='button-affirm']").shouldBe(clickable).click();
    }

    public String getProjectLastName() {
        return projectPage.getProjectsList()
                .shouldHave(sizeGreaterThan(0))
                .last()
                .getText();
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

    @SneakyThrows
    public int projectsCount() {
        projectPage.isPageOpened();
        Thread.sleep(500);
        return $$(PROJECTS_LIST).size();
    }

    public String getLastKey() {
        return projectPage.getDescriptionList()
                .shouldHave(sizeGreaterThan(0))
                .get(projectPage.getDescriptionList().size() - 2)
                .getText();
    }

    public String getLastDescription() {
        return projectPage.getDescriptionList()
                .shouldHave(sizeGreaterThan(0))
                .last()
                .getText();
    }
}
