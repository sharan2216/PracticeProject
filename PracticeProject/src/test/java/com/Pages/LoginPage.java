//login page details
package com.Pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	
	
	public LoginPage(WebDriver ldriver)
	{
	this.driver=ldriver;
	}
	
	@FindBy(xpath="//input[@name='signin_email']")WebElement eemail;
	
	//@FindBy(xpath="/html/body/div[2]/div/div/div/section/form/fieldset/input[1]")WebElement signin;
	//@FindBy(xpath="//a[@class='myaccount-nav-link']")WebElement signin;
	//@FindBy(xpath="//input[@type='email']")WebElement eemail;
	@FindBy(xpath="//input[@id='signin_password']")WebElement pass;
	@FindBy(xpath="///button[@id='signin_submit']")WebElement SignInButton;
		
	public void LoginToZoopla() throws InterruptedException
	{
		/*driver.findElement(By.xpath("/html/body/div[2]/header/div/div[1]/div/div[2]/div/div[1]/a")).click();
		//ele2.click();
		//ele1.click();
		eemail.click();
		*/
		Thread.sleep(2000);
		eemail.click();
		eemail.sendKeys("sasa111nasa@gmail.com");
		pass.click();
		Thread.sleep(2000);
		
		pass.sendKeys("jhonny66");
		SignInButton.click();
		
		
			
	}
}
