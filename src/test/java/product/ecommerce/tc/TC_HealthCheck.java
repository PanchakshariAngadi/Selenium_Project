package product.ecommerce.tc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import product.ecommerce.po.PO_Search;
import product.ecommerce.utils.BrowserManager;

public class TC_HealthCheck {
    
	@Test
	@Parameter({ "browser","url" })
	public void ecommerce_search(String browser, String url) {
		WebDriver driver = BrowserManager.getDriver(browser ,url);
		//driver.get(url);
		//creating the object with the help of pagefactory
		PO_Search obj = PageFactory.initElements(driver, PO_Search.class);
		obj.SearchAProduct("computer");
		
	}
}
