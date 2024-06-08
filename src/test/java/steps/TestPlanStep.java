package steps;

import baseEntities.BaseStep;

public class TestPlanStep extends BaseStep {
  public void createTestPlan(String testName){
      testPlanPage.createTestPlan();
      testPlanPage.createTestPlanTitle(testName);
      testPlanPage.checkTestPlanTitleErrorMessage();
  }
}
