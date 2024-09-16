package Project2.FlipkartJen;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductSearch extends TestClass {


	@Test
	public void testSearchProduct() throws IOException {
		 {
			// Test Case 
			String flipkartURL = config.getProperty("flipkart.url");
			driver.get(flipkartURL);

			String productToSearch = config.getProperty("product.to.search");
			homePage.searchProduct(productToSearch);

			test = extent.createTest("Product Search", "Automating Product Search on flipkart");

			// Assertions
			Assert.assertTrue(homePage.isSearchResultDisplayed(), "Search result not displayed.");

			// For this example, just pause the execution to observe the result.
			try {
				Thread.sleep(5000); // Sleep for 5 seconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
