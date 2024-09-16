package Project2.FlipkartJen;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends TestClass {

	@Test
	public void testAddToCart() throws IOException {
 {
			String flipkartURL = config.getProperty("flipkart.url");
			driver.get(flipkartURL);

			String productToSearch = config.getProperty("product.to.search");
			homePage.searchProduct(productToSearch);

			String ProductURL = config.getProperty("product.url");
			driver.get(ProductURL);
			homePage.addToCart();
			
			Assert.assertEquals(homePage.getProperty(flipkartURL), flipkartURL);

			// For this example, just pause the execution to observe the result.
			try {
				Thread.sleep(5000); // Sleep for 5 seconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		
	}
}
