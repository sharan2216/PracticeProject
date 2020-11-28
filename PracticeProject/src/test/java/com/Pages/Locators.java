package com.Pages;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Utilities.Dropdown;

public class Locators extends Dropdown{
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		Locators loc=new Locators();
		System.setProperty("webdriver.chrome.driver","./Drivers/Chromedriver.exe");
		WebDriver driver=new ChromeDriver();
        
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//driver.get("https://www.zoopla.co.uk/");
		driver.get("https://www.zoopla.co.uk/signin/?page_after_login=%2F");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		
		Robot robot = new Robot();
		robot.mouseMove(1000,760);
		//robot.mousePress(buttons);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@name,'signin_email')]")).sendKeys("sasa111nasa@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@name,'signin_password')]")).sendKeys("jhonny66");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@value,'Sign in')]")).click();
		Thread.sleep(5000);
	
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@value='Search']")).click();
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='search-input-location'][@type='text']")).sendKeys("london");	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='search-input-location'][@type='text']")).click();
		//driver.findElement(By.xpath("//*[@title='Delete suggestion']")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@value='Search']")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//select[@id='sort-order-dropdown']")).click();
		loc.dropdown();
		
		
				
		/*robot.mouseMove(1300,140);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		Thread.sleep(8000);
		driver.findElement(By.xpath("//input[@name='signin_email'")).click();
		driver.findElement(By.xpath("//input[@name='signin_email'")).click();
		driver.findElement(By.xpath("//input[@name='signin_email'")).sendKeys("sasa111nasa@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='signin_password']")).sendKeys("jhonny66");
*/
		}

}
