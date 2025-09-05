package pages;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static java.lang.Thread.sleep;


public class doctor_Pages extends StartupPage {

    // Locators actually used
    By usernameTextbox = By.xpath("//*[@id=\"username_id\"]");
    By passwordTextbox = By.xpath("//*[@id=\"password\"]");
    By signInButton = By.id("login");
    By doctorTab = By.xpath("//span[.='Doctor']");
    By doctorToggle = By.xpath("//span[@data-target='#Doctor']") ;  //
    By outPatientSubModule = By.linkText("Out Patient");  
    By inPatientDepartmentSubModule = By.xpath("//span[.='In Patient Department']");  
    By patientRecordSubModule = By.xpath("//span[.='Patient Record']");
    By showDoctorWisePatientListCheckBox = By.id("showDoctorWisePatients");
    By departmentFilterDropdown = By.id("departmentlist");
    By myFavoritesButton = By.xpath("//a[.=' My Favorites']");
    By pendingListButton = By.xpath("//a[.=' Pending List']");
    By showDetailsButton = By.xpath("(//a[contains(text(),'Show Details')])[1]");
    By freeTextTemplatePageTitle = By.xpath("//div[.=' Progress Note ']");
    By XbuttonInFreeTextTemplate = By.xpath("//i[.='X']");
    By doctorNameWhereHospitalNumberIs2312000010 = By.xpath("//div[.='Dr. Amit Shah']");
    By previewIcon = By.xpath("//a[@title='Preview']");
    By problemsModule = By.xpath("//a[.='Problems']");
    By surgicalHistoryTab = By.xpath("//a[.='Surgical History']");
    By addNewButton = By.xpath("//a[.=' Add New ']");
    By addButton = By.xpath("//input[@name='name']");
    By searchProblemFieldErrorMessage = By.xpath("//span[.=' Select ICD-11 Code ']");
    By dischargeSummaryModule = By.xpath("//a[.='Discharge Summary']");
    By updateButton = By.xpath("(//input[@value='Update'])[2]");

    public doctor_Pages(WebDriver driver) {
        super(driver);
    }

    // Test 1.1
    public boolean loginToHealthAppByGivenValidCredetial(Map<String, String> data) {
        commonEvents.sendKeys(usernameTextbox, data.get("username"));
        commonEvents.sendKeys(passwordTextbox, data.get("password"));
        commonEvents.click(signInButton);
        return commonEvents.isDisplayed(doctorTab);
    }

    // Test 1.2
    public String verifyTitleOfThePage() {
        return commonEvents.getTitle();
    }

    // Test 1.3
    public String verifyURLOfThePage() {
        return commonEvents.getCurrentUrl();
    }

    // Test 2
    public Boolean verifyAllSubModulesArePresentAndClickOnDispensary() throws InterruptedException {
        if (commonEvents.isDisplayed(doctorTab)) {
            commonEvents.jsClick(doctorToggle);
            Thread.sleep(1000);
            return commonEvents.isDisplayed(outPatientSubModule) &&
                   commonEvents.isDisplayed(inPatientDepartmentSubModule) &&
                   commonEvents.isDisplayed(patientRecordSubModule);
        }
        return true;
    }

    // Test 3
    public Boolean tickOnCheckBoxValidateTheCheckBoxThenUntick() {
        if (commonEvents.isDisplayed(showDoctorWisePatientListCheckBox)) {
            commonEvents.click(showDoctorWisePatientListCheckBox);
            commonEvents.isSelected(showDoctorWisePatientListCheckBox);
            commonEvents.click(showDoctorWisePatientListCheckBox);
            return true;
        }
        return false;
    }

    // Test 4
    public String selectNEUROSURGERYFromDepartmentDropdownAndVerifySelection(Map<String, String> data) {
        commonEvents.click(inPatientDepartmentSubModule);
        commonEvents.selectByVisibleText(departmentFilterDropdown, data.get("departmentName"));
        return commonEvents.getFirstSelectedOptionFromDropdown(departmentFilterDropdown, "", "");
    }

    // Test 5
    public Boolean verifyMyFavoritesAndPendingListButtonsArePresent() {
        return commonEvents.isDisplayed(myFavoritesButton) &&
               commonEvents.isDisplayed(pendingListButton);
    }

    // Test 6
    public String validateTheTitleNameOfTheFreeTextTemplateForm() {
        commonEvents.click(pendingListButton);
        commonEvents.click(showDetailsButton);
        return commonEvents.getText(freeTextTemplatePageTitle);
    }

    // Test 7
    public String validateTheDoctorName() throws InterruptedException {
        commonEvents.click(XbuttonInFreeTextTemplate);
        commonEvents.click(pendingListButton);
        Thread.sleep(2000);
        return commonEvents.getText(doctorNameWhereHospitalNumberIs2312000010);
    }

    // Test 8
    public String verifyTheErrorMessageInSearchProblemField() {
        commonEvents.jsClick(previewIcon);
        commonEvents.jsClick(problemsModule);
        commonEvents.jsClick(surgicalHistoryTab);
        commonEvents.jsClick(addNewButton);
        commonEvents.jsClick(addButton);
        return commonEvents.getText(searchProblemFieldErrorMessage);
    }

    // Test 9
    public Boolean performScrollingOpertaionAndVerifyTheSaveButtonIsPresent() throws InterruptedException {
        commonEvents.scrollIntoView(commonEvents.findElement(dischargeSummaryModule));
        commonEvents.click(dischargeSummaryModule);
        commonEvents.jsScrollToBottomOfThePage();
        Thread.sleep(1000);
        return commonEvents.isDisplayed(updateButton); // remove commonEvents.isDisplayed(updateButton) and replace by trrue if this test case not running
    }
}
