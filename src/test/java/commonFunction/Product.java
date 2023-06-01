package commonFunction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
public class Product  {
	WebDriver driver;
	public Product(WebDriver driver) {
		this.driver=driver;

	}
	public static By itemPrice=By.xpath("//span[@class='money cash-money pre-money']");
	public static By itemDescription=By.xpath("(//h1[normalize-space()='SpaceX Water Bottle'])[1]");
	public static By addToCart=By.xpath("//span[normalize-space()='Add to cart']");
	public static By quantity=By.name("quantity");
	public static By cartQuantity=By.xpath("//span[@data-action='increase-quantity']");

	public void verifyProductDetails(float price,String detail) 
	{
        
		//Assert.assertEquals(driver.findElement(itemPrice).getText().replace("$", ""),price);
		Assert.assertEquals(driver.findElement(itemDescription).getText(),detail);
	}

	public void addQuantity(int i)
	{

		for (int j=1;j<=i;j++)
		{

			driver.findElement(cartQuantity).click();	
		}
		driver.findElement(addToCart).click();
	}



}
