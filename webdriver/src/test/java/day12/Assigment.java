package day12;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//1)https://blazedemo.com/
public class Assigment {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		
		WebElement drpDepartureCity=driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select drpDeparture=new Select(drpDepartureCity);
		drpDeparture.selectByValue("San Diego");
		
		WebElement drpDestinationCity=driver.findElement(By.xpath("//select[@name='toPort']"));
		Select drpDestination=new Select(drpDestinationCity);
		drpDestination.selectByVisibleText("Berlin");
		
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		int rows=driver.findElements(By.xpath("//table[@class='table']/tbody/tr")).size();
		System.out.println(rows);
		int columns=driver.findElements(By.xpath("//table[@class='table']//th")).size();
		System.out.println(columns);
		
		
		List<Double> prices= new ArrayList<>();
		Map<Double,Integer> priceRowMap=new HashMap<>();
		for(int r=1;r<=rows;r++) {
			String priceText=driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+r+"]/td[6]")).getText();
			priceText=priceText.replace("$", "").trim();
			Double price=Double.parseDouble(priceText);
			prices.add(price);
			priceRowMap.put(price,r);
		}
		
		Collections.sort(prices);
		
		double lowestPrice = prices.get(0);
        int rowIndex = priceRowMap.get(lowestPrice);

        System.out.println("Lowest price: $" + lowestPrice + " at row: " + rowIndex);
        
        driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+rowIndex+"]/td[1]")).click();
        
        driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Krithika");
        driver.findElement(By.xpath("//input[@id='address']")).sendKeys("no 68");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Bangalore");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Karnataka");
        driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("0056");
        WebElement drpCard=driver.findElement(By.xpath("//select[@id='cardType']"));
        Select drp=new Select(drpCard);
        drp.selectByValue("visa");
        driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("87349");
        driver.findElement(By.xpath("//input[@id='creditCardMonth']")).clear();
        driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("12");
        driver.findElement(By.xpath("//input[@id='creditCardYear']")).clear();
        driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2028");
        driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Krithika");
        driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
        driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
        
        String txt=driver.findElement(By.xpath("//h1[contains(text(),'Thank you for your purchase today!')]")).getText();
		
		System.out.println(txt);
		

	}

}
