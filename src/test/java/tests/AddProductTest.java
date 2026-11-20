package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddProduct;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import utils.ScreenshotUtils;

public class AddProductTest extends BaseTest {
     @Test
    public void addProductToCart() {
         HomePage homePage = new HomePage(driver);
         RegisterPage registerPage = new RegisterPage(driver);
         LoginPage loginPage = new LoginPage(driver);
         AddProduct addProduct = new AddProduct(driver);
         homePage.navigateToRegisterPage();
         String email = "user" + System.currentTimeMillis() + "@gmail.com";
         registerPage.register("John", "Smith", email, "0612345678", "Pass1234");
         homePage.logout();
         homePage.navigateToLoginPage();
         loginPage.login(email, "Pass1234");
         homePage.openSearchPage();
         addProduct.setSearchField("iMac");
         Assert.assertTrue(addProduct.isProductdisplayed("iMac"), "iMac n'est pas affiché");
         addProduct.AddProductToCart("iMac");
         Assert.assertTrue(addProduct.waitForCartItemCount(1), "iMac n'a pas été ajouté au panier");
         System.out.println("PANIER APRES iMac = " + addProduct.getTotalPrice());
         ScreenshotUtils.takeScreenshot(driver, "AddedTwoProductsToCart");

    }
}
