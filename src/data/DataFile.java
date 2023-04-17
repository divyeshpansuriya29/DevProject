package data;

import utilities.Xls_Reader;

public class DataFile {
	
	Xls_Reader d = new Xls_Reader("/Users/divyeshpansuriya/Desktop/Divyesh QA Practice/Testing/NikulTest.xlsx");
	
	//Login Test
	public String wrongEmail = d.getCellData("Data1", 1, 3);
	public String wrongPassword = d.getCellData("Data1", 2, 2);
	public String emailwithSpecialChar = d.getCellData("Data1", 1, 4);
	public String globalErr = d.getCellData("Data1", 5, 2);
	public String emptyEmail = d.getCellData("Data1", 3, 4);
	public String emptyPassword = d.getCellData("Data1", 2, 3);
	
	//Footer Test
	
	//Search Test
	
	//Home Test

}
