package day4;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Assignment {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//Xpath with single attribute
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("T-shirts");
		
		//XPath with multiple attributes
		driver.findElement(By.xpath("//input[@id='small-searchterms'][@placeholder='Search store']")).sendKeys("T-shirts");
		
		//XPath with and operator
		driver.findElement(By.xpath("//input[@id='small-searchterms' and @placeholder='Search store']")).sendKeys("T-shirts");
		driver.findElement(By.xpath("//input[@id='small-searchterms' or @placeholder='xyz']")).sendKeys("T-shirts");
		
		//XPath with inner text()
		//driver.findElement(By.xpath("//a[text()='Electronics ']")).click();
		String value=driver.findElement(By.xpath("//h2[text()='Welcome to our store']")).getText();
		System.out.println(value);
		
		//XPath with contains()
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search store')]")).sendKeys("T-shirt");
		
		//XPath with starts-with()
		driver.findElement(By.xpath("//input[starts-with(@placeholder,'Search')]")).sendKeys("T-shirt");
		
		//XPath with chained xpath
		boolean display=driver.findElement(By.xpath("//div[@class='picture']/a/img")).isDisplayed();
		System.out.println(display);

	}

}
