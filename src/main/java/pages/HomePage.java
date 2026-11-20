
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By myAccount =
            By.cssSelector("#top-links a[title='My Account']");

    private final By register = By.linkText("Register");
    private final By login = By.linkText("Login");
    private final By logout = By.linkText("Logout");

    // Aller directement à la page Register
    public void navigateToRegisterPage() {
        driver.get(
                "https://tutorialsninja.com/demo/index.php?route=account/register"
        );
    }

    // Aller directement à la page Login
    public void navigateToLoginPage() {
        driver.get(
                "https://tutorialsninja.com/demo/index.php?route=account/login"
        );
    }

    // Déconnexion
    public void logout() {
        click(myAccount);
        click(logout);
    }

    // Aller à la page Search
    public void openSearchPage() {
        driver.get(
                "https://tutorialsninja.com/demo/index.php?route=product/search"
        );
    }
}
