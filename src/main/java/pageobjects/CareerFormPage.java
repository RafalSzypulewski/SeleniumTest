package pageobjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareerFormPage extends BasePage {

    private By submitButton = By.xpath("//input[@value='Jetzt Bewerben']");
    private By validationMessage = By.xpath("//span[text()='Dies ist ein Pflichtfeld.']");
    private By firstNameInput = By.xpath("//input[@placeholder='Vorname*']");
    private By lastNameInput = By.xpath("//input[@placeholder='Nachname*']");
    private By emailInput = By.xpath("//input[@placeholder='Email*']");
    private By checkbox = By.xpath("//input[@placeholder='Vorname*']");
    private By fileUploadInput = By.xpath("//input[@type='file']");
    private By fileNameSpan = By.cssSelector(".file-name");

    public CareerFormPage(WebDriver driver) {
        super(driver);
    }

    public CareerFormPage failedFormSubmit() {
        driver.findElement(submitButton).click();
        return this;
    }

    public Integer countValidationMessage() {
        return driver.findElements(validationMessage).size();
    }

    private boolean isValidationErrorDisplayedForField(By fieldLocator) {
        return driver.findElement(fieldLocator).getAttribute("class").contains("parsley-error");
    }

    public boolean isValidationErrorDisplayedForFirstNameField() {
        return isValidationErrorDisplayedForField(firstNameInput);
    }

    public boolean isValidationErrorDisplayedForLastNameField() {
        return isValidationErrorDisplayedForField(lastNameInput);
    }

    public boolean isValidationErrorDisplayedForEmailField() {
        return isValidationErrorDisplayedForField(emailInput);
    }

    public boolean isValidationErrorDisplayedForCheckbox() {
        return isValidationErrorDisplayedForField(checkbox);
    }

    public void fillInFirstNameField(String text) {
        driver.findElement(firstNameInput).sendKeys(text);
    }

    public void fillInLastNameField(String text) {
        driver.findElement(lastNameInput).sendKeys(text);
    }

    public void fillInEmailField(String text) {
        driver.findElement(emailInput).sendKeys(text);
    }

    public void selectFileToUpload() {
        String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testFile.txt";
        driver.findElement(fileUploadInput).sendKeys(filePath);
    }

    private String getUploadedFileName() {
        return driver.findElement(fileNameSpan).getText();
    }

    public boolean isFileUploaded() {
        return getUploadedFileName().contains("testFile.txt");
    }
}
