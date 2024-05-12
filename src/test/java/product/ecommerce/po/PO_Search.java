package product.ecommerce.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.Reporter;

public class PO_Search {

	WebDriver driver;
	public PO_Search(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy (how=How.NAME,using="q")
	private WebElement searchTextbox;
	//driver.findElement(By.name("q")).sendKeys("Computers");
	
	@FindBy (how=How.CLASS_NAME,using ="ut2-icon-search")
	private WebElement clickButton;
	//driver.findElement(By.className("ut2-icon-search")).click();
	
	//methods
	public void setSearchTextbox(String arg) {
		searchTextbox.sendKeys(arg);
		Reporter.log("product entered in search box:" +arg,true);
	}
	
	public void clickSearchButton() {
		clickButton.click();
		Reporter.log("Searchbox button clicked." ,true);
	}
	
	//businesss method
	public void SearchAProduct(String arg) {
		setSearchTextbox(arg);
		clickSearchButton();
		String actual= driver.getTitle();
		String expected = "Search results";
		Assert.assertEquals(actual, expected, "app is not able to search products");
		Reporter.log("Able to search for the products successfully. product:" +arg,true);
	}
}
