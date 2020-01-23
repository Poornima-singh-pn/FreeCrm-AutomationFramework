package com.qa.crm.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.base.Testbase;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends Testbase {

			LoginPage loginpage; 
			HomePage HomePage;
		// static WebDriver driver;
		
		
	public LoginPageTest() throws IOException{
//		//	this.driver = driver;
			super();
		}
		
			
		

	@BeforeMethod
	       public void setUp() {
			   intilization();
			   loginpage = new LoginPage();
			  }
			   
		   
			
		@Test(priority = 1)
		public void loginPageTitleTest(){
		   String   title = loginpage.validatePageTitle();
			Assert.assertEquals(title,"Free CRM #1 cloud software for any business large or small");
		}
		
		@Test(priority = 2)
		public void crmLogoTest(){
					 boolean flag = loginpage.validatecrmlogo();
			 Assert.assertTrue(flag);
			
		}
		@Test(priority = 3)
		public void fLoginbtnTest(){
				 boolean value = loginpage.validatefloginbtn();
			 Assert.assertTrue(value);
		
		}
		
		@Test(priority = 4)
		public void fLoginclickTest(){
				loginpage.floginbtnclick();
		}
		
		@Test(priority = 5)
		public void LoginTest(){
			loginpage.floginbtnclick();

	   HomePage = loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
				
		}		
		
		
		@AfterMethod
		public void TearDown() {
			driver.quit();
		}
	}

