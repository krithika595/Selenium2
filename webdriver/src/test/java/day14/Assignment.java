package day14;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment {
	

	public static void main(String[] args) throws InterruptedException {
		//https://dummy-tickets.com/buyticket
		//https://dummy-tickets.com/dummy-ticket-for-visa-application/
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://dummy-tickets.com/buyticket");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//a[contains(text(),'Both')]")).click(); //click on both
		
		//driver.findElement(By.xpath("//form[@id='both_oneway']//div[1]//div[1]//input[@name='source[]']")).sendKeys("Bangalore");		
		//driver.findElement(By.xpath("//form[@id='both_oneway']/child::div[1]//div[1]//ul//li[1]")).click();
		
		//driver.findElement(By.xpath("//form[@id='both_oneway']/child::div[1]//div[2]//ul[4]")).click();   //selecting destination
		//driver.findElement(By.xpath("(//input[@name='destination[]'])[4]")).sendKeys("lon");
		
		driver.findElement(By.xpath("//form[@id='both_oneway']//div[2]//div//input[@placeholder='Departure Date']")).click();// clicking on departure date
		
		//select year
		WebElement yrdrp=driver.findElement(By.xpath("//select[@aria-label='Select year']"));
		Select ydrp=new Select(yrdrp);
		ydrp.selectByValue("2026");
		
		//select month
		WebElement monthdrp=driver.findElement(By.xpath("//select[@aria-label='Select month']"));
		Select mthdrp=new Select(monthdrp);
		mthdrp.selectByVisibleText("Jan");
		
		//select date
		List<WebElement> allDays=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
		for(WebElement day:allDays) {
			if(day.getText().equals("29")) {
				day.click();
				break;
			}
		}
		
		/*WebElement checkInInput = new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.presenceOfElementLocated(
		            By.xpath("//form[@id='both_oneway']//input[@placeholder='Check In Date' and @name='checkin[]']")));
*/
		/*WebElement input = driver.findElement(By.cssSelector("input[name='checkin[]']"));
		Point loc = input.getLocation();
		int x = loc.getX() + input.getSize().getWidth()/2;
		int y = loc.getY() + input.getSize().getHeight()/2;

		String blocker = (String) ((JavascriptExecutor) driver)
		    .executeScript(
		        "var e = document.elementFromPoint(arguments[0], arguments[1]);" +
		        "return e ? e.outerHTML : 'null';",
		        x, y);

		System.out.println("Blocker at click point:\n" + blocker);*/
		
		WebElement arrow = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", arrow);
		Thread.sleep(200); // Allow time to stabilize
		arrow.click(); // Try native click again
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", arrow);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -100);");

		
		String requiredYear="2026";
		int expectedYear= Integer.parseInt(requiredYear);
		while(true) {
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			int displayedYear = Integer.parseInt(currentYear);

			if (expectedYear > displayedYear) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			} else if (expectedYear < displayedYear) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			}else {
				break;
			}
		}
		
		WebElement mdrp=driver.findElement(By.xpath("//select[@aria-label='Select month']"));
		Select drp=new Select(mdrp);
		
		drp.selectByVisibleText("Jan");
		
		List<WebElement> dates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td"));
		for(WebElement dat:dates) {
			if(dat.getText().equals("29")) {
				dat.click();
			}
		}
		/*
		// 1. Locate the check-in input field
		WebElement checkInInput = driver.findElement(By.xpath("//form[@id='both_oneway']//div[4]//input[@placeholder='Check In Date']"));

		// 2. Scroll to it and click via JS
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", checkInInput);
		js.executeScript("arguments[0].click();", checkInInput);

		// 3. Wait for the calendar popup (year) to be visible
		
		WebElement yearElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("//span[@class='ui-datepicker-year']")));

		String currentYear = yearElement.getText();
		System.out.println("Displayed year: " + currentYear);*/

	}

}
