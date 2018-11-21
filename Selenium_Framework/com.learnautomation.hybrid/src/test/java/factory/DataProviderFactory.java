package factory;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;

public class DataProviderFactory {// it is optional but better to use which reduces coding
	
	public static ConfigDataProvider getConfig() {
		
		ConfigDataProvider config = new ConfigDataProvider();
		
		return config;
		}
	
	public static ExcelDataProvider getExcel() {
		
		ExcelDataProvider excel = new ExcelDataProvider();
		
		return excel;
	}

}
