package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import commonFunction.CartPage;
import commonFunction.Product;
import commonFunction.SearchPage;
import config.AppUtil;

public class TestDrive extends AppUtil 
{

	@Test(priority = 0,description = "Test Get API and Validate Content")
	public void ProductVerification() 
	{
		SearchPage frontPage=PageFactory.initElements(driver, SearchPage.class);
		frontPage.searchItems("spacex");
		frontPage.verify_product();

	}
	@Test(priority = 1,description = "Shop SpaceX-Search, Add to Cart")
	public void addQuantity() 
	{

		Product product=PageFactory.initElements(driver,Product.class);
		product.verifyProductDetails(35f,"SPACEX WATER BOTTLE");
		product.addQuantity(3);
		/*RestAssured.given()
		.contentType(ContentType.JSON)
		.when()
		.get("https://swapi.dev/api/people/")
		.then()
		.assertThat()
		.body("results[2].name", equalTo("R2-D2"))
		.and()
		.body("results[2].skin_color", equalTo("white, blue"));*/
	}
	@Test(priority = 2,description = "Test Get API and Validate Cart Price")
	public void cartVerification() {
		CartPage cart=PageFactory.initElements(driver, CartPage.class);
		cart.verifyPrice(4,35);
	}
}


