          package main;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import testcases.AddCategory;
import testcases.AddRecipe;
import testcases.DeleteRecipe;
import testcases.EditRecipe;
import testcases.EditRecipe1;
import utility.XPaths;
import main.ExcelReader;

public class RunnerClass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver wd = null;
		AppiumDriver ad = null;
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "8.2");
		capabilities.setCapability("deviceName", "iPad 2");
		capabilities.setCapability("app", "/Users/umairrashid/Downloads/iPhoneCoreDataRecipes/build/Release-iphonesimulator/Recipes.app");
		//capabilities.setCapability("app", "/Users/Shared/Jenkins/Home/jobs/Guild2 Job/workspace/build/Debug-iphoneos/CII.app");
		
	
		try {
			ad = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//String lWorkDir = new String(System.getProperty("user.dir"));
		ExcelReader excelFile = new ExcelReader("AddRecipe.xlsx");
		
		XPaths xp = new XPaths();
		

		
				
		// ********* Add Recipe Code **********//
		
		String Rname = null;
		String Rdesc = null;
		String Rtime = null;
		
		AddRecipe ar = new AddRecipe("","","");
		
		
		for(int rows=0; rows<excelFile.getRowCount("AddRecipe"); rows++)
		{
	
			Rname = excelFile.getExcelCellValue(rows, 0);
			Rdesc = excelFile.getExcelCellValue(rows, 1);
			Rtime = excelFile.getExcelCellValue(rows, 2);
			
			System.out.println("The Recipe Name is: " + Rname);
			System.out.println("The Recipe Description is: " + Rdesc);
			System.out.println("The Recipe time is: " + Rtime);
			
			ar.AddRecipe_func(ad, xp, Rname, Rdesc, Rtime);
		
		}
		
	
		
		//********* End Add Recipe Code ************//
		
		
		//********* Edit Recipe Code *************//
		
		
		String Rcp_Name;
		String Rcp_overview;
		String Rcp_time;
		String Rcp_IngName;
		String Rcp_IngAmnt;
		
		EditRecipe1 er = new EditRecipe1();
		
		for(int rows=0; rows<excelFile.getRowCount("EditRecipe"); rows++)
		{
		
			Rcp_Name = excelFile.getExcelCellValue(rows, 0);
			Rcp_overview = excelFile.getExcelCellValue(rows, 1);
			Rcp_time = excelFile.getExcelCellValue(rows, 2);
			Rcp_IngName = excelFile.getExcelCellValue(rows, 3);
			Rcp_IngAmnt = excelFile.getExcelCellValue(rows, 4);
			
			
			System.out.println("The Recipe Name is: " + Rcp_Name);
			System.out.println("The Recipe overview is: " + Rcp_overview);
			System.out.println("The Recipe time is: " + Rcp_time);
			System.out.println("The Recipe Ingredients is: " + Rcp_IngName);
			System.out.println("The Recipe Ingredient amount is: " + Rcp_IngAmnt);
			
			er.Edit_Recipe(ad, xp, Rcp_Name, Rcp_overview, Rcp_time, Rcp_IngName, Rcp_IngAmnt);
			
		}
		//closeSimulatorAndInstruments();
	//	appium = Runtime.getRuntime().exec("/usr/local/bin/appium");
		
		//********* End Edit Recipe Code ************//
		
		
		//********* Starts Add Category in Recipe Code ************//
		
		String R_name_4_category;
		String R_category;
		
		AddCategory ac = new AddCategory();
		
		for(int rows=0; rows<excelFile.getRowCount("AddCategory"); rows++)
		{
			
			R_name_4_category = excelFile.getExcelCellValue(rows, 0);
			R_category = excelFile.getExcelCellValue(rows, 1);
			
			System.out.println("The Recipe Name is: " + R_name_4_category);
			System.out.println("The Recipe Name is: " + R_category);
			
			ac.AddCategory(ad, xp, R_name_4_category, R_category);
			
			
		}
		
		
		//********* End Add Category in Recipe Code ************//
		
		
		//********* Starts Delete Recipe Code ************//

		String Rcp_delete_Name;
		
		DeleteRecipe dr = new DeleteRecipe();
		
		for(int rows=0; rows<excelFile.getRowCount("DeleteRecipe"); rows++)
		{
			
			Rcp_delete_Name = excelFile.getExcelCellValue(rows, 0);
			
			System.out.println("The Recipe Name is: " + Rcp_delete_Name);
			
			dr.DeleteRecipe(ad, xp, Rcp_delete_Name);
			
		}
		
		//********* Ends Delete Recipe Code ************//
		
		
		ad.quit();
		
	}

}



