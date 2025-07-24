package day5;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XPathAxes {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		driver.manage().window().maximize();
		
		//self - selects the current node
		String value=driver.findElement(By.xpath("//a[text()='Fineotex Chemical Lt']/self::a")).getText();
		System.out.println(value);
		
		//parent - selects the parent of the current node (always one)
		value=driver.findElement(By.xpath("//a[text()='Fineotex Chemical Lt']/parent::td")).getText();
		System.out.println(value);
		
		//child - Select all children of the current node (one or more)
		List<WebElement> childs=driver.findElements(By.xpath("//a[text()='Fineotex Chemical Lt']/ancestor::tr/child::*"));
		System.out.println(childs.size());
		
		//ancestor - selects all ancestors (parent,grandparent,etc..)
		value=driver.findElement(By.xpath("//a[text()='Fineotex Chemical Lt']/ancestor::tr")).getText();
		System.out.println(value);
		
		//descendant - selects all descandants (children, grandchildren,etc) of the current node
		List<WebElement> descendants=driver.findElements(By.xpath("//a[text()='Fineotex Chemical Lt']/ancestor::tr/descendant::*"));
		System.out.println(descendants.size());
		
		//following - selects everything in the document after the closing tag of the current node
		List<WebElement> following=driver.findElements(By.xpath("//a[text()='Fineotex Chemical Lt']/ancestor::tr/following::tr"));
		System.out.println(following.size());
		
		//following-sibling Selects all siblings after the current node
		List<WebElement> followingSibling=driver.findElements(By.xpath("//a[text()='Fineotex Chemical Lt']/ancestor::tr/following-sibling::tr"));
		System.out.println(followingSibling.size());
		
		//preceding - select all nodes that appear before the current node in the document
		List<WebElement> precedings=driver.findElements(By.xpath("//a[text()='Fineotex Chemical Lt']/ancestor::tr/preceding::tr"));
		System.out.println(precedings.size());
		
		//preceding-sibling - select all siblings before the current node
		List<WebElement> precedingSiblings=driver.findElements(By.xpath("//a[text()='Fineotex Chemical Lt']/ancestor::tr/preceding-sibling::tr"));
		System.out.println(precedingSiblings.size());
		
		driver.close();
	}

}
