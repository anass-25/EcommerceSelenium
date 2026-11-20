
package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() throws Exception {

        driver = DriverFactory.getDriver();

        driver.get("https://tutorialsninja.com/demo/");

        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page title: " + driver.getTitle());

        // Capture de la page réellement affichée
        File screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        Files.createDirectories(Path.of("target", "screenshots"));

        Files.copy(
                screenshot.toPath(),
                Path.of("target", "screenshots", "homepage.png"),
                java.nio.file.StandardCopyOption.REPLACE_EXISTING
        );
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
