package baseEntities;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.testng.SoftAsserts;
import configuration.ReadProperties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.closeWebDriver;

@Listeners({SoftAsserts.class})
public class BaseTest {

    @BeforeSuite
    public void setupSuite() {
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.headless = ReadProperties.isHeadless();
        Configuration.browser = ReadProperties.browserName();
        //Configuration.pageLoadTimeout = ReadProperties.pageLoadTimeout() * 1000;
        Configuration.timeout = ReadProperties.getTimeout() * 1000;
        Configuration.assertionMode = AssertionMode.SOFT;
        Configuration.fastSetValue = true;
    }

    @BeforeMethod
    public void setupBrowser() {
        open("/");
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
