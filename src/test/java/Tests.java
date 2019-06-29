import base.BaseGui;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.ContactPage;
import pageobjects.MainPage;
import pageobjects.NavigationMenu;
import pageobjects.WamTestingPage;

import static java.lang.Thread.sleep;


public class Tests extends BaseGui {

    private MainPage mainPage;
    private NavigationMenu navigationMenu;
    private ContactPage contactPage;
private WamTestingPage wamTestingPage;
    @BeforeMethod
    public void setup() {
        System.out.println("SETUP");
        mainPage = new MainPage(driver);
        navigationMenu = new NavigationMenu(driver);
        contactPage = new ContactPage(driver);
        wamTestingPage=new WamTestingPage(driver);
    }


    @Test
    public void firstTest() {
        System.out.println("FIRST TEST");
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

}
