package testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Utility;
import utility.XPaths;

public class AddRecipe {
	
	private String Recipe_Name;
	private String Recipe_Desc;
	private String Recipe_time;
	
	public AddRecipe(String Rec_Name, String Rec_Desc, String Rec_time)
	{
		Recipe_Name = Rec_Name;
		Recipe_Desc = Rec_Desc;
		Recipe_time = Rec_time;
		
	}
	
	public String getRecipeName()
	{
		return Recipe_Name;
	}
	
	public void setRecipeName(String Rec_n)
	{
		Recipe_Name = Rec_n;
	}
	
	
	public String getRecipeDesc()
	{
		return Recipe_Desc;
	}
	public void setRecipeDesc(String Rec_desc)
	{
		
		Recipe_Desc = Rec_desc;
	}
	
	public String getRecipetime()
	{
		return Recipe_time;
	}
	public void setRecipetime(String Rec_t)
	{
		Rec_t = Recipe_time;
	}
	
	public void AddRecipe_func(AppiumDriver webs, XPaths xp, String Rname, String Rdesc, String Rtime) throws Exception
	{
		Utility ut = new Utility();
		MobileDriver md = null;
		
		md = (MobileDriver) webs;
		//MobileElement me = null;
		if(ut.IsElementPresent(xp.Add_button, md))
		{
			md.findElement(By.xpath(xp.Add_button)).click();
			//System.out.println("Add button is found and clicked successfully from Recipe Home Screen");
			
			if(ut.IsElementPresent(xp.Recipe_Name_Field, md))
			{
				//test
				//test commit
				//md.findElement(By.xpath(xp.Recipe_Name_Field)).sendKeys(Rname);
				System.out.println("Add button is found and clicked successfully from Recipe Home Screen");
				((MobileElement) md.findElement(By.xpath(xp.Recipe_Name_Field))).setValue(Rname);
				System.out.println("Recipe name field is found and data is entered successfully");
				
				if(ut.IsElementPresent(xp.Save_Recipe_Button, md))
				{
					md.findElement(By.xpath(xp.Save_Recipe_Button)).click();
					System.out.println("Save Recipe button is found and clicked successfully");
					
					String v0 = xp.Check_Recipe_Name.replace("##MARKER0", Rname);
					
					if(ut.IsElementPresent(v0, md))
					{
						System.out.println("Recipe " + Rname + " is created successfully");
						
						if(ut.IsElementPresent(xp.Return2Rec_Button, md))
						{
							md.findElement(By.xpath(xp.Return2Rec_Button)).click();
							System.out.println("Return to Recipe button is found and clicked successfully");
							
							String v1 = xp.Recipe_List.replace("##MARKER", Rname);
							
							ut.waitFor(v1, md);
							
							if(ut.IsElementPresent(v1, md))
							{
								System.out.println("Recipe " + Rname + "is found in Main Recipe List");
								//webs.quit();
								//test comments
								//123
							}
							else
							{
								System.err.println("Error ===>> Recipe is not found in Main Recipe List");
								md.quit();
							}
							
						}
						else
						{
							System.err.println("Error ===>> Return to Recipe button is not found");
							md.quit();
						}
						
					}
					else
					{
						System.err.println("Error ===>> Recipe Name is not found");
						md.quit();
					}
					
				}
				else
				{
					System.err.println("Error ===>> Save Recipe button is not found");
					md.quit();
				}
				
				
			}
			else
			{                        
				System.err.println("Error ===>> Recipe Name field is not found");
				md.quit();
			}
			
		}
		else 
		{
			System.err.println("Error ===>> Add button is not found");
			md.quit();
		}
		
		
	}
	
	

}
