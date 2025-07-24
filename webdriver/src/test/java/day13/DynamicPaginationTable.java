package day13;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPaginationTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
		driver.get("https://demo.opencart.com/admin/index.php");
		Thread.sleep(50000);
		driver.manage().window().maximize();
		
		WebElement username=driver.findElement(By.xpath("//input[@id='input-username']"));
		username.clear();
		username.sendKeys("demo");
		
		WebElement password=driver.findElement(By.xpath("//input[@id='input-password']"));
		password.clear();
		password.sendKeys("demo");

		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//close window if it is available
		if(driver.findElement(By.xpath("//button[@class='btn-close']")).isDisplayed()) {
			driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		}
		
		driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click(); //customer main memu
		driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click(); //customer sub menu
		 //showing 1 to 10 of 19081(1909 Pages)
		String txt=driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		int totalpages=Integer.parseInt(txt.substring(txt.indexOf("(")+1,txt.indexOf("Pages")-1));
		
		for(int p=1;p<=totalpages;p++) {
			if(p>1) {
				WebElement active_page=driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+p+"]"));
				active_page.click();
			}
			//reading data from the page
			int rows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			for(int i=1;i<=rows;i++) {
				String customerName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+i+"]//td[2]")).getText();
				String email=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+i+"]//td[3]")).getText();
				String status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+i+"]//td[5]")).getText();
				System.out.println(customerName+"\t"+email+"\t"+status);
			}
		}
		
	}

}
