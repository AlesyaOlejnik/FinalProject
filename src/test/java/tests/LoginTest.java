package tests;

import baseEntities.BaseTest;
import com.codeborne.selenide.Condition;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.NavigationSteps;

import static com.codeborne.selenide.Condition.visible;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest(){
        NavigationSteps navigationSteps = new NavigationSteps();

        Assert.assertTrue(
                navigationSteps
                        .successfulLogin(ReadProperties.getUserName(), ReadProperties.getPassword())
                        .getSkipButton().shouldBe(visible).isDisplayed());
    }
}
