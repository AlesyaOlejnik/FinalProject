package steps;

import baseEntities.BaseStep;
import pages.DashboardPage;

public class LoginStep extends BaseStep {

    public DashboardPage successfulLogin(String username, String password) {
        return loginPage.successfulLogin(username, password);
    }

}
