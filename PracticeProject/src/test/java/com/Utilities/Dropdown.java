package com.Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.Pages.Locators;

public class Dropdown
{
public  WebDriver driver;
	
	public static void main(String[] args) throws AWTException, InterruptedException 
	{
	//dropdown() throws InterruptedException 
		
		Locators loc=new Locators();
		System.setProperty("webdriver.chrome.driver","./Drivers/Chromedriver.exe");
		WebDriver driver=new ChromeDriver();
        
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//driver.get("https://www.zoopla.co.uk/");
		driver.get("https://www.zoopla.co.uk/for-sale/property/london/?q=london&results_sort=newest_listings&search_source=home");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);

		Robot robot = new Robot();
		robot.mouseMove(1000,760);
		//robot.mousePress(buttons);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(3000);
		
		WebElement element=driver.findElement(By.xpath("//select[@id='sort-order-dropdown']"));
		Select sel=new Select(element);
		WebElement firstelement=sel.getFirstSelectedOption();
		System.out.println(firstelement.getText());
		Reporter.log("first element got printed" + "<br>", true);		
	    List<WebElement> list_of_options=sel.getOptions();
		for(WebElement ele:list_of_options)
		{
		if(ele.getText().contains("Lowest price"))
		   {
			ele.click();
		   }
		}
		
		//Fetch All the Products Text
		        Thread.sleep(4000);
				//List<WebElement> list_of_products = driver.findElements(By.xpath("//div[@class='_3wU53n']"));//_4rR01T
				List<WebElement> list_of_products= driver.findElements(By.xpath(".//*[@class='e1w23gwf22 css-ud4cit e16lreco0']"));
				Reporter.log("list_of_products" + "<br>", true);
				//List<WebElement> list_of_products_price = driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));//_30jeq3 _1_WHN1
				List<WebElement> list_of_products_price = driver.findElements(By.xpath("//*[@class='css-1smjogk e1ea77n20']"));
				Reporter.log("list_of_products_price" + "<br>", true);
				//Use of HashMaop to store Products and Their prices(after conversion to Integer)
				String product_name;
				String product_price;
				int int_product_price;
				
				HashMap<Integer, String> map_final_products = new HashMap<Integer,String>();
				for(int i=0;i<list_of_products.size();i++) 
				{
					product_name = list_of_products.get(i).getText();//Iterate and fetch product name
					product_price = list_of_products_price.get(i).getText();//Iterate and fetch product price
					//product_price = product_price.replaceAll("[^0-9]", "");//Replace anything wil space other than numbers
					if(!product_price.contains("POA"))
					{
					
					product_price = product_price.replaceAll("[^a-zA-Z0-9]", "");//Replace anything with space other than numbers = ("[^\\d.]".toRegex(), "")
					int_product_price = Integer.parseInt(product_price);//Convert to Integer
					
					// map_final_products.put(int_product_price,product_name);//Add product and price in HashMap
					map_final_products.put(int_product_price,product_name);//Add product and price in HashMap
					}
				}
				Reporter.log("Product Name and price fetched from UI and saved in HashMap as:");
				//+ map_final_products.toString() + "<br>",true);
				//Find the Highest and Lowest prices
				//One way is to fetch all values of the hashMap and then save it in the ArrayList
				//Then using Collections class in java, sort it. this we can easily get highest and lowest
				
				//Get all the keys from Hash Map
				Set<Integer> allkeys = map_final_products.keySet();
				ArrayList<Integer> array_list_values_product_prices = new ArrayList<Integer>(allkeys);
				
				//Sort the Prices in Array List using Collections class
				//this will sort in ascending order lowest at the top and highest at the bottom
				Collections.sort(array_list_values_product_prices);
				//
				System.out.println(array_list_values_product_prices);
				//
				//Highest Product is
				int high_price = array_list_values_product_prices.get(array_list_values_product_prices.size()-1);
				//Low price is
				int low_price = array_list_values_product_prices.get(0);
								
			Reporter.log("High Product Price is: " + high_price + " Product name is: " + map_final_products.get(high_price),true);
			Reporter.log("Low Product Price is: " + low_price + " Product name is: " + map_final_products.get(low_price),true);
			//Get List of All values from Hash Map. Right now we do not need it so commenting
			//Collection<String> allValues = map_final_products.values();
			//ArrayList<String> array_list_values_product_names = new ArrayList<String>(allValues);
				
    }
}










