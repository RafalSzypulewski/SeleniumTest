package pageobjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class WamTestingPage extends BasePage {

    private By mobileButton = By.xpath("//div[text()='Mobile']");
    private By mobileButtonUnderlined = By.xpath("//div[text()='Mobile']/parent::div/parent::div[not(contains(@class, 'inactive-team-tab'))]");
    private By downloadButton = By.xpath("//a[text()='Flyer Find the Bug Session']");

    public WamTestingPage(WebDriver driver) {
        super(driver);
    }

    public WamTestingPage clickMobileButton() {
        driver.findElement(mobileButton).click();
        return new WamTestingPage(driver);
    }

    public boolean isMobileButtonUnderlined() {
        return driver.findElements(mobileButtonUnderlined).size() > 0;
    }

    public String getDownloadLink() {
        return driver.findElement(downloadButton).getAttribute("href");
    }

    public void downloadFile() {
        driver.findElement(downloadButton).click();
    }

    public boolean wasFileDownloaded(String downloadLink) {
        File folder = new File(System.getProperty("user.dir"));

        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.contains(downloadLink)) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }
        f.deleteOnExit();
        return found;
    }

}
