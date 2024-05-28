package baseEntities;

import pages.DashboardPage;
import pages.LoginPage;
import pages.SettingsPage;
import pages.TestCasesPage;

public class BaseStep {
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected TestCasesPage testCasesPage;
    protected SettingsPage settingsPage;

    public BaseStep() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        testCasesPage = new TestCasesPage();
        settingsPage = new SettingsPage();
    }
}
