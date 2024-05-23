package tests.gui;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.NavigationSteps;

import static com.codeborne.selenide.Condition.visible;


public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest() {
        NavigationSteps navigationSteps = new NavigationSteps();

        Assert.assertTrue(
                navigationSteps
                        .successfulLogin(ReadProperties.getUserName(), ReadProperties.getPassword())
                        .getToolbarButton().shouldBe(visible).isDisplayed());
    }

}
