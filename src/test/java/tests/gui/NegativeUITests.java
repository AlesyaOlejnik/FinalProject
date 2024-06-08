package tests.gui;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NegativeUITests extends BaseTest {

    @Test
    public void checkIncorrectDataMessage() {
        loginStep.unsuccessfulLogin();
    }

    @Test
    public void exceedDataLimit() throws IOException {
        loginStep.successfulLogin(ReadProperties.getUserName(),ReadProperties.getPassword());
        dashboardStep.goToTestPlanPage();
        String testName = getTestNameFromFile();
        testPlanStep.createTestPlan(testName);
    }

    @Test
    public void failedTest(){
        loginStep.successfulLogin(ReadProperties.getUserName(),ReadProperties.getPassword());
        $("[there-is-no-selector='like-this]").shouldBe(visible);
    }
}
