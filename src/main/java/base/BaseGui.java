package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageobjects.MainPage;

public abstract class BaseGui {
    protected WebDriver driver;
    //private String browser = "firefox";

    @Parameters("browser")
    @BeforeClass
    public void baseSetup(@Optional("chrome75") String browser) {
        if (browser.equals("chrome76")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver76.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("chrome75")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver75.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        new MainPage(driver).load();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
