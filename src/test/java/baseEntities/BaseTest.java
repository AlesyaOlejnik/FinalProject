package baseEntities;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.SoftAsserts;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.PageLoadStrategy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Listeners;
import steps.DashboardStep;
import steps.LoginStep;
import steps.ProjectStep;
import steps.TestCasesStep;
import steps.TestPlanStep;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

import static com.codeborne.selenide.Selenide.open;

@Listeners({SoftAsserts.class})
public class BaseTest {

    protected LoginStep loginStep;
    protected DashboardStep dashboardStep;
    protected TestCasesStep testCasesStep;
    protected ProjectStep projectSteps;
    protected TestPlanStep testPlanStep;

    public BaseTest() {
        this.loginStep = new LoginStep();
        this.dashboardStep = new DashboardStep();
        this.testCasesStep = new TestCasesStep();
        this.testPlanStep = new TestPlanStep();
        this.projectSteps = new ProjectStep();
    }

    @BeforeSuite
    public void setupSuite() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.headless = ReadProperties.isHeadless();
        Configuration.browser = ReadProperties.browserName();
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = ReadProperties.getTimeout() * 1000L;
        Configuration.assertionMode = AssertionMode.SOFT;
        Configuration.fastSetValue = true;
    }

    @BeforeMethod
    public void setupBrowser() {
        open("/");
    }

    private String getStringFromFile(String fileName) throws IOException {
        URL url = this.getClass()
                .getClassLoader()
                .getResource(fileName);
        File file = new File(url.getFile());
        return new String(Files.readAllBytes(file.toPath()));
    }

    protected String getTestNameFromFile() throws IOException {
        String fileName = "more_than_200_symbols.txt";
        return getStringFromFile(fileName);
    }
}
