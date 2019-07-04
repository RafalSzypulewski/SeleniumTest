package pageobjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    private By contactButtonFooter = By.xpath("//ul[@id='menu-footer-menu']/li/a[text()='Kontakt & Anfahrt']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage load() {
        driver.get(config.getProperty("environment.url"));
        return this;
    }

    public ContactPage goToContactPageUsingFooterLink() {
        return clickContactButtonFooter();
    }

    public ContactPage clickContactButtonFooter() {
        driver.findElement(contactButtonFooter).click();
        return new ContactPage(driver);
    }
}
