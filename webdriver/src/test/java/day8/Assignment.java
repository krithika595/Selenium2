package day8;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//1)provide some string search for it
//2)count number of links
//3)click on each link using for loop
//4)get window ID's for every browser window
//5)close specific browser window
public class Assignment {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("selenium");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		List<WebElement> links=driver.findElements(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']/child::*/a"));
		System.out.println("No of links: "+links.size());
		
		for(WebElement link:links) {
			link.click();
		}
		
		Set<String> winIDs=driver.getWindowHandles();
		for(String winID:winIDs) {
			System.out.println(winID);
		}
		
		for(String winID:winIDs) {
			driver.switchTo().window(winID);
			String title=driver.getTitle();
			
			/*if(title.equals("Selenium dioxide - Wikipedia")||title.equals("Selenium disulfide - Wikipedia")||title.equals("Selenium (software) - Wikipedia")||title.equals("Selenium in biology - Wikipedia") || title.equals("Selenium - Wikipedia") ) {
				driver.close();
			}*/
			
			if(!title.equals("Automation Testing Practice")) {
				driver.close();
			}
			
		}
		

	}

}
