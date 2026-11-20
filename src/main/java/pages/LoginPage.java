package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By email = By.id("input-email");
    private By password = By.id("input-password");
    private By loginButton = By.cssSelector("input[value='Login']");
    private By warningMessage = By.cssSelector(".alert-danger");

    // Actions
    public void enterEmail(String value) {
        sendKeys(email, value);
    }

    public void enterPassword(String value) {
        sendKeys(password, value);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void login(String mail, String pass) {

        enterEmail(mail);
        enterPassword(pass);
        clickLogin();

    }

    public String getWarningMessage() {

        return find(warningMessage).getText();

    }
}
