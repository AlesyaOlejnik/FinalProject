package tests.gui;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.annotations.Test;

import java.io.IOException;

public class NegativeUITests extends BaseTest {

    @Test
    public void checkUncorrectDataMessage() {
        loginStep.unsuccessfulLogin();
    }

    @Test
    public void ExceedDataLimit() throws IOException {
        loginStep.successfulLogin(ReadProperties.getUserName(),ReadProperties.getPassword());
        dashboardStep.goToTestPlanPage();
        String testName = getTestNameFromFile();
        testPlanStep.createTestPlan(testName);
    }
}
