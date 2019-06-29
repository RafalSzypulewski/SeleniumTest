package pageobjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {



    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage load() {
        driver.get(config.getProperty("environment.url"));
        return this;
    }
}
