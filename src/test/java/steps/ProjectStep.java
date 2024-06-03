package steps;

import baseEntities.BaseStep;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideWait;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import pages.ProjectPage;


import java.awt.*;
import java.awt.event.KeyEvent;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selectors.byXpath;
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

    @SneakyThrows
    public int projectsCount() {
        projectPage.isPageOpened();
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
