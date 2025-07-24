package day4;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XPathDemo {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		//XPath with single attribute //tagname[@attribute='value']       //*[@attribute='value']
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("T-shirts");
		
		//XPath with multiple attributes
		driver.findElement(By.xpath("//input[@name='search'][@placeholder='Search']")).sendKeys("T-shirts");
		
		//XPath with and operator
		driver.findElement(By.xpath("//input[@name='search' and @placeholder='Search'")).sendKeys("T-shirts");
		
		//XPath with or operator
		driver.findElement(By.xpath("//input[@name='search' or @placeholder='xyz'")).sendKeys("T-shirts");
		
		//XPath with inner text -  text()
		driver.findElement(By.xpath("//a[text()='Desktops']")).click();
		
		boolean displaystatus=driver.findElement(By.xpath("//h3[text()='Featured']")).isDisplayed();
		System.out.println(displaystatus);
		
		String value=driver.findElement(By.xpath("//h3[text()='Featured']")).getText();
		System.out.println(value);
		
		//XPath with contains() //tag[contains(@attribute,'value')]
		driver.findElement(By.xpath("//input[contains(@placeholder,'Sea')]")).sendKeys("T-sirts");
		
		//XPath with starts-with()
		driver.findElement(By.xpath("//input[starts-with(@placeholder,'Sea')]")).sendKeys("T-sirts");
		
		//handling dynamic attributes
		     //id=start id=stop
		//*[@id,'start' or @id,'stop']
		//*[contains(@id,'st')]
		//*[starts-with(@id,'st')]
		
		    // name= xyz001 xyz002 xyz008
		//*[contains(@name,'xyz')]
		//*[contains(@name,'00')]
		//*[starts-with(@name,'xyz')]
		
		    //name= 1xyz 2xyz 3xyz
		//*[contains(@name,'xyz')]
		
		    //name= 101xyz 201xyz 301xyz 401xyz
		//*[contains(@name,'xyz')]
		//*[contains(@name,'01')]
		
		//chained xpath
		boolean imagestatus=driver.findElement(By.xpath("//div[@id='logo']/a/img")).isDisplayed();
		System.out.println(imagestatus);
		
		//<div></div>
		//div[contains(text(),'')]
		//div[contains(.,'')]
	}

}
