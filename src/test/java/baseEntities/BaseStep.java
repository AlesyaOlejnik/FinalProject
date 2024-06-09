package baseEntities;

import pages.DashboardPage;
import pages.LoginPage;
import pages.TestCasesPage;
import pages.SettingsPage;
import pages.TestPlanPage;
import pages.ProjectPage;

public class BaseStep {
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected TestCasesPage testCasesPage;
    protected TestPlanPage testPlanPage;
    protected SettingsPage settingsPage;
    protected ProjectPage projectPage;

    public BaseStep() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        testCasesPage = new TestCasesPage();
        settingsPage = new SettingsPage();
        projectPage = new ProjectPage();
        testPlanPage = new TestPlanPage();
    }
}
