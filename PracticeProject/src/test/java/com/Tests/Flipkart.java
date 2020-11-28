// stale element reference: element is not attached to the page document
//=========================================================================
/*Open Url: https://www.flipkart.com (Do not Login) and validate the page is opened by checking the title and a page locator.
Search for TV and check search results is displayed.
Fetch all the products name and their price, save it in a Hash Map collection with key as Product name and value as price. Price should be integer. Example:  HashMap<String, Integer>
Print the Hash Map.
Print the Product which has the highest price.
Print the Product which has the lowest price
Use find element, find element to locate the objects in the page.
Use Maven and test ng to run the test.
Use reporter.log to log the steps.
Use test ng assert for validations.
No need to login in the application.
*/
package com.Tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Flipkart {

	@Test
	public void TestFlipkartSearch() throws InterruptedException {
		
		Reporter.log("TC to test Flipkart Search functioanlity started", true);
		String s_search_string = "Tv";
		String url = "https://www.flipkart.com";
		System.setProperty("webdriver.chrome.driver","./Drivers/Chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		Reporter.log("Chrome Invoked and navigated to URL: " + url + "<br>", true);
		
		//Checking page is navigated with the expected title
		String actual = driver.getTitle();
		String expected = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		Assert.assertEquals(actual, expected);
		Reporter.log("Page Navigated." + "<br>", true);
		 
		//Clicking on Cross button
		WebElement sign_in_cross = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		sign_in_cross.click();
		Reporter.log("Sign In Window Closed." + "<br>", true);
		
		//Check Search Box is Displayed
		WebElement searchbx = driver.findElement(By.xpath("//input[@name ='q' and @type='text']"));
		Assert.assertEquals(searchbx.isDisplayed(), true);
		Reporter.log("Search Box is displayed." + "<br>", true);
		
		//Enter TV in Search text box
		searchbx.sendKeys(s_search_string);
		
		//Clicked on Search button
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		
		//Check if search Results is displayed-VALIDATION 1
		//WebElement txtbx_search_result_text = driver.findElement(By.xpath("//span[@class,'_10Ermr']"));
		WebElement txtbx_search_result_text = driver.findElement(By.xpath("//span[contains(text(),'Showing 1 – 24 of 1,795 results for \"')]"));
		Assert.assertEquals(txtbx_search_result_text.isDisplayed(), true);
		
		//Check if search Results is displayed-VALIDATION 2
		String exp_search_title = s_search_string;
		String actual_search_title = driver.getTitle();
		if(actual_search_title.toLowerCase().contains(exp_search_title.toLowerCase())) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		Reporter.log("Search Box set with value :" + s_search_string + " and search results displayed" + "<br>", true);

		//Fetch All the Products Text
		//List<WebElement> list_of_products = driver.findElements(By.xpath("//div[@class='_3wU53n']"));//_4rR01T
		List<WebElement> list_of_products = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		//List<WebElement> list_of_products_price = driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));//_30jeq3 _1_WHN1
		List<WebElement> list_of_products_price = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		
		//Use of HashMaop to store Products and Their prices(after conversion to Integer)
		String product_name;
		String product_price;
		int int_product_price;
		HashMap<Integer, String> map_final_products = new HashMap<Integer,String>();
		for(int i=0;i<list_of_products.size();i++) {
			product_name = list_of_products.get(i).getText();//Iterate and fetch product name
			product_price = list_of_products_price.get(i).getText();//Iterate and fetch product price
			product_price = product_price.replaceAll("[^0-9]", "");//Replace anything wil space other than numbers
			int_product_price = Integer.parseInt(product_price);//Convert to Integer
			map_final_products.put(int_product_price,product_name);//Add product and price in HashMap
		}
		Reporter.log("Product Name and price fetched from UI and saved in HashMap as:" + map_final_products.toString() + "<br>",true);

		//Find the Highest and Lowest prices
		//One way is to fetch all values of the hashMap and then save it in the ArrayList
		//Then using Collections class in java, sort it. this we can easily get highest and lowest
		
		//Get all the keys from Hash Map
		Set<Integer> allkeys = map_final_products.keySet();
		ArrayList<Integer> array_list_values_product_prices = new ArrayList<Integer>(allkeys);
		
		//Sort the Prices in Array List using Collections class
		//this will sort in ascending order lowest at the top and highest at the bottom
		Collections.sort(array_list_values_product_prices);
		
		//Highest Product is
		int high_price = array_list_values_product_prices.get(array_list_values_product_prices.size()-1);
		
		//Low price is
		int low_price = array_list_values_product_prices.get(0);
		
		//Reporter.log("High Product Price is: " + high_price + " Product name is: " + map_final_products.get(high_price),true);
		//Reporter.log("Low Product Price is: " + low_price + " Product name is: " + map_final_products.get(low_price),true);
		
		Reporter.log("High Product Price is: " + high_price + " Product name is: " + map_final_products.get(high_price),true);
		Reporter.log("Low Product Price is: " + low_price + " Product name is: " + map_final_products.get(low_price),true);
		//Get List of All values from Hash Map. Right now we do not need it so commenting
		//Collection<String> allValues = map_final_products.values();
		//ArrayList<String> array_list_values_product_names = new ArrayList<String>(allValues);
		
	}

}




