package day13;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		int pages=driver.findElements(By.xpath("//ul[@id='pagination']//li")).size();
		System.out.println("Total no of pages"+pages);
		
		int rows=driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
		int columns=driver.findElements(By.xpath("//table[@id='productTable']//thead//th")).size();
		//ul[@id='pagination']//li[1]//a
		
		for(int k=1;k<=pages;k++) {
			for(int i=1;i<=rows;i++) {
				for(int j=1;j<=columns;j++) {
					if(j!=4) {
						String txt=driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+i+"]//td["+j+"]")).getText();
						System.out.print(txt+"\t");
					}else {
						driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+i+"]//input")).click();
					}
					
				}
				System.out.println();
			}			
				driver.findElement(By.xpath("//ul[@id='pagination']//li["+(k+1)+"]//a")).click();		
		}
		
		
	}

}
