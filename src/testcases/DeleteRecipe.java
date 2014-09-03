package testcases;

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
	
	public void DeleteRecipe(WebDriver webs, XPaths xp, String del_Rname)
	{
		Utility ut = new Utility();
		
		String vv1 = xp.Check_Recipe_In_List.replace("##MARKER01", del_Rname);
			
		if(ut.IsElementPresent(vv1, webs))
		{
			System.out.println("Recipe is available in Main Recipe list");
			
			if(ut.IsElementPresent(xp.Edit_button, webs))
			{
				webs.findElement(By.xpath(xp.Edit_button)).click();
				System.out.println("Edit button is clicked successfully");
				
				String vv2 = xp.Delete_Switch_Recipe.replace("##MARKER02", del_Rname);
				if(ut.IsElementPresent(vv2, webs))
				{
					webs.findElement(By.xpath(vv2)).click();
					System.out.println("Delete switch is found");
					
					String vv3 = xp.Delete_Button_Recipe.replace("##MARKER03", del_Rname);
					if(ut.IsElementPresent(vv3, webs))
					{
						webs.findElement(By.xpath(vv3)).click();
						System.out.println("Delete button is found and Clicked successfully");
						
					}
					else
					{
						System.err.println("Delete button is not found");
						webs.quit();
					}
					
				}
				else
				{
					System.err.println("Delete switch is not found");
					webs.quit();
				}
					
				
			}
			else
			{
				System.err.println("Edit button is not found");
				webs.quit();
					
			}
		}
		else
		{
			System.err.println("Recipe is not available in Main Recipe List");
			webs.quit();
		}
			
					
			
		
	}

}
