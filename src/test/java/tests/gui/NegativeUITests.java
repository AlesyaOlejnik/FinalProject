package tests.gui;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

public class NegativeUITests extends BaseTest {

    @Test
    public void checkUncorrectDataMessage() {
        loginStep.unsuccessfulLogin();
    }
    @BeforeTest
    public void setupBrowser() {
        super.setupBrowser();
        loginStep.successfulLogin(ReadProperties.getUserName(), ReadProperties.getPassword());
    }
    @Test
    public void ExceedDataLimit() throws IOException {
        dashboardStep.goToTestPlanPage();
        String testName = getTestNameFromFile();
        testPlanStep.createTestPlan(testName);
    }
}
