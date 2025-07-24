
package day9;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		//Normal alert with OK button
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		
		Alert myalert=driver.switchTo().alert();
		System.out.println(myalert.getText());
		myalert.accept();
		
		//Confirmation alert - OK & Cancel
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		//driver.switchTo().alert().accept(); //close alert using OK button
		driver.switchTo().alert().dismiss(); //close alert using Cancel button
		
		//Prompt alert - Input box
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		myalert=driver.switchTo().alert();
		myalert.sendKeys("Welcome");
		myalert.accept();
		
		
	}

}
