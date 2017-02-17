package com.sqa.yt;

import org.testng.annotations.*;

import com.sqa.yt.helpers.*;

public class WilliamsSonomaTest extends BasicTest {

	/**
	 * @param baseUrl
	 */
	public WilliamsSonomaTest(String baseUrl) {
		super("http://www.williams-sonoma.com/");
		// greeting Auto-generated constructor stub
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 2, "Artisan Mini Stand Mixer", 154.23 },
				new Object[] { 3, "Valentine's Day Dinner Collection", 438.99 },
				new Object[] { 5, "Williams Sonoma Cherry Lover's Mix", 238.59 },
				new Object[] { 1, "Peacock Elegance", 48.59 },
				new Object[] { 3, "Turquoise ad Raffia Box", 122.59 } };
	}

	@Test(dataProvider = "dp")
	public void test(int quantity, String itemName, double totalPrice)
			throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("Searching" + getBaseUrl() + "for" + itemName);
		System.out.println(
				"Adding" + quantity + "to cart for a total of $" + totalPrice + ".");
	}
}
