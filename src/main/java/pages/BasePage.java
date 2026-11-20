package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;


    // Constructor
    public BasePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    // Trouver un élément
    protected WebElement find(By locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    // Cliquer
    protected void click(By locator) {

        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }


    // Écrire
    protected void sendKeys(By locator, String text) {

        WebElement element = find(locator);

        element.clear();

        element.sendKeys(text);
    }


    // Type
    protected String type(By locator, String text) {

        WebElement inputField = find(locator);

        inputField.clear();

        inputField.sendKeys(text);

        return inputField.getAttribute("value");
    }


    // Vérifier si affiché
    protected boolean isDisplayed(By locator) {

        return find(locator).isDisplayed();
    }


    // Récupérer le texte
    protected String getText(By locator) {

        return find(locator).getText();
    }
}