package steps;

import baseEntities.BaseStep;

import java.io.File;

public class TestCasesStep extends BaseStep {

    public void downloadFile(File file){
        testCasesPage.clickImportButton();
        testCasesPage.clickImportByXmlButton();
        testCasesPage.downloadFile(file);
        testCasesPage.clickAffirmButton();
        testCasesPage.clickExecuteButton();
        testCasesPage.importSuccessfulMessage();
        testCasesPage.selectCheckBox();
        testCasesPage.deleteTestCases();
        testCasesPage.affirmDelete();
    }

}
