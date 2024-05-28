package baseEntities;

import pages.DashboardPage;
import pages.LoginPage;
import pages.TestCasesPage;

public class BaseStep {
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;

    protected TestCasesPage testCasesPage;

    public BaseStep() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        testCasesPage = new TestCasesPage();
    }
}
