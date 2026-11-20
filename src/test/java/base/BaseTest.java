package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;

public class BaseTest {
    protected WebDriver driver;


    @BeforeMethod
    public void setup() {

        driver = DriverFactory.getDriver();

        driver.get("https://tutorialsninja.com/demo");

        driver.manage().deleteAllCookies();

        driver.navigate().refresh();

    }



    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();

    }
}
