package com.freecrm.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.freecrm.base.TestBase;
import com.freecrm.uilities.TestUtils;

import atu.testrecorder.exceptions.ATUTestRecorderException;

public class HomePageTC extends TestBase {
	
	public HomePageTC() throws IOException {
		// this will Run constructor of TestBase (Parent) class
		super();
	
	}
	//regression: 4
	//E2E : 1
	//Sanity:2
	
	@Parameters({"browser"})
	@BeforeMethod 
	public void login(Method method,String browser) throws ATUTestRecorderException {
		initialize(method,browser);
        WebElement usernameTextBox=driver.findElement(By.name("username"));
        WebElement passwordTextBox=driver.findElement(By.name("password"));
        usernameTextBox.sendKeys(prop.getProperty("Username"));
        passwordTextBox.sendKeys(prop.getProperty("Password"));
        WebElement LoginButton=driver.findElement(By.xpath("//input[@value='Login']"));
        LoginButton.click();
		
	}
	@AfterMethod  
	public void TearDown(Method method) throws IOException, ATUTestRecorderException { 
		TestUtils.TakePicture(method.getName());
		record.stop();
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void ClickonContactsTC()  {
		
		driver.switchTo().frame(prop.getProperty("frame1"));
		//WebElement contacts=driver.findElement(By.linkText("CONTACTS"));
	    WebElement contacts=driver.findElement(By.xpath("//a[text()='Contacts']"));
		contacts.click();
		WebElement Status=driver.findElement(By.xpath("//td[text()='Status']"));
		boolean actualResult=Status.isDisplayed();
		Assert.assertTrue(actualResult," status label not displayed ");
		 //TestUtils.TakePicture(method.getName());
			
		
	}
	@Test(priority=2)
	public void ClickonDealsTC()  {
		
		driver.switchTo().frame(prop.getProperty("frame1"));
		//WebElement contacts=driver.findElement(By.linkText("CONTACTS"));
	    WebElement contacts=driver.findElement(By.xpath("//a[text()='Deals']"));
		contacts.click();
		WebElement Keyword=driver.findElement(By.xpath("//td[text()='Keyword']"));
		boolean actualResult=Keyword.isDisplayed();
		Assert.assertTrue(actualResult," Keyword label not displayed ");
		// TestUtils.TakePicture(method.getName());
			
		
	}
	
	@Test(priority=3)
	public void ClickonTasksTC( )  {
		
		driver.switchTo().frame(prop.getProperty("frame1"));
		//WebElement contacts=driver.findElement(By.linkText("CONTACTS"));
	    WebElement contacts=driver.findElement(By.xpath("//a[text()='Tasks']"));
		contacts.click();
		WebElement Keyword=driver.findElement(By.xpath("//td[text()='Keyword']"));
		boolean actualResult=Keyword.isDisplayed();
		Assert.assertTrue(actualResult," Keyword label not displayed ");
		// TestUtils.TakePicture(method.getName());
				
	}
	@Test(priority=4)
	public void CheckUserNameTextTC(){
		
		driver.switchTo().frame(prop.getProperty("frame1"));
	    WebElement UsernameTxt=driver.findElement(By.xpath("//*[contains(text(),'User: Iss Mou')]"));
		boolean actualResult=UsernameTxt.isDisplayed();
		Assert.assertTrue(actualResult," username Text not displayed ");
		//System.out.println(UsernameTxt.getText());
		 //TestUtils.TakePicture(method.getName());
				
	}
	
	
	

}
