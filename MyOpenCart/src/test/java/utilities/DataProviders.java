package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		String path=".\\testData\\Opencart_LoginData.xlsx";
		ExcelUtilities eut=new ExcelUtilities(path);
		int rowcount=eut.getRowCount("Sheet1");
		int colcount=eut.getColumnCount("Sheet1", 1);
		
		String logindata[][]=new String[rowcount][colcount];
		
		for(int i=1;i<=rowcount;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j]=eut.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
	}
}
