package commonFunction;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class SearchPage {
	WebDriver driver;
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		
		}
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement clickSearchBtn;
	@FindBy(xpath = "//input[@id='search-input']")
	WebElement EnterKeyValue;
	@FindBy(xpath = "(//a[normalize-space()='View all'])[1]")
	WebElement clickViewAllbtn;
	@FindBy(xpath = "//span[@class='ProductItem__Title Heading']")
	List<WebElement> AllProductTitle;
	@FindBy(xpath = "//span[@class='money pre-money']")
	List<WebElement> AllProductPrice;
	@FindBy(xpath = "(//span[@class='ProductItem__Title Heading'])[2]")
	WebElement clickOnProduct;
	@FindBy(xpath = "(//h1[normalize-space()=\"Men's SpaceX Polo\"])[1]")
	WebElement ProductTitle;
	
	//String Expected=this.clickOnProduct.getText();
	
	public void searchItems(String keyValue) {
		this.clickSearchBtn.click();
		this.EnterKeyValue.sendKeys(keyValue);
		this.clickViewAllbtn.click();
		Reporter.log("No. of Total product in this page::: "+AllProductTitle.size());
		for(int i=0;i<this.AllProductTitle.size();i++){
			Reporter.log(this.AllProductTitle.get(i).getText()+"  \t             \n\t"+this.AllProductPrice.get(i).getText(),true);
		}
		
		
	}
	public boolean verify_product() {
		String Expected =this.clickOnProduct.getText();
		this.clickOnProduct.click();
		String Actual=this.ProductTitle.getText();
		if (Actual.toLowerCase().contains(Expected.toLowerCase())) {
			Reporter.log("Product verified:: "+Expected+"\n"+Actual,true);
			return true;
			
		} else {
			Reporter.log("Product Not verified:: "+Expected+"  "+Actual,true);
			return false;

		}
	}

	}


