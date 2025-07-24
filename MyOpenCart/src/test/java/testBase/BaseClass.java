package testBase;


import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public static Logger logger;
	public static Properties p;
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String br) throws IOException {
		FileReader f=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(f);
		
		switch(br.toLowerCase()) {
		
		case "chrome": driver=new ChromeDriver();break;
		case "edge": driver=new EdgeDriver();break;
		case "firefox": driver=new FirefoxDriver();break;
		default: System.out.println("Invalid Browser");return;
		
		}
		
		logger=LogManager.getLogger(this.getClass());
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appURL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public String randomString() {
		String randomString=RandomStringUtils.randomAlphabetic(5);
		return randomString;
	}
	public String randomNumber() {
		String randomStringNum=RandomStringUtils.randomNumeric(10);
		return randomStringNum;	
	}
	public String randomAlphaNum() {
		String randomString=RandomStringUtils.randomAlphabetic(3);
		String randomStringNum=RandomStringUtils.randomNumeric(2);
		return (randomString+"^"+randomStringNum);
	}
}
