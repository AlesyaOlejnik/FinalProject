package steps;

import baseEntities.BaseSteps;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.*;

public class ProjectSteps extends BaseSteps {

    public void addProject() {

    }

    public void deleteLastProject() {
        $$(By.xpath("//*[contains(@class, 'table-row')]"))
                .shouldHave(sizeGreaterThan(0))
                .last()
                .click();
        $(By.xpath("//*[@data-testid='button-more_single:delete']")).shouldBe(clickable).click();
        $(By.xpath("//*[@data-testid='button-affirm']")).shouldBe(clickable).click();
    }

    public static String getProjectLastName() {
        String projectName = $$(By.xpath("//*[contains(@class, 'table-row')]"))
                .shouldHave(sizeGreaterThan(0))
                .last()
                .getText();
        return projectName;
    }

}
