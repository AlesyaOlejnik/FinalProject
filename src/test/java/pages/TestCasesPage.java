package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TestCasesPage implements BasePage {

    public static final By TEST_CASES_PAGE_IDENTIFIER = By.cssSelector(".sc-gbWCTK.vOYjS");
    public static final By IMPORT_BY_XML = By.cssSelector("[data-testid='button-import_trl_xml']");
    public static final By IMPORT_BUTTON = By.cssSelector("[title='Import']");
    public static final By DOWNLOAD_FILE_SELECTOR = By.cssSelector("[type='file']");
    public static final By AFFIRM_BUTTON = By.cssSelector("[data-testid='button-affirm']");
    public static final By EXECUTE_BUTTON = By.cssSelector("[data-testid='button-execute']");
    public static final By SHOW_SUCCESSFUL_IMPORT_TESTCASES = By.cssSelector("[data-testid='text-message']");
    public static final By CHECK_BOX_BUTTON = By.xpath("//tr[@class='table-header-row']//div[@class='sc-kBRnVi eHrERp']//div//*[name()='svg']//*[name()='use' and contains(@href,'#icon-chec')]");
    public static final By DELETE_BUTTON = By.cssSelector("[data-testid='button-delete']");
    public static final By AFFIRM_DELETE_BUTTON = By.cssSelector("[data-testid='button-affirm']");
    public static final By CREATE_TEST_CASE_BUTTON = By.cssSelector("[data-testid='button-add_TC']");
    public static final By CREATE_NEW_TEST_CASE_BUTTON = By.cssSelector("[placeholder='New test case']");
    public static final By SAVE_ENTITY_BUTTON = By.cssSelector("[data-testid='button-save-entity']");
    public static final By SHOW_NOT_VALID_INPUT_MESSAGE = byText("Valid input is required");
    public static final By POPUP_MESSAGE_VISIBLE = By.cssSelector("[data-testid='ValInput_ErrorContainer']");

    @Override
    public By getPageIdentifier() {
        return TEST_CASES_PAGE_IDENTIFIER;
    }

    public void clickImportByXmlButton(){
        $(IMPORT_BY_XML).shouldBe(clickable).click();
    }

    public void clickImportButton(){
        $(IMPORT_BUTTON).shouldBe(clickable).click();
    }
    public void downloadFile(File file){
       $(DOWNLOAD_FILE_SELECTOR).uploadFile(file);
    }
    public void clickAffirmButton(){
        $(AFFIRM_BUTTON).shouldBe(clickable).click();
    }
    public void clickExecuteButton(){
        $(EXECUTE_BUTTON).shouldBe(clickable).click();
    }
    public void importSuccessfulMessage(){
        $(SHOW_SUCCESSFUL_IMPORT_TESTCASES).shouldBe(visible);
    }
    public void selectCheckBox(){
        $(CHECK_BOX_BUTTON).shouldBe(clickable).click();
    }
    public void deleteTestCases(){
        $(DELETE_BUTTON).shouldBe(clickable).click();
    }
    public void affirmDelete(){
        $(AFFIRM_DELETE_BUTTON).shouldBe(clickable).click();
    }
    public void clickCreateTestCase(){
        $(CREATE_TEST_CASE_BUTTON).shouldBe(clickable).click();
    }
    public void createTitleTestCase(String testName){
        $(CREATE_NEW_TEST_CASE_BUTTON).shouldBe(visible).sendKeys(testName);
    }
    public void saveEntity(){
        $(SAVE_ENTITY_BUTTON).shouldBe(clickable).click();
    }
    public void checkSuccessfulCreate(String testName){
        $(byText(testName)).shouldBe(visible);
    }
    public void checkNotValidInputMessage(){
        $(SHOW_NOT_VALID_INPUT_MESSAGE).shouldBe(visible);
    }
    public void checkPopupMessage(){
       $(POPUP_MESSAGE_VISIBLE).shouldBe(visible);
    }
}
