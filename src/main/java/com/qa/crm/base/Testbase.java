package com.qa.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EventListener;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeSuite;

import com.qa.crm.util.Testutil;
import com.qa.crm.util.WebEventListener;


public class Testbase {
		

	      public static  WebEventListener eventListener;
		   public static  WebDriver driver;
		  public static Properties prop;
		   public static EventFiringWebDriver e_driver;
		  
		   public Testbase(){
			   try {
				prop = new Properties();
				  FileInputStream ip = new FileInputStream("C:\\Automation\\FreeCrmm\\src\\main\\java\\com\\qa\\crm\\config\\config.properties");
				  
				  
				prop.load(ip);
				
			} catch (FileNotFoundException e) {
				// TODO: handle exception\
				e.printStackTrace();
			}catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		  }
		   
		   
		  
		   
		   public static void intilization() {
			  String  browser1 = prop.getProperty("browser");
			  if(browser1.equals("chrome")) {
				  System. setProperty("webdriver.chrome.driver","C:\\Users\\Bluetie Backup 3 i5\\Downloads\\chromedriver_win32\\chromedriver.exe");
				  driver = new ChromeDriver();
			  }
			  
			  
			  e_driver = new EventFiringWebDriver(driver);
			  // now create object of the EventFiringWebDriver to register it with EventFiringWebDriver
			   eventListener = new WebEventListener();
			   e_driver.register(eventListener);
			   driver= e_driver;
			  
//			  System. setProperty("webdriver.chrome.driver","C:\\Users\\Bluetie Backup 3 i5\\Downloads\\chromedriver_win32\\chromedriver.exe");
//			  driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Testutil.IMPLICT_WAIT,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
			 driver.get(prop.getProperty("url"));
			
		   

		}

}


