package tests.gui;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.annotations.Test;
import steps.LoginStep;

import static com.codeborne.selenide.Condition.visible;


public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest() {
        LoginStep navigationSteps = new LoginStep();

        navigationSteps
                .successfulLogin(ReadProperties.getUserName(), ReadProperties.getPassword())
                .getToolbarButton().shouldBe(visible);
    }

}
