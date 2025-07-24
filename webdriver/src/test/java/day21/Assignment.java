package day21;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator
public class Assignment {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		driver.manage().window().maximize();
		
		String filePath=System.getProperty("user.dir")+"\\testdata\\caldata2.xlsx";
		int rows=ExcelUtils.getRowCount(filePath, "Sheet1");
		
		WebElement initDA=driver.findElement(By.xpath("//input[@id='mat-input-0']"));
		WebElement monthLength=driver.findElement(By.xpath("//input[@id='mat-input-1']"));
		WebElement ir=driver.findElement(By.xpath("//div[@class='mat-form-field-infix ng-tns-c102-2']//input"));
		
		for(int i=1;i<=rows;i++) {
			String iniDepAmt=ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
			String length=ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
			String intRate=ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
			String compounding=ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
			String expAmount=ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
			
			initDA.clear();
			initDA.sendKeys(iniDepAmt);
			
			monthLength.clear();
			monthLength.sendKeys(length);
			
			ir.clear();
			ir.sendKeys(intRate);
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("//mat-select[@id='mat-select-0']")).click();
			List<WebElement> optionLists=driver.findElements(By.xpath("//div[@id='mat-select-0-panel']//mat-option"));
			
			for(WebElement optionList:optionLists) {
				if(optionList.getText().equals(compounding)) {
					optionList.click();
				}
			}
			driver.findElement(By.xpath("//button[@id='CIT-chart-submit']")).click();
			String act_amount=driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
			System.out.println(expAmount+" "+ expAmount);
			if(expAmount.replaceAll("[^\\d.]", "").equals(act_amount.replaceAll("[^\\d.]", ""))) {
				System.out.println("Test passed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 6, "Passed");
				ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 6);
			}else {
				System.out.println("Test failed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 6, "Failed");
				ExcelUtils.fillRedColor(filePath, "Sheet1", i, 6);
			}
		}
		driver.close();
	}

}
