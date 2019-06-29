package pageobjects;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public class ContactPage extends BasePage {

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public ContactPage load() {
        driver.get(config.getProperty("environment.url"));
        return this;
    }
}
