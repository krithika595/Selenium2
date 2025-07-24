package day3;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Assignment {
	
	public static void main(String[] args) {
		WebDriver driver=new EdgeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//tag#id
		//driver.findElement(By.cssSelector("li#topcartlink")).click();
		
		//tag.classname
		//driver.findElement(By.cssSelector("span.wishlist-label")).click();
		
		//tag[attribute="value"]
		//driver.findElement(By.cssSelector("a[title=\"Show products in category Apparel\"]")).click();
		
		//tag.class[attribute="value"]
		boolean imgdisplayed=driver.findElement(By.cssSelector(".slider-img[src='https://demo.nopcommerce.com/images/thumbs/0000079_banner_1.webp']")).isDisplayed();
		System.out.println(imgdisplayed);
	}

}
