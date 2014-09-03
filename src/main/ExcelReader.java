package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
	
	private String filePath = null;;
	
	private FileInputStream excelFile = null;;
	private XSSFWorkbook excelWorkbook = null;;
	private XSSFSheet excelSheet = null;;
	private XSSFCell excelCell = null;
	
	private String cellData = null;;
	
	private SimpleDateFormat objSimpleDateFormat = null;
	
	
	public void setExcelCell(int lRow, int lCol){
		
		excelCell = excelSheet.getRow(lRow).getCell(lCol);
	}
	
	public XSSFCell getExcelCell(){
		
		return excelCell;
	}
	
	public int getExcelCellType(int row, int col){
		
		excelCell = excelSheet.getRow(row).getCell(col);
		
		//System.out.println("The cell type is : " + excelCell.getCellType());
		
		if (excelCell == null){
			return -1;
		}
		
		return excelCell.getCellType();
	}
	
	public void setFilePath(String lFilePath){
	
		if(lFilePath.endsWith("xlsx")){
				
			this.filePath = lFilePath;
		}
		else{
			
			System.out.println("The file is not a valid xlsx file. Please provide xlsx file.");
		}
	}
	
	public String getFilePath(){
		
		return filePath;
	}
	
	public void setExcelFile(){
		
		try{
				
			this.excelFile = new FileInputStream(new File(this.filePath));
				
		}catch(FileNotFoundException e){
			
			e.printStackTrace();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
	}
	
public void setExcelFile(String lExcelFilePath){
		
		try{
				
			this.excelFile = new FileInputStream(new File(lExcelFilePath));
				
		}catch(FileNotFoundException e){
			
			e.printStackTrace();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
	}
	
	public FileInputStream getExcelFile(){
		
		return excelFile;
	}
	
	
	public void setExcelWorkbook(FileInputStream lFile){
		
		try{
			
			this.excelWorkbook = new XSSFWorkbook(lFile);
		
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
	}
	
	public XSSFWorkbook getExcelWorkbook(){
		
		return excelWorkbook;
	}
	
	
	public void setExcelSheet(int sheetIndex ){
		
		excelSheet = excelWorkbook.getSheetAt(sheetIndex);
		
	}
	
	public void setExcelSheet(String sheetName ){
		
		excelSheet = excelWorkbook.getSheet(sheetName);	
				
	}
	
	
	public void setCellData(String lCellData){
		
		this.cellData = lCellData;
	}
	
	public void setCellData(int row, int col){
		
			
		switch (getExcelCellType(row, col)){
		
		    case XSSFCell.CELL_TYPE_STRING:
		    	this.cellData = excelCell.toString().trim();
		        break;
		    case XSSFCell.CELL_TYPE_NUMERIC:
		    	
		        if (DateUtil.isCellDateFormatted(excelCell)) {
		            
		          //  objSimpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		           // this.cellData = (String) objSimpleDateFormat.format(lCell.getDateCellValue());
		        	
		        	this.cellData = excelCell.getDateCellValue().toString();
		        	
		        } else {
		        	this.cellData = String.valueOf(excelCell.getNumericCellValue());
		        	this.cellData = cellData.substring(0, cellData.length()-2);
		        	//excelCell.getNumericCellValue()
		        }
		            			    
		        break;
		    case XSSFCell.CELL_TYPE_BLANK:
		    	this.cellData = "empty";
		        break;
		    case XSSFCell.CELL_TYPE_ERROR:
		    	this.cellData = "error";
		        break;
		    case XSSFCell.CELL_TYPE_BOOLEAN:
		    	this.cellData = String.valueOf(excelCell.getBooleanCellValue());
		    break;
		    default: this.cellData = ""; break;
		}
		
	}
	
	
	public String getCellData(){
		
		return cellData;
	}
	
	public String getExcelCellValue(int rowNumber, int colNumber){
		
		//setCellData (excelSheet.getRow(rowNumber).getCell(colNumber).getStringCellValue());
		
		//setCellData (excelSheet.getRow(rowNumber).getCell(colNumber).getRawValue());
		
		setExcelCell(rowNumber, colNumber);
		setCellData (rowNumber, colNumber);
		
		String lCellValue = getUTF8Encoding(getCellData());
		
		return lCellValue;
	}
	
	public String getExcelCellValue(String lSheetName, int rowNumber, int colNumber){
		
		setExcelSheet(lSheetName);
	//	setCellData (getExcelSheet().getRow(rowNumber).getCell(colNumber).getStringCellValue());
		//String lCellValue = getCellData();
		
		//setCellData (excelSheet.getRow(rowNumber).getCell(colNumber).getRawValue());
		
		setExcelCell(rowNumber, colNumber);
		setCellData (rowNumber, colNumber);
		
		String lCellValue = getUTF8Encoding(getCellData());
		
		return lCellValue;
	}
	
	public String getExcelCellValue(int lSheetIndex, int rowNumber, int colNumber){
		
		setExcelSheet(lSheetIndex);
		//setCellData (getExcelSheet().getRow(rowNumber).getCell(colNumber).getStringCellValue());
		//String lCellValue = getCellData();
		
		//setCellData (excelSheet.getRow(rowNumber).getCell(colNumber).getRawValue());
		
		setExcelCell(rowNumber, colNumber);
		setCellData (rowNumber, colNumber);
		
		String lCellValue = getUTF8Encoding(getCellData());
		
		return lCellValue;
	}
	
	
	public XSSFSheet getExcelSheet(){
		
		return excelSheet;
	}
	
	// constructor
	
	
	
	public ExcelReader(String lFilePath){
		
		setExcelFile(lFilePath);
		setExcelWorkbook(getExcelFile());
		setExcelSheet(0);
		
		try {
			
			this.excelFile.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public int getRowCount(String sheetName){
		
		int index = excelWorkbook.getSheetIndex(sheetName);
		
		return getRowCountAtSheet(index);

	}
	
	
	public boolean isRowNull(int lRow){
		boolean isNull = false;
		
		if(excelSheet.getRow(lRow) == null){
			
			isNull = true;
		}
		
		return isNull;
	}
	
	public int getRowCountAtSheet(int lIndex){
		
		int rowCount = 0;
		
		if(lIndex==-1){

			return rowCount;
			
		}else{
			
			excelSheet = excelWorkbook.getSheetAt(lIndex);
			
			rowCount = excelSheet.getLastRowNum()+1;
			
			return rowCount;
		}

	}
	
	public int getColCountAtSheet(int lSheetIndex, int lRowNum){
		
		int colCount = 0;
		if(lSheetIndex==-1 || lRowNum==-1){

			return 0;
			
		}else{
			
			excelSheet = excelWorkbook.getSheetAt(lSheetIndex);
			
			colCount = 0;
			
			if(excelSheet.getRow(lRowNum) == null){
				
				//System.out.println("The row is null");
				
				colCount = 0;
			}
			else{
				colCount = excelSheet.getRow(lRowNum).getLastCellNum();
			}
			
						
		}

		return colCount;
		
	}
	
	public int getColCount(String sheetName, int lRowNum){
		
		int index = excelWorkbook.getSheetIndex(sheetName);
		
		//System.out.println("the index value is" + index);
		
		return getColCountAtSheet(index, lRowNum);

	}
	
	
	public String getUTF8Encoding(String lStringValue){
				
		String str = null;
		try{
		
		str = new String(lStringValue.getBytes(), "UTF-8");
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return str;
	}
	
	
	
	/*
	
	public String getColName(){
		
	}
	*/
} // end of class


/*



get name of the column 

format picking and validations



reading xml configurations

*/
