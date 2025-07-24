package day12;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//1)find total no of rows in a table
		int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size(); //multiple tables
		//driver.findElements(By.tagName("tr")).size(); //works if only one table exists
		System.out.println(rows);
		
		
		//2)find total no of columns in a table
		int columns=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();  //multiple tables
		System.out.println(columns);
		System.out.println(driver.findElements(By.tagName("th")).size());//works if only one table exists
		
		//3)Read data from specific row and column (ex 5th row 1st column)
		System.out.println(driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText());
		
		//4)read data from all the rows and columns
		System.out.println("Bookname"+"\t"+"Author"+"\t"+"Subject"+"/t"+"Price");
		for(int r=2;r<=rows;r++) {
			for(int c=1;c<=columns;c++) {
				String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(value+"\t");
			}
			System.out.println();
		}
		
		//5)Print book names written by Mukesh
		for(int r=2;r<=rows;r++) {
			String authorName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			if(authorName.equals("Mukesh")) {
				String bookName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				System.out.println(bookName+"\t"+authorName);
			}
		}
		
		//6)find total price of all the books
		int total=0;
		for(int r=2;r<=rows;r++) {
			String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
			total=total+Integer.parseInt(price);
		}
		System.out.println(total);

	}

}
