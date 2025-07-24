package Day17;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		//ChromeDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
		/*//single file upload
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C:\\Users\\divya\\Downloads\\XPath.pdf");
		
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("XPath.pd")) {
			System.out.println("File is successfully uploaded");
		}else {
			System.out.println("Upload failed");
		}*/
		
		//multiple files
		String file1="C:\\Users\\divya\\Downloads\\XPath.pdf";
		String file2="C:\\Users\\divya\\Downloads\\Locators.pdf";
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2);
		
		List<WebElement> uploadedfiles=driver.findElements(By.xpath("//ul[@id='fileList']//li"));
		if(uploadedfiles.size()==2) {
			System.out.println("All files are uploaded");
		}else {
			System.out.println("Files are not uploaded");
		}
		
		for(WebElement files:uploadedfiles) {
			if(files.getText().equals("XPath.pdf") ||files.getText().equals("Locators.pdf") ) {
				System.out.println("Files name matching: "+files.getText());
			}else {
				System.out.println("not matching");
			}
		}
	}

}
