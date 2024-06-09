package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TestPlanPage implements BasePage {
    private static final By CREATE_TEST_PLAN_BUTTON = By.cssSelector("[data-testid ='button-add']");
    private static final By CREATE_TEST_PLAN_TITLE_BUTTON = By.cssSelector("[data-testid='textbox-prop-title']");
    private static final By CHECK_TITLE_TEST_PLAN = By.cssSelector("[data-testid='ValInput_ErrorContainer']");

    @Override
    public By getPageIdentifier() {
        return TEST_PLAN_PAGE_IDENTIFIER;
    }
    public void createTestPlan(){
        $(CREATE_TEST_PLAN_BUTTON).shouldBe(clickable).click();
    }
    public void createTestPlanTitle(String testName){
        $(CREATE_TEST_PLAN_TITLE_BUTTON).shouldBe(visible).sendKeys(testName);
    }
    public void checkTestPlanTitleErrorMessage(){
        $(CHECK_TITLE_TEST_PLAN).shouldBe(visible);
    }

    public static final By TEST_PLAN_PAGE_IDENTIFIER = By.cssSelector("div[class='sc-dLNtp sc-eDPFhE eFuerx hYeQWb sc-fsvrPk bmAAke'] h2");
}
