package com.freecrm.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.freecrm.base.TestBase;
import com.freecrm.uilities.TestUtils;

import atu.testrecorder.exceptions.ATUTestRecorderException;

public class ContactPageTC extends TestBase{

	public ContactPageTC() throws IOException {
		super();
	
	}
	@Parameters({"browser"})
	@BeforeMethod
	public void Login(Method method,String browser) throws ATUTestRecorderException {
		    initialize(method, browser);
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
	@Test(dataProvider = "TestData")
	public void AddContactTC(String fs,String ls,String Com,String dep) {
		driver.switchTo().frame(prop.getProperty("frame1"));
		Actions action=new Actions(driver);
		WebElement contact=driver.findElement(By.xpath("//a[text()='Contacts']"));
		WebElement Newcontact=driver.findElement(By.xpath("//a[contains(text(),'New Contact')]"));
		action.moveToElement(contact).moveToElement(Newcontact).click().build().perform();
		WebElement fn=driver.findElement(By.id("first_name"));
		WebElement ln=driver.findElement(By.id("surname"));
		WebElement company=driver.findElement(By.name("client_lookup"));
		WebElement department=driver.findElement(By.id("department"));
		fn.sendKeys(fs);
		ln.sendKeys(ls);
		company.sendKeys(Com);
		department.sendKeys(dep);
		WebElement savebtn=driver.findElement(By.xpath("//input[@value='Save']"));
		savebtn.click();
		
		
	}

	@DataProvider
	public Object[][] TestData() throws IOException {
		
		Object data[][]=TestUtils.GetDataFromExcelSheet("ContactPageData");
		return data;
	}
	
	
	

}
