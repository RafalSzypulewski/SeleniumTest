import base.BaseGui;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.*;


public class Tests extends BaseGui {

    private MainPage mainPage;
    private NavigationMenu navigationMenu;
    private ContactPage contactPage;
    private WamTestingPage wamTestingPage;
    private CareerPage careerPage;
    private CareerFormPage careerFormPage;

    @BeforeMethod
    public void setup() {
        mainPage = new MainPage(driver);
        navigationMenu = new NavigationMenu(driver);
        contactPage = new ContactPage(driver);
        wamTestingPage = new WamTestingPage(driver);
        careerPage = new CareerPage(driver);
        careerFormPage = new CareerFormPage(driver);
    }


    @Test
    public void firstTest() {
        navigationMenu.goToContactPage();
        Assert.assertTrue(contactPage.getPageBody().contains("hello@qualityminds.de"));
        String stepTwoUrl = contactPage.getCurrentUrl();
        navigationMenu.goToMainPage();
        mainPage.goToContactPageUsingFooterLink();
        Assert.assertEquals(stepTwoUrl, contactPage.getCurrentUrl());
    }

    @Test
    public void secondTest() {
        navigationMenu.clickWebAutomationMobileButton();
        Assert.assertTrue(navigationMenu.isPortfolioButtonHighlighed());
        wamTestingPage.clickMobileButton();
        Assert.assertTrue(wamTestingPage.isMobileButtonUnderlined());
        Assert.assertEquals(wamTestingPage.getDownloadLink(),
                "https://qualityminds.de/app/uploads/2018/11/Find-The-Mobile-Bug-Session.pdf");
        //TODO fix download file so there is no need for thread sleep
        wamTestingPage.downloadFile();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(wamTestingPage.wasFileDownloaded("FLYER FIND THE BUG SESSION"));

    }

    @Test
    public void thirdTest() {
        navigationMenu.goToCareerPage();
        careerPage.goToCareerForm();
        Assert.assertTrue(careerFormPage.countValidationMessage() == 0);
        careerFormPage.failedFormSubmit();
        //check if 4 validation messages are being displayed, not 3, but 4 (3 for text fields and 1 for checkbox)
        Assert.assertTrue(careerFormPage.countValidationMessage() == 4);
        Assert.assertTrue(careerFormPage.isValidationErrorDisplayedForFirstNameField());
        Assert.assertTrue(careerFormPage.isValidationErrorDisplayedForLastNameField());
        Assert.assertTrue(careerFormPage.isValidationErrorDisplayedForEmailField());
        Assert.assertTrue(careerFormPage.isValidationErrorDisplayedForCheckbox());
        careerFormPage.fillInFirstNameField("testFirstName");
        careerFormPage.fillInLastNameField("testLastName");
        Assert.assertFalse(careerFormPage.isValidationErrorDisplayedForFirstNameField());
        Assert.assertFalse(careerFormPage.isValidationErrorDisplayedForLastNameField());
        careerFormPage.fillInEmailField("invalidEmail");
        careerFormPage.failedFormSubmit();
        careerFormPage.selectFileToUpload();
        Assert.assertTrue(careerFormPage.isFileUploaded());
    }
}
