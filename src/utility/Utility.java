package utility;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;




public class Utility{



	public boolean IsElementPresent(String xpat, WebDriver elem)
	{
		boolean s = false;
		try
		{
			List<WebElement> ele = elem.findElements(By.xpath(xpat));
			if(ele.size() > 0)
				s= true;

		}
		catch (Exception e)
		{
			System.out.println(xpat + " not found ");
			//e.printStackTrace();

		}
		return s;
	}



	public void waitFor(String locator, WebDriver el) throws Exception {

		int count = 0;
		while(count<50)
		{
			if(IsElementPresent(locator, el))
			{
				Thread.sleep(1000);
				break;
			}
		}
	}


	/*public void hoverAction(String x, String y, WebDriver driver) throws InterruptedException {

		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath(x));
		action.moveToElement(we).build();
		action.perform();


		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath(x));
		action.moveToElement(we).build().perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath(y))).click().build().perform();


	}*/



}
