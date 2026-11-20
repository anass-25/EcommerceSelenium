package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddProduct;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import utils.ScreenshotUtils;

public class AddTwoProductTest extends BaseTest {

    @Test
    public void addTwoProductsToCart() {

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
        addProduct.setSearchField("MacBook Pro");
        Assert.assertTrue(addProduct.isProductdisplayed("MacBook Pro"), "MacBook Pro n'est pas affiché");
        addProduct.AddProductToCart("MacBook Pro");
        Assert.assertTrue(addProduct.waitForCartItemCount(2), "MacBook Pro n'a pas été ajouté au panier");
        String cartTotal = addProduct.getTotalPrice();
        System.out.println("PANIER FINAL = " + cartTotal);
        Assert.assertTrue(cartTotal.contains("2 item(s)"), "Le panier devrait contenir 2 produits");
        addProduct.deleteProductFromCart("iMac");
        Assert.assertTrue(addProduct.waitForCartItemCount(1), "iMac n'a pas été supprimé du panier");
        String cartTotalAfterDeletion = addProduct.getTotalPrice();
        System.out.println("PANIER APRES SUPPRESSION = " + cartTotalAfterDeletion);
        Assert.assertTrue(cartTotalAfterDeletion.contains("1 item(s)"), "Le panier devrait contenir 1 produit après suppression");
        addProduct.deleteProductFromCart("MacBook Pro");
        Assert.assertTrue(addProduct.waitForCartItemCount(0), "MacBook Pro n'a pas été supprimé du panier");
        String cartTotalAfterAllDeletion = addProduct.getTotalPrice();
        System.out.println("PANIER APRES SUPPRESSION DE TOUS LES PRODUITS = " + cartTotalAfterAllDeletion);
        Assert.assertTrue(cartTotalAfterAllDeletion.contains("0 item(s)"), "Le panier devrait être vide après suppression de tous les produits");
        ScreenshotUtils.takeScreenshot(driver, "AddedTwoProductsToCart");
    }
}