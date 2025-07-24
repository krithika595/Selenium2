package day21;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		String filePath=System.getProperty("user.dir")+"\\testdata\\testdata.xlsx";
		int rows=ExcelUtils.getRowCount(filePath,"sheet1");
		
		for(int i=1;i<=rows;i++) {
			//read data from excel
			
			String pric=ExcelUtils.getCellData(filePath,"sheet1",i,0);
			String rateOfInterestc=ExcelUtils.getCellData(filePath,"sheet1",i,1);
			String period1=ExcelUtils.getCellData(filePath,"sheet1",i,2);
			String period2=ExcelUtils.getCellData(filePath,"sheet1",i,3);
			String freq=ExcelUtils.getCellData(filePath,"sheet1",i,4);
			String expectedMValue=ExcelUtils.getCellData(filePath,"sheet1",i,5);
			
			//pass above data to application
			driver.findElement(By.xpath("//input[@id='principle']")).sendKeys(pric);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateOfInterestc);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period1);
			
			Select perdrp=new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			perdrp.selectByVisibleText(period2);
			
			
			Select fredrp=new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			fredrp.selectByVisibleText(freq);
			
			driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click(); //clicked on calculate
		
			//validation
			String act_mvalue=driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			if(Double.parseDouble(expectedMValue)==Double.parseDouble(act_mvalue)) {
				System.out.println("Test passed");
				ExcelUtils.setCellData(filePath, "sheet1", i, 7, "Passed");
				ExcelUtils.fillGreenColor(filePath, "sheet1", i, 7);				
			}else {
				System.out.println("Test failed");
				ExcelUtils.setCellData(filePath, "sheet1", i, 7, "Failed");
				ExcelUtils.fillRedColor(filePath, "sheet1", i, 7);	
			}
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//img[@class='PL5']")).click(); // clicked on clear button
		}// ending of for loop
		driver.quit();

	}

}
