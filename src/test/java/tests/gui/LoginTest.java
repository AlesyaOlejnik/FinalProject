package tests.gui;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.annotations.Test;
import steps.NavigationSteps;


public class LoginTest extends BaseTest {

    @Test
    public void successfulLoginTest() {
        NavigationSteps navigationSteps = new NavigationSteps();
                navigationSteps
                        .successfulLogin(ReadProperties.getUserName(), ReadProperties.getPassword())
                        .getToolbarButton().isDisplayed();
    }

}
