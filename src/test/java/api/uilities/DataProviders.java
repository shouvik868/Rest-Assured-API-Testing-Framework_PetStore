package api.uilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//Data Provider 1
	
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException{
		
		String path=".\\testdata\\Userdata.xlsx";
		
		XlUtility xlutils = new XlUtility(path);
		int totalRows=xlutils.getRowCount("Sheet1");
		int totalCols=xlutils.getCellCount("Sheet1",1);
		
		String apiData[][]= new String[totalRows][totalCols] ;
		
		for(int i=1;i<=totalRows;i++) {
			for(int j=0;j<totalCols;j++) {
				apiData[i-1][j]= xlutils.getCellData("Sheet1", i, j);
			}
		}
		return apiData;
	}
	
	//DP2
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException {
		String path=".\\testdata\\Userdata.xlsx";
		XlUtility xlutils = new XlUtility(path);
		int totalRows=xlutils.getRowCount("Sheet1");
		
		String apiData[] = new String[totalRows];
		
		for (int i = 1; i <= totalRows; i++) {
			apiData[i - 1] = xlutils.getCellData("Sheet1", i, 1); // Assuming usernames are in the first column
		}
		
		return apiData;
	}
	//DP3
}
