package pageobjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationMenu extends BasePage {

    private By menuButton=By.id("et_mobile_nav_menu");
    private By contactButton=By.linkText("Kontakt");

    public NavigationMenu(WebDriver driver) {
        super(driver);
    }

    public NavigationMenu expandMenu(){
        driver.findElement(menuButton).click();
        return this;
    }

    public ContactPage clickContactButton(){
        driver.findElement(contactButton).click();
        return new ContactPage(driver);
    }

    public ContactPage goToContactPage(){
        expandMenu().clickContactButton();
    }

}
