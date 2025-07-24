package day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//dragAndDropBy(Element,x,y)
public class SliderDemo {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		//Min Slider
		WebElement min_slider=driver.findElement(By.xpath("//span[1]"));
		System.out.println("Default location of min slider"+min_slider.getLocation());//(59,250)=(x,y)
		Actions act=new Actions(driver);
		act.dragAndDropBy(min_slider, 100, 250).perform();
		System.out.println("location of min slider after moving"+min_slider.getLocation());//(158, 250)
		
		//Max slider
		WebElement max_slider=driver.findElement(By.xpath("//span[2]"));
		System.out.println("Default location of max slider"+max_slider.getLocation());//(613, 250)
		act.dragAndDropBy(max_slider, -100, 250).perform();
		System.out.println("location of maxn slider after moving"+max_slider.getLocation());//(513, 250)
	}

}
