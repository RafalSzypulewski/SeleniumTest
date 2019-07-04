package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.util.Properties;

public class BasePage {

    protected Properties config;
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected Integer defaultWaitTime = 10;

    public BasePage(WebDriver driver) {
        config = new Properties();
        try {
            config.load(new FileInputStream("src\\main\\resources\\config.properties"));
        } catch (Exception eta) {
            eta.printStackTrace();
        }
        this.driver = driver;
        wait = new WebDriverWait(driver, defaultWaitTime);
    }

    public String getPageBody() {
        return driver.findElement(By.tagName("body")).getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
