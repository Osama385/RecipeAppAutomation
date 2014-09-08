package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Utility;
import utility.XPaths;

public class EditRecipe {
	
	private String Recipe_Name;
	
	private String Recipe_Overview;
	
	private String Recipe_time;
	
	private String Recipe_Ingredient_name;
	
	private String Recipe_Ingredient_amount;

	public String getRecipe_Overview() {
		return Recipe_Overview;
	}

	public void setRecipe_Overview(String recipe_Overview) {
		Recipe_Overview = recipe_Overview;
	}

	public String getRecipe_time() {
		return Recipe_time;
	}

	public void setRecipe_time(String recipe_time) {
		Recipe_time = recipe_time;
	}

	public String getRecipe_Ingredient_name() {
		return Recipe_Ingredient_name;
	}

	public void setRecipe_Ingredient_name(String recipe_Ingredient_name) {
		Recipe_Ingredient_name = recipe_Ingredient_name;
	}

	public String getRecipe_Ingredient_amount() {
		return Recipe_Ingredient_amount;
	}

	public void setRecipe_Ingredient_amount(String recipe_Ingredient_amount) {
		Recipe_Ingredient_amount = recipe_Ingredient_amount;
	}
	public String getRecipe_Name() {
		return Recipe_Name;
	}

	public void setRecipe_Name(String recipe_Name) {
		Recipe_Name = recipe_Name;
	}

	public void Edit_Recipe(WebDriver webs, XPaths xp, String R_Name, String R_overview, String R_time, String R_IngName, String R_IngAmnt)
	{
		
		Utility ut = new Utility();
		
		String v1 = xp.Recipe_List.replace("##MARKER", R_Name);
		
		if(ut.IsElementPresent(v1, webs))
		{
			webs.findElement(By.xpath(v1)).click();
			System.out.println("Recipe" + R_Name + " is found in the List");
			
			String v2 = xp.Check_Recipe_Field_Value.replace("##MARKER04", R_Name);
			
			if(ut.IsElementPresent(v2, webs))
			{
				System.out.println("Edit Recipe Screen is appeared successfully");
				webs.findElement(By.xpath(xp.Edit_Recipe_Button)).click();
				
				if(ut.IsElementPresent(xp.Overview_field, webs))
				{
					webs.findElement(By.xpath(xp.Overview_field)).sendKeys(R_overview);
					System.out.println("Overview field is found and data is entered successfully");
					
					if(ut.IsElementPresent(xp.Time_field, webs))
					{
						webs.findElement(By.xpath(xp.Time_field)).sendKeys(R_time);
						System.out.println("Time field is found and data is entered successfully");
						
						if(ut.IsElementPresent(xp.Add_Ingredient_button, webs))
						{
							webs.findElement(By.xpath(xp.Add_Ingredient_button)).click();
							System.out.println("Add Ingredient button is found and clicked successfully");
							
							if(ut.IsElementPresent(xp.Check_Ingredient_Screen_Appear, webs))
							{
								System.out.println("Ingredient screen is appeared successfully");
								
								if(ut.IsElementPresent(xp.Ingredient_Name_Field, webs))
								{
									webs.findElement(By.xpath(xp.Ingredient_Name_Field)).sendKeys(R_IngName);
									System.out.println("Ingredient Name is added successfully");
									
									try {
										Thread.sleep(5000);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
										webs.quit();
									}
									System.out.println(R_IngAmnt);
									webs.findElement(By.xpath(xp.Ingredient_Amount_Field)).sendKeys(R_IngAmnt);
									
									
									System.out.println("Ingredient name and amount is entered successfully");
							
									if(ut.IsElementPresent(xp.Ingredient_Save_Button, webs))
									{
										webs.findElement(By.xpath(xp.Ingredient_Save_Button)).click();
										System.out.println("Save Ingredient button is found and clicked successfully");
										
										String v3 = xp.Check_Ingredient_Added.replace("##MARKER05", R_IngName);
										if(ut.IsElementPresent(v3, webs))
										{
											System.out.println("Ingredient is added successfully");
											
											if(ut.IsElementPresent(xp.Done_Button_onEditScreen, webs))
											{
												webs.findElement(By.xpath(xp.Done_Button_onEditScreen)).click();
												System.out.println("Done button is clicked successfully");
												
												if(ut.IsElementPresent(xp.Return2Rec_Button, webs))
												{
													webs.findElement(By.xpath(xp.Return2Rec_Button)).click();
													System.out.println("**** Edit functionality is working successfully ****");
													
												}
												else
												{
													System.err.println("Return to recipe button is not clicked successfully");
													webs.quit();
												}
												
												
											}
											else
											{
												System.err.println("Done button is not found from Edit Recipe");
												webs.quit();
											}
											
										}
										else
										{
											System.err.println("Ingredient is not added successfully");
											webs.quit();
										}
										
									}
									else
									{
										System.err.println("Save Ingredient button is not found");
										webs.quit();
									}
									
								}
								else
								{
									System.err.println("Ingredient name field is not appeared successfully");
									webs.quit();
								}
								
							}
							else
							{
								System.err.println("Ingredient screen is not appeared successfully");
								webs.quit();
							}
							
						}
						else
						{
							System.err.println("Add Ingredient button is not found");
							webs.quit();
						}
						
					}
					else
					{
						System.err.println("Recipe Time Field is not found");
						webs.quit();
					}
					
				}
				else
				{
					System.err.println("Overview Field is not found");
					webs.quit();
				}
			}
			else
			{
				System.err.println("Edit Recipe Screen is not appeared successfully");
				webs.quit();
			}
		}
		else
		{
			System.err.println("Recipe is not found in Main Recipe List");
			webs.quit();
			
		}
		
	}

	
	
	

}
