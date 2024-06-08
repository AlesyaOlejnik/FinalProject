package tests.gui;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NegativeUITests extends BaseTest {

    @Test
    @Description("Тест на вход с некорректными логином")
    public void checkIncorrectDataMessage() {
        loginStep.unsuccessfulLogin();
    }

    @Test
    @Description("Тест на ввод данных, превышающих допустимый лимит")
    public void exceedDataLimit() throws IOException {
        loginStep.successfulLogin(ReadProperties.getUserName(),ReadProperties.getPassword());
        dashboardStep.goToTestPlanPage();
        String testName = getTestNameFromFile();
        testPlanStep.createTestPlan(testName);
    }

    @Test
    @Description("Тест на воспроизводящий любой дефект")
    public void failedTest(){
        loginStep.successfulLogin(ReadProperties.getUserName(),ReadProperties.getPassword());
        $("[there-is-no-selector='like-this]").shouldBe(visible);
    }
}
