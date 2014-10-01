package testcases;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Utility;
import utility.XPaths;
public class EditRecipe1 {

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

	public void Edit_Recipe(MobileDriver webs, XPaths xp, String R_Name, String R_overview, String R_time, String R_IngName, String R_IngAmnt) throws Exception
	{

		Utility ut = new Utility();
		MobileDriver md = null;
		AppiumDriver ad1 = null;
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

				if(ut.IsElementPresent(xp.Overview_field, md))
				{
					//md.findElement(By.xpath(xp.Overview_field)).sendKeys(R_overview);
					((MobileElement) md.findElement(By.xpath(xp.Overview_field))).setValue(R_overview);

					System.out.println("Overview field is found and data is entered successfully");

					if(ut.IsElementPresent(xp.Time_field, md))
					{
						//md.findElement(By.xpath(xp.Time_field)).sendKeys(R_time);

						((MobileElement) md.findElement(By.xpath(xp.Time_field))).setValue(R_time);

						System.out.println("Time field is found and data is entered successfully");

						if(ut.IsElementPresent(xp.Add_Ingredient_button, md))
						{
							md.findElement(By.xpath(xp.Add_Ingredient_button)).click();
							System.out.println("Add Ingredient button is found and clicked successfully");

							if(ut.IsElementPresent(xp.Check_Ingredient_Screen_Appear, md))
							{
								System.out.println("Ingredient screen is appeared successfully");

								if(ut.IsElementPresent(xp.Ingredient_Name_Field, md))
								{
									//md.findElement(By.xpath(xp.Ingredient_Name_Field)).sendKeys(R_IngName);
									((MobileElement) md.findElement(By.xpath(xp.Ingredient_Name_Field))).setValue(R_IngName);


									System.out.println("Ingredient Name is added successfully");

									//((MobileElement) md.findElement(By.xpath(xp.Ingredient_Amount_Field))).setValue(R_IngAmnt);

									if(ut.IsElementPresent(xp.Ingredient_Amount_Field, md))
									{
										//((MobileElement) md.findElement(By.xpath("//UIATableCell/descendant::UIATextField[@value='Amount']"))).setValue(R_IngAmnt);
										System.out.println("Ingredient amount field is not found");

										if(ut.IsElementPresent(xp.Ingredient_Save_Button, md))

										{

											md.findElement(By.xpath(xp.Ingredient_Save_Button)).click();

											System.out.println("Save Ingredient button is found and clicked successfully");


											String v3 = xp.Check_Ingredient_Added.replace("##MARKER05", R_IngName);

											if(ut.IsElementPresent(v3, md))

											{

												System.out.println("Ingredient is added successfully");


												if(ut.IsElementPresent(xp.Done_Button_onEditScreen, md))

												{

													md.findElement(By.xpath(xp.Done_Button_onEditScreen)).click();

													System.out.println("Done button is clicked successfully");


													if(ut.IsElementPresent(xp.Return2Rec_Button, md))

													{

														md.findElement(By.xpath(xp.Return2Rec_Button)).click();

														System.out.println("**** Edit functionality is working successfully ****");


													}

													else

													{

														System.err.println("Error ===>> Return to recipe button is not clicked successfully");

														md.quit();

													}



												}

												else

												{

													System.err.println("Error ===>> Done button is not found from Edit Recipe");
													md.quit();

												}


											}

											else

											{

												System.err.println("Error ===>> Ingredient is not added successfully");

												md.quit();

											}


										}

										else

										{

											System.err.println("Error ===>> Save Ingredient button is not found");

											md.quit();

										}

									}
									else
									{
										System.err.println("Error ===>> Ingredient Amount field is not found");
										md.quit();
									}

								}
								else
								{
									System.err.println("Error ===>> Ingredient name field is not appeared successfully");
									md.quit();
								}

							}
							else
							{
								System.err.println("Error ===>> Ingredient screen is not appeared successfully");
								md.quit();
							}

						}
						else
						{
							System.err.println("Error ===>> Add Ingredient button is not found");
							md.quit();
						}

					}
					else
					{
						System.err.println("Error ===>> Recipe Time Field is not found");
						md.quit();
					}

				}
				else
				{
					System.err.println("Error ===>> Overview Field is not found");
					md.quit();
				}
			}
			else
			{
				System.err.println("Error ===>> Edit Recipe Screen is not appeared successfully");
				md.quit();
			}
		}
		else
		{
			System.err.println("Error ===>> Recipe is not found in Main Recipe List");
			md.quit();

		}

	}



}



