package steps;

import baseEntities.BaseStep;
import pages.SettingsPage;
import pages.TestCasesPage;
import pages.TestPlanPage;

public class DashboardStep extends BaseStep {

    public TestCasesPage goToTestCasesPage() {
        dashboardPage.clickTestCaseButton();
        return testCasesPage;
    }
    public TestPlanPage goToTestPlanPage() {
        dashboardPage.clickTestPlanButton();
        return testPlanPage;
    }

    public SettingsPage goToProjectSettingsPage() {
        dashboardPage.clickAccountDropdownButton();
        dashboardPage.clickProjectSettingsButton();
        return settingsPage;
    }

}
