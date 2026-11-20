package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private By cartTotal = By.id("cart-total");

    public boolean isProductDisplayedInCart(String productName) {
        By productLocator = By.xpath("//td[@class='text-left']/a[contains(text(), '" + productName + "')]");
        return isDisplayed(productLocator);
    }

    public void deleteProductFromCart(String productName) {
        By deleteButtonLocator = By.xpath("//td[@class='text-left']/a[contains(text(), '" + productName + "')]/ancestor::tr//button[@data-original-title='Remove']");
        click(deleteButtonLocator);
    }

    public String getCartTotal() {
        return getText(cartTotal);
    }

}
