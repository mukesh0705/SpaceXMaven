package commonFunction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class CartPage  
{
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		this.driver=driver;

	}
public By totalPrice=By.xpath("//span[normalize-space()='$140.00']");
    
    public void verifyPrice(int q, double price)
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String total = driver.findElement(this.totalPrice).getText();
        Reporter.log("Items Added in to Card verified:::  Actual price = "+total+",  4 X Single item price   = $"+(q*price)+"0",true);
        Assert.assertEquals(total,"$"+(q*price)+"0");
    }

}
