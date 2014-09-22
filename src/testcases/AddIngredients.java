package testcases;

import io.appium.java_client.*;

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
	
	
	public void Add_Ingredient(MobileDriver webs, XPaths xp, String Iname, String Iamount)
	{
		
		Utility ut = new Utility();
		MobileDriver md = null;
		
		md = (MobileDriver) webs;
		
		if(ut.IsElementPresent(xp.Add_Ingredient_button, md))
		{
			md.findElement(By.xpath(xp.Add_Ingredient_button)).click();
			System.out.println("Add Ingredient button is found and clicked successfully");
			
			if(ut.IsElementPresent(xp.Check_Ingredient_Screen_Appear, md))
			{
				System.out.println("Ingredient screen is appeared successfully");
				
				if(ut.IsElementPresent(xp.Ingredient_Name_Field, md))
				{
					md.findElement(By.xpath(xp.Ingredient_Name_Field)).sendKeys(Iname);
					md.findElement(By.xpath(xp.Ingredient_Amount_Field)).sendKeys(Iamount);
					System.out.println("Ingredient name and amount is entered successfully");
					
					if(ut.IsElementPresent(xp.Ingredient_Save_Button, md))
					{
						md.findElement(By.xpath(xp.Ingredient_Save_Button)).click();
						System.out.println("Save Ingredient button is found and clicked successfully");
						
						String v3 = xp.Check_Ingredient_Added.replace("##MARKER05", Iname);
						
						if(ut.IsElementPresent(v3, md))
						{
							System.out.println("Ingredient is added successfully");
							
						}
						else
						{
							System.err.println("Ingredient is not added successfully");
							md.quit();
						}
						
					}
					else
					{
						System.err.println("Save Ingredient button is not found");
						md.quit();
					}
					
				}
				else
				{
					System.err.println("Ingredient name field is not appeared successfully");
					md.quit();
				}
				
			}
			else
			{
				System.err.println("Ingredient screen is not appeared successfully");
				md.quit();
			}
			
		}
		else
		{
			System.err.println("Add Ingredient button is not found");
			md.quit();
		}
		
	}
	
	
	
}
