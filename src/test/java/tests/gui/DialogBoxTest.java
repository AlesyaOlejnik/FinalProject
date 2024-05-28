package tests.gui;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.ProjectSteps;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.*;

@Test
public class DialogBoxTest extends BaseTest {

//    public void dialogBoxTest() {
//        new NavigationSteps().successfulLogin(ReadProperties.getUserName(), ReadProperties.getPassword());
//        open("/settings/projects");
//        String name = ProjectSteps.getProjectLastName();
//
//        $$(By.xpath("//*[contains(@class, 'table-row')]"))
//                .shouldHave(sizeGreaterThan(0))
//                .last()
//                .click();
//        $(By.xpath("//*[@data-testid='button-more_single:delete']")).shouldBe(clickable).click();
//        $(By.xpath("//div[text() ='Delete']")).shouldBe(clickable);
//        Assert.assertEquals("Confirm project deletion", $x("//*[@data-testid='text-title']").text());
//        Assert.assertEquals($x("//*[@data-testid='text-body']").text(),
//                "Do you want to delete the project " + name + "?");
//        $(By.xpath("//div[text() ='Delete']")).shouldBe(clickable);
//    }

}
