package steps;

import baseEntities.BaseStep;
import com.codeborne.selenide.Selenide;
import lombok.SneakyThrows;
import org.openqa.selenium.By;


import java.awt.*;
import java.awt.event.KeyEvent;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static pages.ProjectPage.PROJECTS_LIST;

public class ProjectStep extends BaseStep {

    public void addProject() {

    }

    @SneakyThrows
    public void deleteLastProject() {
        choseLastProject();
        openDevTool();
        $(byXpath("//button[@data-testid='button-more_single:delete']")).shouldBe(clickable).click();
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

    private static void openDevTool() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_F12);
        robot.keyRelease(KeyEvent.VK_F12);
    }
}
