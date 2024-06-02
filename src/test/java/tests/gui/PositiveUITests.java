package tests.gui;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.UUID;

import static com.codeborne.selenide.Selenide.$;

public class PositiveUITests extends BaseTest {

    @BeforeMethod
    @Override
    public void setupBrowser() {
        super.setupBrowser();
        loginStep.successfulLogin(ReadProperties.getUserName(), ReadProperties.getPassword());
    }

    @Test
    public void checkInputField() throws IOException, InterruptedException {
        dashboardStep.goToTestCasesPage();
        String testName = getTestNameFromFile();
        testCasesStep.checkInputFieldForBoundaryValues(testName);
    }

    @Test
    public void createEntity(){
        dashboardStep.goToTestCasesPage();
        String testName = UUID.randomUUID().toString();
        testCasesStep.createTestCase(testName);
    }

    @Test
    public void uploadFile() {
        dashboardStep.goToTestCasesPage();
        File file = new File("src/test/resources/upload.csv");
        testCasesStep.downloadFile(file);
    }

    @Test
    public void checkVisiblePopupMessage() throws IOException {
        dashboardStep.goToTestCasesPage();
        String testName = getTestNameFromFile();
        testCasesStep.checkPopupMessage(testName);
    }
}
