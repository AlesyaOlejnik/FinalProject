package steps;

import baseEntities.BaseSteps;
import pages.DashboardPage;


public class NavigationSteps extends BaseSteps {

    public DashboardPage successfulLogin(String username, String password) {
        return loginPage.successfulLogin(username, password);
    }
}
