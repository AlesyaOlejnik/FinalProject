package baseEntities;

import pages.*;

public class BaseStep {
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected TestCasesPage testCasesPage;
    protected SettingsPage settingsPage;
    protected ProjectPage projectPage;

    public BaseStep() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        testCasesPage = new TestCasesPage();
        settingsPage = new SettingsPage();
        projectPage = new ProjectPage();
    }
}
