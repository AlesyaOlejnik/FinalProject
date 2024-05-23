package tests.gui;

import baseEntities.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.UUID;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class UITests extends BaseTest {


    @BeforeMethod
    @Override
    public void setupBrowser() {
        super.setupBrowser();
        new LoginPage().login();
    }

    @Test
    public void checkInputField() throws InterruptedException, IOException {
        Selenide.open("/testcases");
        $(byText("Create a test case")).shouldBe(Condition.clickable).click();
        String fileName = "more_than_200_symbols.txt";
        String content = getStringFromFile(fileName);
        $("[data-testid='textbox-prop-title']").shouldBe(visible).sendKeys(content);
        $(byText("Valid input is required")).shouldBe(visible);
    }

    @Test
    public void createEntity() throws InterruptedException {
        Selenide.open("/testcases");
        $("[data-testid='button-add']").shouldBe(clickable).click();
        String testName = UUID.randomUUID().toString();
        $("[placeholder='New test case']").shouldBe(visible).sendKeys(testName);
        $("[data-testid='button-save-entity']").shouldBe(clickable).click();
        $(byText(testName)).shouldBe(visible);
    }

    private String getStringFromFile(String fileName) throws IOException {
        URL url = this.getClass()
                .getClassLoader()
                .getResource(fileName);
        File file = new File(url.getFile());
        String content = new String(Files.readAllBytes(file.toPath()));
        return content;
    }
}
