
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

            // Vérifier l'environnement GitHub Actions
            String githubActions = System.getenv("GITHUB_ACTIONS");

            System.out.println("GITHUB_ACTIONS = " + githubActions);

            // Configuration Chrome pour GitHub Actions
            if ("true".equalsIgnoreCase(githubActions)) {

                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");

            }

            // Afficher les options utilisées
            System.out.println("Chrome options = " + options.asMap());

            // Démarrer Chrome
            driver = new ChromeDriver(options);

            driver.manage().window().maximize();
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
