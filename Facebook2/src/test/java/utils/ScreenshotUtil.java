package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtil {

    public static String capture(WebDriver driver, String screenshotName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String dir = System.getProperty("user.dir") + "/reports/screenshots/";
            Files.createDirectories(Paths.get(dir));

            String path = dir + screenshotName + ".png";
            File dest = new File(path);
            Files.copy(src.toPath(), dest.toPath());

            return path;  
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
