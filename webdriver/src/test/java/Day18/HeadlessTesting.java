package Day18;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
/*
 * Adv: 1)we can do multiple tasks(since execution happens backend)
 *      2) faster execution
 * DisAdv: 1)user cannot see the actions on the page.so he cannot understand flow/functionnality of the test.
 */
public class HeadlessTesting {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless=new"); //setting for headless mode of execution
		
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://www.facebook.com/");
		
		//3) Validate title should be "Your Store"
		String act_title=driver.getTitle();
		if(act_title.equals("Facebook – log in or sign up")) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
		System.out.println(act_title);
		
		//4) close browser
		driver.quit();
		

	}

}
