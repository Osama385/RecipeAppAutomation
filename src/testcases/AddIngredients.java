package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Utility;
import utility.XPaths;

public class AddIngredients {

	
	//WebElement e = new WebElement();2
	
	private String Ingredient_name;
	private String Ingredient_amount;
	
	
	public String getIngredient_name() {
		return Ingredient_name;
	}
	public void setIngredient_name(String ingredient_name) {
		Ingredient_name = ingredient_name;
	}
	public String getIngredient_amount() {
		return Ingredient_amount;
	}
	public void setIngredient_amount(String ingredient_amount) {
		Ingredient_amount = ingredient_amount;
	}
	
	
	public void Add_Ingredient(WebDriver webs, XPaths xp, String Iname, String Iamount)
	{
		
		Utility ut = new Utility();
		
		if(ut.IsElementPresent(xp.Add_Ingredient_button, webs))
		{
			webs.findElement(By.xpath(xp.Add_Ingredient_button)).click();
			System.out.println("Add Ingredient button is found and clicked successfully");
			
			if(ut.IsElementPresent(xp.Check_Ingredient_Screen_Appear, webs))
			{
				System.out.println("Ingredient screen is appeared successfully");
				
				if(ut.IsElementPresent(xp.Ingredient_Name_Field, webs))
				{
					webs.findElement(By.xpath(xp.Ingredient_Name_Field)).sendKeys(Iname);
					webs.findElement(By.xpath(xp.Ingredient_Amount_Field)).sendKeys(Iamount);
					System.out.println("Ingredient name and amount is entered successfully");
					
					if(ut.IsElementPresent(xp.Ingredient_Save_Button, webs))
					{
						webs.findElement(By.xpath(xp.Ingredient_Save_Button)).click();
						System.out.println("Save Ingredient button is found and clicked successfully");
						
						String v3 = xp.Check_Ingredient_Added.replace("##MARKER05", Iname);
						
						if(ut.IsElementPresent(v3, webs))
						{
							System.out.println("Ingredient is added successfully");
							
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
	
	
	
}
