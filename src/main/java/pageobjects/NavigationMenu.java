package pageobjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationMenu extends BasePage {

    private By mainPageButton = By.cssSelector(".logo_container > a");
    private By contactButton = By.xpath("//a[text()='Kontakt']");
    private By portfolioButton = By.xpath("//a[text()='Portfolio']");
    private By webAutomationMobileButton = By.xpath("//a[text()='Web, Automation & Mobile Testing']");
    private By portfolioHighlightedButton = By.xpath("//a[text()='Portfolio']/parent::li[contains(@class, 'current-menu-ancestor')]");
    private By careerButton = By.xpath("//a[text()='Karriere']");

    public NavigationMenu(WebDriver driver) {
        super(driver);
    }


    public ContactPage goToContactPage() {
        driver.findElement(contactButton).click();
        return new ContactPage(driver);
    }

    public MainPage goToMainPage() {
        driver.findElement(mainPageButton).click();
        return new MainPage(driver);
    }

    public CareerPage goToCareerPage() {
        driver.findElement(careerButton).click();
        return new CareerPage(driver);
    }

    public WamTestingPage clickWebAutomationMobileButton() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(portfolioButton))
                .moveToElement(driver.findElement(webAutomationMobileButton))
                .click().build().perform();

        return new WamTestingPage(driver);
    }

    public boolean isPortfolioButtonHighlighed() {
        wait.until(ExpectedConditions.presenceOfElementLocated(portfolioHighlightedButton));
        System.out.println(driver.findElements(portfolioHighlightedButton).size());
        return driver.findElements(portfolioHighlightedButton).size() > 0;
    }
}
