package testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Utility;
import utility.XPaths;

public class AddCategory {

	private String Recipe_Name;
	private String Recipe_Category;
	
	public String getRecipe_Name() {
		return Recipe_Name;
	}
	public void setRecipe_Name(String recipe_Name) {
		Recipe_Name = recipe_Name;
	}
	public String getRecipe_Category() {
		return Recipe_Category;
	}
	public void setRecipe_Category(String recipe_Category) {
		Recipe_Category = recipe_Category;
	}
	
	public void AddCategory(AppiumDriver webs, XPaths xp, String Recipe_name, String Recipe_cat)
	{
		MobileDriver md = null;
		
		md = (MobileDriver) webs;
		
		Utility ut = new Utility();
		String v1 = xp.Check_Recipe_In_List1.replace("##MARKER12", Recipe_name);
		
		if(ut.IsElementPresent(v1, md))
		{
			md.findElement(By.xpath(v1)).click();
			System.out.println("Recipe" + Recipe_name + " is found in the List");
			
			//String v2 = xp.Check_Recipe_Field_Value.replace("##MARKER11", Recipe_name);
			
			if(ut.IsElementPresent(xp.Edit_Recipe_Button, md))
			{
				System.out.println("Edit Recipe Screen is appeared successfully");
				md.findElement(By.xpath(xp.Edit_Recipe_Button)).click();
				System.out.println("Edit Recipe Button is clicked successfully");
				
				if(ut.IsElementPresent(xp.Recipe_Cat_MoreInfo_button, md))
				{
					md.findElement(By.xpath(xp.Recipe_Cat_MoreInfo_button)).click();
					System.out.println("More Info Category button is clicked successfully");
					
					if(ut.IsElementPresent(xp.Verify_Category_Screen, md))
					{
						System.out.println("Category Selection screen is appeared successfully");
						
						String v3 = xp.Category_of_Recipe.replace("##MARKER13", Recipe_cat);
						
						if(ut.IsElementPresent(v3, md))
						{
							md.findElement(By.xpath(v3)).click();
							System.out.println(Recipe_cat + "category is selected successfully");
							
							if(ut.IsElementPresent(xp.Done_Button_onCategroy, md))
							{
								md.findElement(By.xpath(xp.Done_Button_onCategroy)).click();
								System.out.println("Done button is found on Category screen and clicked successfully");
								
								String v4 = xp.Chk_Cat_Selected.replace("##MARKER14", Recipe_cat);
								
								if(ut.IsElementPresent(v4, md))
								{
									System.out.println("Category is selected and added successfully");
									
									if(ut.IsElementPresent(xp.Done_Button_onEditScreen, md))
									{
										md.findElement(By.xpath(xp.Done_Button_onEditScreen)).click();
										System.out.println("Done button is found and clicked from Edit Recipe Screen");
										
										if(ut.IsElementPresent(xp.Return2Rec_Button, md))
										{
											md.findElement(By.xpath(xp.Return2Rec_Button)).click();
											
											//((MobileElement) md.findElement(By.xpath(xp.Return2Rec_Button))).
											
											System.out.println("****Edit functionality for adding Category is working successfully ****");
											
										}
										else
										{
											System.err.println("===>> Return to recipe button is not clicked successfully");
											md.quit();
										}
										
									}
									else
									{
										System.err.println("===>> Done button on Edit Recipe screen is not found");
										md.quit();
									}
								}
								else
								{
									System.err.println("===>> Category is not added successfully");
									md.quit();
								}
								
							}
							else
							{
								System.err.println("===>> Done button is not found on Category Screen");
								md.quit();
							}
							
						}
						else
						{
							System.err.println("===>> Category is not available in list");
							md.quit();
						}
						
						
					}
					else
					{
						System.err.println("===>> Category Selection screen is not appeared successfully");
						md.quit();
						
					}
					
					
				}
				else
				{
					System.err.println("===>> More info Category button is not found");
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
			System.err.println("===>> No recipe available with name" + Recipe_name + "to add Category");
			md.quit();
		}
		
	}
	
	
	
}
