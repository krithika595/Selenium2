package Day18;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
/*step1: add CRX Extractor/Downloader to Chrome Browser(manually)
 * step2: add selectorhub plugin to chrome Browser(manually)
 * step3: capture crx file for selectorshub extention
 * step4: pass crx file path in automation script in chrome options
 */
public class EnableExtensionsAtRunTime {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		
		File file=new File("D:\\AK_Automation\\eclipse-java-2025-03-R-win32-x86_64\\SelectorsHub-Chrome-Web-Store.crx");
		/*if (file.exists()) {
            options.addExtensions(file);
        } else {
            System.out.println("Extension file not found at: " + file.getAbsolutePath());
            return;
        }*/
		options.addExtensions(file);
		
		
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://www.facebook.com/");
		

	}

}
