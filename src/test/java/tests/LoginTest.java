package tests;

import baseEntities.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.testng.SoftAsserts;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import steps.NavigationSteps;

import static com.codeborne.selenide.Condition.visible;

@Listeners({SoftAsserts.class})
public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest(){
        NavigationSteps navigationSteps = new NavigationSteps();

                navigationSteps
                        .successfulLogin(ReadProperties.getUserName(), ReadProperties.getPassword())
                        .getSkipButton().shouldBe(visible);
    }
}
