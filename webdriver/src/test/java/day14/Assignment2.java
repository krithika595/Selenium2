package day14;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment2 {
	
	static void selectDate(WebDriver driver,String requiredYear,String requiredMonth,String requiredDate) {
		int expectedYear=Integer.parseInt(requiredYear);
		while(true) {
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			int displayedYear = Integer.parseInt(currentYear);
			if (expectedYear > displayedYear) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			} else if (expectedYear < displayedYear) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']']")).click();
			} else {
				break;
			}
		}
		WebElement allmonthDrp=driver.findElement(By.xpath("//select[@aria-label='Select month']"));
		Select monthDrp=new Select(allmonthDrp);
		monthDrp.selectByVisibleText(requiredMonth);
		List<WebElement> alldays=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td"));
		for(WebElement day:alldays) {
			if(day.getText().equals(requiredDate)) {
				day.click();
				break;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		driver.get("https://dummy-tickets.com/buyticket");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[contains(text(),'Both')]")).click(); //click on both
		driver.findElement(By.xpath("//input[@value='roundtripfh']")).click(); //click rounttrip
		
		//from
		driver.findElement(By.xpath("//form[@id='both_round']//div[1]//div[1]//input[@name='source[]']")).sendKeys("Bangalore ");
		Thread.sleep(3000);
		List<WebElement> from=driver.findElements(By.xpath("//ul[@class='suggestions-list']//p"));
		for(WebElement fr:from) {
			if(fr.getText().contains("HAL Bangalore International")) {
				fr.click();
				break;
			}
		}
		
		//to
		
		driver.findElement(By.xpath("//form[@id='both_round']//div[@class='col-sm-12 p-0 suggestion-container']//input[@name='destination[]']")).sendKeys("Bhubaneswar ");
		Thread.sleep(3000);
		List<WebElement> to=driver.findElements(By.xpath("//ul[@class='suggestions-list']//p"));
		for(WebElement t:to) {
			if(t.getText().contains("Bhubaneswar Airport")) {
				t.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("(//input[@placeholder='Departure Date'])[5]")).click();
		
		String requiredYear="2026";
		String requiredMonth="Jan";
		String requiredDate="29";
		
		selectDate(driver,requiredYear,requiredMonth,requiredDate);//departure
		driver.findElement(By.xpath("(//input[@placeholder='Return Date'])[2]")).click();
		selectDate(driver,"2026","Mar","29");//return
		driver.findElement(By.xpath("(//input[@name='city[]'])[3]")).sendKeys("Bangalore");
		Thread.sleep(3000);
		List<WebElement> citiesList= driver.findElements(By.xpath("//ul[@class='suggestions-cities-list']//li//p"));
		for(WebElement list:citiesList) {
			if(list.getText().contains("Bangalore")) {
				list.click();
				break;
			}
		}
	}

}
