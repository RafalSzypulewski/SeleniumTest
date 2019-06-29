package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import pageobjects.MainPage;

import java.util.HashMap;

public abstract class BaseGui {
    protected WebDriver driver;
    //private String browser = "firefox";

    @Parameters("browser")
    @BeforeMethod
    public void baseSetup(@Optional("chrome75") String browser) {
        if (browser.equals("chrome75")) {
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", System.getProperty("user.dir"));

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", chromePrefs);
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver75.exe");
            driver = new ChromeDriver(options);
        } else if (browser.equals("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference ("browser.download.folderList", 2);
            options.addPreference("browser.download.dir", System.getProperty("user.dir"));
            options.addPreference("pdfjs.disabled", true);
            options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
            System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver(options);
        }

        driver.manage().window().maximize();
        new MainPage(driver).load();
    }

    @AfterMethod
    public void teardown() {
        // driver.quit();
        driver.close();
    }
}
