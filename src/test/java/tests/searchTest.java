package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.SearchPage;
import utils.ScreenshotUtils;

public class searchTest extends BaseTest {

    @Test
    public void searchProduct() {

        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        homePage.navigateToRegisterPage();
        String email = "user" + System.currentTimeMillis() + "@gmail.com";
        registerPage.register("John", "Smith", email, "0612345678", "Pass1234");
        homePage.logout();
        homePage.navigateToLoginPage();
        loginPage.login(email, "Pass1234");
        homePage.openSearchPage();
        searchPage.search("iMac");
        searchPage.clickSearchButton();
        ScreenshotUtils.takeScreenshot(driver, "searchResults");

        boolean isDisplayed = searchPage.isProductDisplayed("iMac");
        if (!isDisplayed) {
            ScreenshotUtils.takeScreenshot(driver, "searchProduct_FAILED");
        }
        Assert.assertTrue(isDisplayed, "Le produit iMac n'est pas affiché.");
    }
}