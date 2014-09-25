package testcases;

import io.appium.java_client.MobileDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Utility;
import utility.XPaths;

public class DeleteRecipe {
	
	private String Recipe_Name;
	
	public String getRecipeName()
	{
		return Recipe_Name;
	}
	
	public void setRecipeName(String recn)
	{
		Recipe_Name = recn;
	}
	
	public void DeleteRecipe(MobileDriver webs, XPaths xp, String del_Rname)
	{
		Utility ut = new Utility();
		MobileDriver md = null;
		
		md = (MobileDriver) webs;
		String vv1 = xp.Check_Recipe_In_List.replace("##MARKER01", del_Rname);
			
		if(ut.IsElementPresent(vv1, md))
		{
			System.out.println("Recipe is available in Main Recipe list");
			
			if(ut.IsElementPresent(xp.Edit_button, md))
			{
				md.findElement(By.xpath(xp.Edit_button)).click();
				System.out.println("Edit button is clicked successfully");
				
				String vv2 = xp.Delete_Switch_Recipe.replace("##MARKER02", del_Rname);
				if(ut.IsElementPresent(vv2, md))
				{
					md.findElement(By.xpath(vv2)).click();
					System.out.println("Delete switch is found");
					
					String vv3 = xp.Delete_Button_Recipe.replace("##MARKER03", del_Rname);
					if(ut.IsElementPresent(vv3, md))
					{
						md.findElement(By.xpath(vv3)).click();
						System.out.println("Delete button is found and Clicked successfully");
						
						if(ut.IsElementPresent(xp.Done_Button_onEditScreen, md))
						{
							md.findElement(By.xpath(xp.Done_Button_onEditScreen)).click();
							System.out.println("Done button after Delete Recipe is found and clicked successfully");
							
						}
						else
						{
							System.err.println("===>> Done Button after Delete Recipe is not found");
							md.quit();
						}
						
					}
					else
					{
						System.err.println("===>> Delete button is not found");
						md.quit();
					}
					
				}
				else
				{
					System.err.println("===>> Delete switch is not found");
					md.quit();
				}
					
				
			}
			else
			{
				System.err.println("===>> Edit button is not found");
				md.quit();
					
			}
		}
		else
		{
			System.err.println("===>> Recipe is not available in Main Recipe List");
			md.quit();
		}
			
		
	}

}
