package steps;

import baseEntities.BaseSteps;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectSteps extends BaseSteps {

    public void addProject() {

    }

    public void deleteProject() {
        $$(By.xpath("//*[contains(@class, 'table-row')]"))
                .shouldHave(sizeGreaterThan(0))
                .last()
                .click();
        $(By.xpath("//*[@data-testid='button-more_single:delete']")).shouldBe(clickable).click();
        $(By.xpath("//*[@data-testid='button-affirm']")).shouldBe(clickable).click();
    }

}
