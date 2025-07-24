package day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment2 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();

		WebElement bank=driver.findElement(By.xpath("//a[normalize-space()='BANK']"));
		WebElement bankTrg=driver.findElement(By.xpath("//ol[@id='bank']//li[@class='placeholder']"));
		Actions act=new Actions(driver);
		act.dragAndDrop(bank, bankTrg).perform();
		
		WebElement fivek=driver.findElement(By.xpath("//a[text()=' 5000 ']"));
		WebElement fivektrg=driver.findElement(By.xpath("//ol[@id='amt7']//li[@class='placeholder']"));
		act.dragAndDrop(fivek, fivektrg).perform();
		
		WebElement sales=driver.findElement(By.xpath("//a[normalize-space()='SALES']"));
		WebElement salesTrg=driver.findElement(By.xpath("//ol[@id='loan']//li[@class='placeholder']"));
		act.dragAndDrop(sales, salesTrg).perform();
		
		WebElement cramount=driver.findElement(By.xpath("//a[text()=' 5000']"));
		WebElement cramounttrg=driver.findElement(By.xpath("//ol[@id='amt8']//li[@class='placeholder']"));
		act.dragAndDrop(cramount, cramounttrg).perform();
		
		String txt=driver.findElement(By.xpath("//a[normalize-space()='Perfect!']")).getText();
		if(txt.equals("Perfect!")) {
			System.out.println("Test passed");
		}else {
			System.out.println("Test failed");
		}
	}

}
