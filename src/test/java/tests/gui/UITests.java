package tests.gui;

import baseEntities.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import configuration.ReadProperties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.DashboardStep;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.UUID;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

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
}
