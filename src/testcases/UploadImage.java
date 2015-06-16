package testcases;

import io.appium.java_client.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Utility;
import utility.XPaths;



public class UploadImage {

	private String Recipe_Name;
	
	public String getRecipe_Name() {
		return Recipe_Name;
	}
	public void setRecipe_Name(String recipe_Name) {
		Recipe_Name = recipe_Name;
	}
	
	public void Upload_Image(MobileDriver webs, XPaths xp, String R_Name) throws Exception
	{
		
		Utility ut = new Utility();
		MobileDriver md = null;
//		AppiumDriver ad1 = null;
	
		md = (MobileDriver) webs;
		String v1 = xp.Recipe_List.replace("##MARKER", R_Name);
		
		if(ut.IsElementPresent(v1, md))
		{
			md.findElement(By.xpath(v1)).click();
			System.out.println("Recipe" + R_Name + " is found in the List");
			String v2 = xp.Check_Recipe_Field_Value.replace("##MARKER04", R_Name);
			
			if(ut.IsElementPresent(v2, md))
			{
				System.out.println("Edit Recipe Screen is appeared successfully");
				md.findElement(By.xpath(xp.Edit_Recipe_Button)).click();
				
				if(ut.IsElementPresent(xp.Choose_Photo_Button, md))
				{
					System.out.println("Choose button is found");
					md.findElement(By.xpath(xp.Choose_Photo_Button)).click();
					
					if(ut.IsElementPresent(xp.Photo_OK_button, md))
					{
						System.out.println("OK button is found for Image");
						md.findElement(By.xpath(xp.Photo_OK_button)).click();
						
						if(ut.IsElementPresent(xp.Image_selection, md))
						{
							System.out.println("Image is found");
							md.findElement(By.xpath(xp.Image_selection)).click();
							
						}
						else
						{
							System.out.println("Image is not found");
							
						}
						
						
					}
					else
					{
						System.out.println("OK button is not found");
						
					}
					
				}
				else
				{
					System.out.println("Choose photo button is not found");
				}
				
			}
			else
			{
				System.out.println("Edit Recipe screen is not appeared successfully");
			}
		
		}
		else
		{
			System.out.println(R_Name + "Recipe name is not found");
		}
		
		
		
		
		}
		
	
}
