package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.ScreenshotUtils;

public class LoginInvalidTest extends BaseTest {

    @Test
    public void loginWithInvalidCredentials() {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.navigateToLoginPage();

        loginPage.login(
                "wrongemail@test.com",
                "wrongpassword"
        );

        ScreenshotUtils.takeScreenshot(driver, "LoginFailed");

        Assert.assertTrue(
                loginPage.getWarningMessage()
                        .contains("Warning: No match for E-Mail Address and/or Password.")
        );

    }
}
