package utilities;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;

public class ODFUtils {
	
	
	public static SpreadsheetDocument document;
	public static Table table;
	public static Row row;
	public static Cell cell;
	public static String testcases[];

	public static int getRowCount(String odffile,String odfsheet) throws Exception 
	{
		document = (SpreadsheetDocument)SpreadsheetDocument.loadDocument(odffile);
		table =document.getTableByName(odfsheet);
		int rowcount= table.getRowCount();
		return rowcount;		
	}
	
	public static int getCellCount(String odffile,String odfsheet, int rownum) throws Exception
	{
		document = (SpreadsheetDocument)SpreadsheetDocument.loadDocument(odffile);
		table =document.getTableByName(odfsheet);
		row = table.getRowByIndex(rownum);
		int cellcount=row.getCellCount();
		return cellcount;
	}
	public static String getCellData(String odffile,String odfsheet,int rownum,int colnum) throws Exception
	{
		document = (SpreadsheetDocument)SpreadsheetDocument.loadDocument(odffile);
		table =document.getTableByName(odfsheet);
		row = table.getRowByIndex(rownum);
		cell=row.getCellByIndex(colnum);
		String data = cell.getStringValue();
		return data;
			
	}
	
	// This is overloading method of above getCellData(get cell data based on colnum) method 
	//which is used get celldata based on col name
	
	public static String getCellData(String odffile,String odfsheet,int rownum,String colname) throws Exception{
		
		
		document = (SpreadsheetDocument)SpreadsheetDocument.loadDocument(odffile);
		table =document.getTableByName(odfsheet);
		
		int colnum = -1;
		row = table.getRowByIndex(1);
		
		for (int i =0; i < 	row.getCellCount(); i++) {
			
			if (row.getCellByIndex(i).getStringValue().trim().equals(colname.trim())) {
				colnum = i;
				
			}
		}
		row = table.getRowByIndex(rownum);
		cell = row.getCellByIndex(colnum);
		String data = cell.getStringValue();
		
		return data;
		
	}
	
	public static String[] getColumndata(String odffile,String odfsheet) throws Exception {
		document = (SpreadsheetDocument)SpreadsheetDocument.loadDocument(odffile);
		table =document.getTableByName(odfsheet);
		row = table.getRowByIndex(1);
		testcases = new String[row.getCellCount()-1];
		
		int j = 0;
		for (int i =0; i < 	row.getCellCount(); i++) {
			
			if (row.getCellByIndex(i).getStringValue().trim().equalsIgnoreCase("Features")) {
				continue;
			}
			else {
				testcases[j] = row.getCellByIndex(i).getStringValue().trim();
				j++;
			}
			
		}
		return testcases;
	}
	
	
	public static void setCellData(String odffile,String odfsheet,int rownum,int colnum,String data) throws Exception
	{
		document = (SpreadsheetDocument)SpreadsheetDocument.loadDocument(odffile);
		table =document.getTableByName(odfsheet);
		row = table.getRowByIndex(rownum);
		cell=row.getCellByIndex(colnum);
		cell.setStringValue(data);
		
	}
}
