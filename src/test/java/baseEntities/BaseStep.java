package baseEntities;

import pages.DashboardPage;
import pages.LoginPage;
import pages.TestCasesPage;
import pages.TestPlanPage;

public class BaseStep {
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;

    protected TestCasesPage testCasesPage;
    protected TestPlanPage testPlanPage;

    public BaseStep() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        testCasesPage = new TestCasesPage();
        testPlanPage = new TestPlanPage();
    }
}
