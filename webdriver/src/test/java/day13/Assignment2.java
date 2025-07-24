package day13;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
		driver.manage().window().maximize();
		
		//login steps
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//clicking on admin
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		
		int rows=driver.findElements(By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']")).size();
		int columns=driver.findElements(By.xpath("//div[@class='oxd-table-header']//div[@role='columnheader']")).size();
		
		for(int i=1;i<=rows;i++) {
			for(int j=2;j<=3;j++) {
				String txt=driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']["+i+"]//div[@class='oxd-table-cell oxd-padding-cell']["+j+"]")).getText();
				System.out.print(txt+"\t");
			}
			System.out.println();
		}
		
	}

}
