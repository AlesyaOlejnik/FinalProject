package tests.gui;

import baseEntities.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.DashboardStep;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class UITests extends BaseTest {

    @BeforeMethod
    @Override
    public void setupBrowser() {
        super.setupBrowser();
        loginStep.successfulLogin(ReadProperties.getUserName(), ReadProperties.getPassword());
    }

    @Test //TODO переписать с использованием  PageObject
    public void checkInputField() throws IOException {
        Selenide.open("/testcases");
        $(byText("Create a test case")).shouldBe(Condition.clickable).click();
        String fileName = "more_than_200_symbols.txt";
        String content = getStringFromFile(fileName);
        $("[data-testid='textbox-prop-title']").shouldBe(visible).sendKeys(content);
        $(byText("Valid input is required")).shouldBe(visible);
    }

    @Test //TODO переписать с использованием  PageObject
    public void createEntity() {
        Selenide.open("/testcases");
        $("[data-testid='button-add']").shouldBe(clickable).click();
        String testName = UUID.randomUUID().toString();
        $("[placeholder='New test case']").shouldBe(visible).sendKeys(testName);
        $("[data-testid='button-save-entity']").shouldBe(clickable).click();
        $(byText(testName)).shouldBe(visible);
    }

    @Test
    public void uploadFile() {
        new DashboardStep().goToTestCasesPage();
        File file = new File("src/test/resources/upload.csv");
        testCasesStep.downloadFile(file);
    }

    private String getStringFromFile(String fileName) throws IOException {
        URL url = this.getClass()
                .getClassLoader()
                .getResource(fileName);
        File file = new File(url.getFile());
        return new String(Files.readAllBytes(file.toPath()));
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
