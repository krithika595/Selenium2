package day3;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CSSLocator {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//tag id  tag#id
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-shirts");
		driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("T-shirts");
		
		//tag class  tag.classname
		//driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("T-shirts");
		driver.findElement(By.cssSelector(".search-box-text")).sendKeys("T-shirts");
		
		//tag attribute tag[attribute="value"]
		//driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("T-shirts");
		driver.findElement(By.cssSelector("[placeholder='Search store']")).sendKeys("T-shirts");
		
		//tag class attribute tag.classname[attribute="value"]
		//driver.findElement(By.cssSelector("input.search-box-text[class='q']")).sendKeys("T-shirts");
		driver.findElement(By.cssSelector(".search-box-text[class='q']")).sendKeys("T-shirts");
		

	}

}
