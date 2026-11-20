package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddProduct extends BasePage {

    private By searchField = By.name("search");

    private By searchButton = By.xpath("//button[@type='button'][contains(@class,'btn-default')]");

    private By cartTotal = By.id("cart-total");

    public AddProduct(WebDriver driver) {
        super(driver);
    }

    public void setSearchField(String productName) {

        type(searchField, productName);
        click(searchButton);
    }

    public boolean isProductdisplayed(String productName) {

        By productLocator = By.xpath("//h4/a[normalize-space()='" + productName + "']");
        return isDisplayed(productLocator);
    }

    public void AddProductToCart(String productName) {

        By addToCartButton = By.xpath(
                "//h4/a[normalize-space()='" + productName + "']" +
                        "/ancestor::div[contains(@class,'product-thumb')]" +
                        "//button[contains(@onclick,'cart.add')]"
        );

        click(addToCartButton);
    }


    public String getTotalPrice() {

        return getText(cartTotal);
    }

    public boolean waitForCartItemCount(int count) {

        return wait.until(ExpectedConditions.textToBePresentInElementLocated(cartTotal, count + " item(s)"));
    }

    public void deleteProductFromCart(String productName) {
        click(cartTotal);
        By cartDropdown = By.cssSelector("#cart .dropdown-menu");

        wait.until(ExpectedConditions.visibilityOfElementLocated(cartDropdown));

        By deleteButton = By.xpath(
                "//div[@id='cart']" +
                        "//a[normalize-space()='" + productName + "']" +
                        "/ancestor::tr" +
                        "//button[@title='Remove']"
        );

        click(deleteButton);
    }
}