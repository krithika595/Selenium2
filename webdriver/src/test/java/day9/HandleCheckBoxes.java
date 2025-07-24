package day9;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandleCheckBoxes {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//1)select specific checkbox
		//driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
		//2) select all checkboxes
		List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		/*for(int i=0;i<checkboxes.size();i++) {
			checkboxes.get(i).click();
		}*/
		/*
		for(WebElement checkbox:checkboxes) {
			checkbox.click();
		}*/
		
		//total checkboxes - last 3checkboxes  //7-3=4(starting index)
		//3)select last three checkboxes
		/*for(int i=4;i<checkboxes.size();i++) {
			checkboxes.get(i).click();
		}*/
		
		//4) select first 3 checkboxes
		for(int i=0;i<3;i++) {
			checkboxes.get(i).click();
		}
		
		//5) unselect checkboxes if they are selected
		for(WebElement checkbox:checkboxes) {
			boolean selected=checkbox.isSelected();
			if(selected==true) {
				checkbox.click();
			}
		}
		
	}

}
