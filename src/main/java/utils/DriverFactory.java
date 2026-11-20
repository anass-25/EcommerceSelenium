
package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // Détecter GitHub Actions
            String githubActions = System.getenv("GITHUB_ACTIONS");

            if ("true".equalsIgnoreCase(githubActions)) {

                // Chrome sans interface graphique
                options.addArguments("--headless=new");

                // Taille de fenêtre fixe
                options.addArguments("--window-size=1920,1080");

                options.addArguments("--disable-gpu");
            }

            System.out.println("GitHub Actions = " + githubActions);
            System.out.println("Chrome options = " + options.asMap());

            driver = new ChromeDriver(options);

            // Agrandir la fenêtre uniquement en local
            if (!"true".equalsIgnoreCase(githubActions)) {
                driver.manage().window().maximize();
            }

            driver.manage().deleteAllCookies();
        }

        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
