package tests.gui;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.NavigationSteps;
import steps.ProjectSteps;


import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.sizeLessThan;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class DeleteEntityTest extends BaseTest {

    @Test
    public void deleteEntityTest() {
        new NavigationSteps().successfulLogin(ReadProperties.getUserName(), ReadProperties.getPassword());
        open("/settings/projects");
        int projectsCount = $$(By.xpath("//*[contains(@class, 'table-row')]"))
                .shouldHave(sizeGreaterThan(0))
                .size();

        new ProjectSteps().deleteLastProject();

        $$(By.xpath("//*[contains(@class, 'table-row')]")).shouldHave(sizeLessThan(projectsCount));
        int projectsCountAfterRemove = $$(By.xpath("//*[contains(@class, 'table-row')]"))
                .shouldHave(sizeGreaterThan(0))
                .size();
        Assert.assertEquals(projectsCountAfterRemove, projectsCount - 1, "Проект не удален");
    }
}
