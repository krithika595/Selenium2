package day19;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 1)link href="https://xyz.com
 * 2)https://xyz.com --> server -->status code
 * 3)status code>=400 broken link
 * status code <400 not a broken link
 */
public class BrokenLinks {

	public static void main(String[] args) throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		//capture all the links from website
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		int noofbrokenlink=0;
		for(WebElement link:links) {
			String hrefatValue=link.getAttribute("href");
			
			if(hrefatValue==null || hrefatValue.isEmpty()) {
				System.out.println("Not possible to check");
				continue;
			}
			
			//hit url to server
			try {
			URL linkURL = new URL(hrefatValue);//converted href value from string to URL format
			HttpURLConnection conn=(HttpURLConnection) linkURL.openConnection(); //open connection to the server
			conn.connect();//connect to server and sent request to the server
			
			if(conn.getResponseCode()>=400) {
				System.out.println(hrefatValue+"====> Broken link");
				noofbrokenlink++;
			}else {
				System.out.println("Not a broken link:"+hrefatValue);
			}
			}catch(Exception e) {
				
			}
		}
		System.out.println("total no of broken links:"+noofbrokenlink );

	}

}
