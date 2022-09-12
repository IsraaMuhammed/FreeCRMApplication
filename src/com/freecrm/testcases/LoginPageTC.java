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

public class LoginPageTC extends TestBase  {
	
	public LoginPageTC() throws IOException {
		super();
		
	}

	@Parameters({"browser"})
	@BeforeMethod
	public void setup(Method method ,String browser) throws ATUTestRecorderException {
		initialize( method,browser);
		
		
	}
	
	@AfterMethod
	public void tearDown(Method method) throws ATUTestRecorderException, IOException {
		TestUtils.TakePicture(method.getName());
		 record.stop();
		 driver.quit();
		
}
	
	@Test(priority=1)
	public void TitleTC() {
        String ExpextedResults="CRMPRO - CRM software for customer relationship management, sales, and support.";
        String ActualResult=driver.getTitle();
        System.out.println(ActualResult);
        Assert.assertEquals(ActualResult,ExpextedResults," Title is not found ");
        
        //System.out.println(ActualResult);		
	}
	
	@Test(priority=2)
	public void UrlCheckTC() {
        String ExpectedResults=prop.getProperty("URL");
        String ActualResuts=driver.getCurrentUrl();
        Assert.assertEquals(ActualResuts,ExpectedResults,"Url wrong ");
        //TestUtils.TakePicture(method.getName());
      // System.out.println(ActualResuts);	
	}
	
	@Test(priority=3)
	public void LogoCheckTC() {
       WebElement Logo=driver.findElement(By.xpath("//img[@src='https://classic.freecrm.com/img/logo.png']"));
      boolean ActualResult= Logo.isDisplayed();
      Assert.assertTrue(ActualResult, "Logo is not displayed");
      //TestUtils.TakePicture(method.getName());
      //System.out.println(ActualResult);
	}
	
	@Test(priority=4)  //dataProvider="mydata"//
	public void LoginTC() {
        WebElement usernameTextBox=driver.findElement(By.name("username"));
        WebElement passwordTextBox=driver.findElement(By.name("password"));
        usernameTextBox.sendKeys(prop.getProperty("Username"));
        passwordTextBox.sendKeys(prop.getProperty("Password"));
       WebElement LoginButton=driver.findElement(By.xpath("//input[@value='Login']"));
       LoginButton.click();
       String ExpectedResult="CRMPRO";
        String ActualResult=driver.getTitle();
       Assert.assertEquals(ActualResult,ExpectedResult," failed login --> wrong username or passsword " );
       //TestUtils.TakePicture(method.getName());
       //System.out.println(ActualResult);
        
	}
	
//	@DataProvider
//	public Object[][] mydata() {
//		
//		Object[][] data=new Object[4][2];
//		//valid user name, valid password
//		data[0][0]="Issmou";
//		data[0][1]="@iss123";
//		//valid user name, invalid password
//		data[1][0]="Issmou";
//		data[1][1]="iss12";
//		//invalid user name, valid password
//		data[2][0]="Is";
//		data[2][1]="@iss123";
//		//invalid user name, invalid password
//		data[3][0]="Ahmed";
//		data[3][1]="123";
//		
//		return data;
//		
//	}
//	
	
	

}
