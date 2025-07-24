package day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 * 1)double click & drag and drop
 * https://testautomationpractice.blogspot.com
 * 2)drag and drop
 * http://demo.guru99.com/test/drag_drop.html
 */
public class Assignment {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com");
		driver.manage().window().maximize();
		
		WebElement box1=driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement box2=driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement button=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		box1.clear();
		box1.sendKeys("Krithika");
		Actions act=new Actions(driver);
		act.doubleClick(button).perform();
		
		if(box2.getAttribute("value").equals("Krithika")) {
			System.out.println("Test Passed");
		}else {
			System.out.println("test failed");
		}
		
		WebElement src=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement trgt=driver.findElement(By.xpath("//div[@id='droppable']"));
		act.dragAndDrop(src,trgt).perform();
		
		if(trgt.getText().equals("Dropped!")) {
			System.out.println("passed");
		}else {
			System.out.println("failed");
		}
		
	}

}
