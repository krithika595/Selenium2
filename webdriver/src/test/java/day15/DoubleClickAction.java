package day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//double click -- doubleClick(element)
//getText()--->returns inner text of the web element
//getAttribute(attribute)--->returns value of attribute
public class DoubleClickAction {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		
		//switch to frame
		driver.switchTo().frame("iframeResult");
		
		WebElement box1=driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement box2=driver.findElement(By.xpath("//input[@id='field2']"));
		
		WebElement button=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		box1.clear();
		box1.sendKeys("WELCOME");
		
		//double click
		Actions act=new Actions(driver);
		act.doubleClick(button).perform();
		
		//validation: box2 should contains "WELCOME"
		String txt=box2.getAttribute("value");
		String text=box2.getText();
		System.out.println(text);
		if(txt.equals("WELCOME")) {
			System.out.println("Text copied");
		}else {
			System.out.println("Text not copied properly");
		}
		
	}

}
