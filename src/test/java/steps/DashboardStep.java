package steps;

import baseEntities.BaseStep;
import pages.TestCasesPage;

public class DashboardStep extends BaseStep {

    public TestCasesPage goToTestCasesPage() {
        dashboardPage.clickTestCaseButton();
        return testCasesPage;
    }

}
