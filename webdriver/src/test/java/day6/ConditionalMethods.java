package day6;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//related to WebElement
//access these commands through WebElement
//returns boolean value
public class ConditionalMethods {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		
		//isDisplayed() - we can check display status of the element
		//WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		//System.out.println(logo.isDisplayed());
		
		boolean status=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		System.out.println(status);
		
		//isEnabled() input box,radio,dropdown,checkbox 
		// we can check enable/diable status of the element/operational element
		boolean enabled=driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled();
		System.out.println(enabled);
		
		//isSelected() - we can use to check the element is selected or not 
		//radio,dropdown,checkbox 
		WebElement male_rd=driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female_rd=driver.findElement(By.xpath("//input[@id='gender-female']"));
		
		System.out.println("Before Selection.....");
		System.out.println(male_rd.isSelected()); //false
		System.out.println(female_rd.isSelected());//false
		
		System.out.println("After selecting male...");
		male_rd.click(); //select male radio button
		
		System.out.println(male_rd.isSelected()); //true
		System.out.println(female_rd.isSelected());//false
		
		System.out.println("After selecting female...");
		female_rd.click(); //select male radio button
		
		System.out.println(male_rd.isSelected()); //false
		System.out.println(female_rd.isSelected());//true
		
		boolean newsletterstatus=driver.findElement(By.xpath("//input[@id='Newsletter']")).isSelected();
		System.out.println(newsletterstatus);
		
		
	}

}
