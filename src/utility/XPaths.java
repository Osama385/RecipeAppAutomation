package utility;

public class XPaths {

	
	//XPATHs for Add Recipe
	
	//public String Add_button = "//UIANavigationBar/descendant::UIAButton[@name='Add']"; // Add button Xpath
	
	public String Recipe_Name_Field = "//UIATextField[@value='Recipe Name']";
	
	public String Save_Recipe_Button = "//UIANavigationBar/descendant::UIAButton[@name='Save']";
	
	public String Cancel_Recipe_Button = "//UIANavigationBar/descendant::UIAButton[@name='Cancel']";
	
	public String Edit_Recipe_Button = "//UIANavigationBar/descendant::UIAButton[@name='Edit']";
	
	public String Return2Rec_Button = "//UIANavigationBar/descendant::UIAButton[@name='Recipes']";
	
	public String Check_Recipe_Name = "//UIANavigationBar/descendant::UIAStaticText[@name='##MARKER0']";
	
	public String Recipe_List = "//UIATableView/following::UIAStaticText[contains(@name,'##MARKER')]";
	
	
	
	//XPATHs for Delete Recipe
	
	public String Edit_button = "//UIANavigationBar/descendant::UIAButton[@name='Edit']";
	
	public String Check_Recipe_In_List = "//UIATableView/following::UIAStaticText[contains(@name,'##MARKER01')]";
	
	public String Delete_Switch_Recipe = "//UIATableView/following::UIASwitch[contains(@name,'##MARKER02')]";
	
	public String Delete_Button_Recipe = 
			"//UIATableView/following::UIASwitch[contains(@name,'##MARKER03')]/parent::UIATableCell/child::UIAButton[@name='Delete']";
	
	

	//XPaths for Edit Recipe
	
	public String Check_Recipe_Field_Value = "//UIATableView/descendant::UIATextField[contains(@value,'##MARKER04')]";
	
	public String Overview_field = "//UIATableView/descendant::UIATextField[@value='Overview']";
	
	public String Time_field = "//UIATableView/descendant::UIATextField[@value='Time']";
	
	public String Add_Ingredient_button = "//UIATableCell/descendant::UIAButton[@name='Insert Add Ingredient']";
	
	public String Check_Ingredient_Screen_Appear = "//UIANavigationBar/descendant::UIAStaticText[@name='Ingredient']";
	
	public String Ingredient_Name_Field = "//UIATextField[@value='Name']";
	//public String Ingredient_Name_Field = "//UIATableCell/descendant::UIAStaticText[@name='Ingredient']/following-sibling::UIATextField";
	public String Ingredient_Amount_Field = "//UIATextField[@value='Amount']";
	
	public String Ingredient_Save_Button = "//UIANavigationBar[@name='Ingredient']/descendant::UIAButton[@name='Save']";
	
	public String Check_Ingredient_Added = "//UIATableCell/descendant::UIAStaticText[contains(@name,'##MARKER05')]";
	
	public String Done_Button_onEditScreen = "//UIANavigationBar/descendant::UIAButton[@name='Done']";
	
	
	
	//Add Category XPaths
	
	public String Check_Recipe_In_List1 = "//UIATableView/following::UIAStaticText[contains(@name,'##MARKER12')]";
	
	public String Recipe_Cat_MoreInfo_button = "//UIATableCell/following::UIAElement[contains(@name,'More info')]";
	
	public String Verify_Category_Screen = "//UIANavigationBar/descendant::UIAStaticText[@name='Category']";
	
	public String Category_of_Recipe = "//UIATableView/descendant::UIAStaticText[@name='##MARKER13']";
	
	public String Done_Button_onCategroy = "//UIANavigationBar/descendant::UIAStaticText[@name='Category']/following-sibling::UIAButton[@name='Done']";
	
	public String Chk_Cat_Selected = "//UIATableView/descendant::UIATableCell/descendant::UIAStaticText[@name='##MARKER14']";
	
	public String Check_Recipe_Field_Value1 = "//UIATableView/descendant::UIATextField[contains(@value,'##MARKER11')]";
	
	
	//public String Recipe_Created = "//UIANavigationBar/descendant::UIAStaticText[@name='rec']";
	
	//UIATableView/UIATableCell[8]/descendant::UIAStaticText[contains(@name,'rec')]


}
