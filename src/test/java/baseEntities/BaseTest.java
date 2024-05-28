package baseEntities;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.SoftAsserts;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Listeners;
import steps.DashboardStep;
import steps.LoginStep;
import steps.TestCasesStep;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.closeWebDriver;

@Listeners({SoftAsserts.class})
public class BaseTest {

    protected LoginStep loginStep;

    protected DashboardStep dashboardStep;

    protected TestCasesStep testCasesStep;

    public BaseTest() {
        this.loginStep = new LoginStep();
        this.dashboardStep = new DashboardStep();
        this.testCasesStep = new TestCasesStep();
    }

    @BeforeSuite
    public void setupSuite() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.headless = ReadProperties.isHeadless();
        Configuration.browser = ReadProperties.browserName();
        Configuration.browserSize = "1920x1080";
        //Configuration.pageLoadTimeout = ReadProperties.pageLoadTimeout() * 1000;
        Configuration.timeout = ReadProperties.getTimeout() * 1000L;
        Configuration.assertionMode = AssertionMode.SOFT;
        Configuration.fastSetValue = true;
    }

    @BeforeMethod
    public void setupBrowser() {
        open("/");
    }

}
