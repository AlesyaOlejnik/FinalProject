package baseEntities;

import pages.DashboardPage;
import pages.LoginPage;
import pages.SettingsPage;

public class BaseSteps {
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;

    public BaseSteps() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
    }
}
