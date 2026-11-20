package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ScreenshotUtils;

public class LoginValidTest extends BaseTest {

    @Test
    public void loginWithValidCredentials() {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);

        // Navigate to Login Page
        homePage.navigateToLoginPage();

        // Login
        loginPage.login(
                "testemail@yopmail.com",
                "pass@123"
        );

        // Screenshot
        ScreenshotUtils.takeScreenshot(driver, "LoginSuccess");

        // Verification
        Assert.assertTrue(accountPage.isAccountDisplayed());

    }



}
