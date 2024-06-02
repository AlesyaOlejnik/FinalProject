package steps;

import baseEntities.BaseStep;
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

}
