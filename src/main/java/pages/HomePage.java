package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {



    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By myAccount = By.xpath("//span[text()='My Account']");
    private By register = By.linkText("Register");
    private By login = By.linkText("Login");
    private By logout = By.linkText("Logout");

    public void navigateToRegisterPage() {
        click(myAccount);
        click(register);
    }

    public void navigateToLoginPage() {
        click(myAccount);
        click(login);
    }

    public void logout() {
        click(myAccount);
        click(logout);
    }

    public void openSearchPage() {

        driver.get("https://tutorialsninja.com/demo/index.php?route=product/search");
    }
}