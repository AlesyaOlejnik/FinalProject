package tests.gui;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PositiveUITests extends BaseTest {

    @BeforeMethod
    @Override
    public void setupBrowser(ITestContext iTestContext) {
        super.setupBrowser(iTestContext);
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

    @Test
    public void deleteEntityTest() {
        dashboardStep
                .goToProjectSettingsPage()
                .goToProjectPage();
        int projectsBeforeRemove = projectSteps.projectsCount();
        int expResult = projectsBeforeRemove - 1;

        projectSteps.deleteLastProject();

        int projectsAfterRemove = projectSteps.projectsCount();
        Assert.assertEquals(projectsAfterRemove, expResult, "Проект не удален");
    }

    @Test
    public void dialogBoxTest() {
        dashboardStep.goToProjectSettingsPage().goToProjectPage();
        //Получаем имя проекта с Project Key и Description(если они есть) и убираем переносы на новую строку
        String name = Arrays.stream(projectSteps.getProjectLastName().split("\n")).collect(Collectors.joining());
        projectSteps.choseLastProject();
        projectSteps.clickDeleteLPButton();

        String actualResult= "Do you want to delete the project " + name + "?";

        String tmp = $x("//*[@data-testid='text-body']").text(); //актуальный текст
        String expectedResult = tmp.substring(0, tmp.length() - 1) +
                projectSteps.getLastKey() +
                projectSteps.getLastDescription() + "?";

        $(By.xpath("//div[text() ='Delete']")).shouldBe(clickable);
        Assert.assertEquals("Confirm project deletion", $x("//*[@data-testid='text-title']").text());
        Assert.assertEquals(actualResult, expectedResult);
        $(By.xpath("//div[text() ='Delete']")).shouldBe(clickable);
    }
}
