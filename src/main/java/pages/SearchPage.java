package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage extends BasePage {

    private WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By searchField = By.name("search");
    private By searchButton = By.xpath("//button[@type='button'][contains(@class,'btn-default')]");
    private By macCategory = By.xpath("//*[@id='menu']/div[2]/ul/li[1]/div/div/ul/li[2]/a");

    // Méthodes

    public void search(String product) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        field.clear();
        field.sendKeys(product);
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public void clickMacCategory() {
        click(macCategory);
    }

    public boolean isProductDisplayed(String productName) {
        By productLocator = By.xpath("//h4/a[contains(text(), '" + productName + "')]");
        try {
            WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(productLocator));
            return product.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isWarningDisplayed() {
        By warning = By.xpath("//p[contains(text(),'There is no product that matches the search criteria.')]");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(warning)).isDisplayed();
    }

    public String getWarningMessage() {
        By warning = By.xpath("//p[contains(text(),'There is no product that matches the search criteria.')]");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(warning)).getText();
    }
}