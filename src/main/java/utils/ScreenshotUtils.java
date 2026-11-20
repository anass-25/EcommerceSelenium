package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public static void takeScreenshot(WebDriver driver, String fileName) {

        try {

            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File folder = new File("screenshots");

            if (!folder.exists()) {
                folder.mkdirs();
            }

            File destination = new File(folder, fileName + ".png");

            FileHandler.copy(source, destination);

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
