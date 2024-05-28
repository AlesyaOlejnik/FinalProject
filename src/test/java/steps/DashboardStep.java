package steps;

import baseEntities.BaseStep;
import pages.SettingsPage;
import pages.TestCasesPage;

public class DashboardStep extends BaseStep {

    public TestCasesPage goToTestCasesPage() {
        dashboardPage.clickTestCaseButton();
        return testCasesPage;
    }

    public SettingsPage goToProjectSettingsPage() {
        dashboardPage.clickAccountDropdownButton();
        dashboardPage.clickProjectSettingsButton();
        return settingsPage;
    }

}
