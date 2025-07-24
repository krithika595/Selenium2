package day14;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo {
	
	//select future date
	static void selectFutureDate(WebDriver driver,String year,String month,String date) {
		//select month and year
		while(true) {
			String currentMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();//actual data
			String currentYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();//actual data
			if(currentMonth.equals(month) && currentYear.equals(year)) {
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); //next
		} 
		
		//select date
		List<WebElement> dates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//tr//td//a"));
		for(WebElement dt:dates) {
			if(dt.getText().equals(date)) {
				dt.click();
				break;
			}
			
		}
	}
	
	//select past date
		static void selectPastDate(WebDriver driver,String year,String month,String date) {
			//select month and year
			while(true) {
				String currentMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();//actual data
				String currentYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();//actual data
				if(currentMonth.equals(month) && currentYear.equals(year)) {
					break;
				}
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //next
			} 
			
			//select date
			List<WebElement> dates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//tr//td//a"));
			for(WebElement dt:dates) {
				if(dt.getText().equals(date)) {
					dt.click();
					break;
				}
				
			}
		}
	
	

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		//switch to frame
		driver.switchTo().frame(0);
		
		//Method1 using sendkeys()
		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("12/01/2024"); //mm/yy/yyyy
		
		//Method2 using datepicker
		//expected data
		String year="2026";
		String month="December";
		String date="20";
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click(); //opens datepicker
		
		//selectFutureDate(driver,year,month,date);
		selectPastDate(driver,"2012","September","24");
	}

}
