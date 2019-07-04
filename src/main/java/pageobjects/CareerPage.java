package pageobjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareerPage extends BasePage {

    private By buttonToCareerForm = By.xpath("//a[text()='Bewirb dich jetzt!']");

    public CareerPage(WebDriver driver) {
        super(driver);
    }

    public CareerFormPage goToCareerForm() {
        driver.findElement(buttonToCareerForm).click();
        return new CareerFormPage(driver);
    }

}
