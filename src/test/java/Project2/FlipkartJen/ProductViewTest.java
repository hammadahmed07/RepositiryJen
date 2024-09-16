package Project2.FlipkartJen;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductViewTest extends TestClass {

	@Test
	public void testViewProductView() throws IOException {

		 {
			String flipkartURL = config.getProperty("flipkart.url");
			driver.get(flipkartURL);

			String productToSearch = config.getProperty("product.to.search");
			homePage.searchProduct(productToSearch);

			homePage.viewProduct();
			
			Assert.assertEquals(homePage.getProperty(flipkartURL), "https://www.flipkart.com/");
			// For this example, just pause the execution to observe the result.
			try {
				Thread.sleep(5000); // Sleep for 5 seconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
