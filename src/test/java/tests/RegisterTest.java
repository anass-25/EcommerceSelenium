package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import utils.ScreenshotUtils;

public class RegisterTest extends BaseTest {

    @Test
    public void registerNewUser() {

        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        homePage.navigateToRegisterPage();

        registerPage.register(
                "John",
                "Smith",
                "john" + System.currentTimeMillis() + "@gmail.com",
                "0612345678",
                "Pass1234"
        );

        ScreenshotUtils.takeScreenshot(driver, "RegisterSuccess");

        System.out.println("URL = " + driver.getCurrentUrl());
        System.out.println("Title = " + driver.getTitle());
        System.out.println("Message = " + registerPage.getSuccessMessage());

        Assert.assertEquals(
                registerPage.getSuccessMessage(),
                "Your Account Has Been Created!"
        );
    }
}