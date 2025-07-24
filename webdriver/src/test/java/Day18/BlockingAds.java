package Day18;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BlockingAds {

	public static void main(String[] args) {
		EdgeOptions options=new EdgeOptions();
		
		File file=new File("D:\\AK_Automation\\eclipse-java-2025-03-R-win32-x86_64\\webdriver\\Extensions\\AdBlock-—-block-ads-across-the-web-Chrome-Web-Store.crx");
		/*if (file.exists()) {
            options.addExtensions(file);
        } else {
            System.out.println("Extension file not found at: " + file.getAbsolutePath());
            return;
        }*/
		options.addExtensions(file);
		
		WebDriver driver=new EdgeDriver(options);
		
		driver.get("https://text-compare.com/");

	}

}
