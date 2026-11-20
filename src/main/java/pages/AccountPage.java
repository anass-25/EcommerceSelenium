package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {


    private By accountTitle = By.cssSelector("#content h2:first-of-type");

    private By logoutLink = By.linkText("Logout");


    public AccountPage(WebDriver driver) {
        super(driver);
    }



    public boolean isAccountDisplayed() {

        return find(accountTitle).isDisplayed();
    }


    public void logout() {

        click(logoutLink);
    }
}