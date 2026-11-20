package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By firstName = By.id("input-firstname");
    private By lastName = By.id("input-lastname");
    private By email = By.id("input-email");
    private By telephone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By confirmPassword = By.id("input-confirm");
    private By privacyPolicy = By.name("agree");
    private By continueButton = By.cssSelector("input[value='Continue']");

    // Message de succès
    private By successMessage = By.cssSelector("#content h1");

    public void enterFirstName(String value) {
        sendKeys(firstName, value);
    }

    public void enterLastName(String value) {
        sendKeys(lastName, value);
    }

    public void enterEmail(String value) {
        sendKeys(email, value);
    }

    public void enterTelephone(String value) {
        sendKeys(telephone, value);
    }

    public void enterPassword(String value) {
        sendKeys(password, value);
    }

    public void confirmPassword(String value) {
        sendKeys(confirmPassword, value);
    }

    public void acceptPrivacyPolicy() {
        click(privacyPolicy);
    }

    public void clickContinue() {
        click(continueButton);
    }

    public String getSuccessMessage() {
        return find(successMessage).getText();
    }

    public void register(String first,
                         String last,
                         String mail,
                         String phone,
                         String pass) {

        enterFirstName(first);
        enterLastName(last);
        enterEmail(mail);
        enterTelephone(phone);
        enterPassword(pass);
        confirmPassword(pass);
        acceptPrivacyPolicy();
        clickContinue();
    }
}