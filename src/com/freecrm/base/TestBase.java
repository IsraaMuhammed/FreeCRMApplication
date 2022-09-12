package com.freecrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.freecrm.uilities.Weblistener;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase { 
	
	public static  WebDriver driver ;
	public static Properties prop;
	public static EventFiringWebDriver edriver;
	public static Weblistener webli;
	public static ATUTestRecorder record;
	
	public TestBase() throws IOException {
	    prop=new Properties();
		FileInputStream f=new FileInputStream("D:\\FreeCRMApplication\\src\\com\\freecrm\\config\\configure.properties");
		prop.load(f);
		
	}
	
	
	public void initialize(Method method ,String browser) throws ATUTestRecorderException {
		
		if (browser.equalsIgnoreCase("chrome")) {
			
			record=new ATUTestRecorder("D:\\FreeCRMApplication\\Videos",method.getName(),false);
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\kcs\\Downloads\\chromedriver_win32\\chromedriver.exe");
	        driver=new ChromeDriver();
	        webli=new Weblistener();
	        edriver=new EventFiringWebDriver(driver);
	        edriver.register(webli);
	        driver=edriver;
			
		}
		else if(browser.equalsIgnoreCase("MicrosoftEdge")) 
		{
		record=new ATUTestRecorder("D:\\FreeCRMApplication\\Videos",method.getName(),false);
		WebDriverManager.edgedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\kcs\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver=new EdgeDriver();
        webli=new Weblistener();
        edriver=new EventFiringWebDriver(driver);
        edriver.register(webli);
        driver=edriver;
        }
        record.start();
        driver.get(prop.getProperty("URL"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}

}
