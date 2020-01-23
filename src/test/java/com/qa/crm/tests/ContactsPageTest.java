package com.qa.crm.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.qa.crm.base.Testbase;
import com.qa.crm.pages.ContactsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

public class ContactsPageTest extends Testbase {
	
	LoginPage loginpage; 
	ContactsPage ContactsPage; 
	HomePage HomePage;
	static WebDriver driver;
	Logger log = Logger.getLogger(ContactsPageTest.class);
	
	public ContactsPageTest() {
		super();
	}

	
			
	@BeforeSuite
    public void setUp() throws InterruptedException {
		   intilization();
		   loginpage = new LoginPage();
		  
		   ContactsPage = new ContactsPage();
		   loginpage.floginbtnclick();
		   HomePage = new HomePage();
		   loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
		   Thread.sleep(2000);
		   log.info("Log in Free crm app");
		   //ContactsPage = HomePage.clickOnContactsPage();
		   ContactsPage  = HomePage.clickOnContactsPage();
		   Thread.sleep(2000);
		   log.warn("Hey this is just a warning");
		   log.fatal("this is error message");
		   log.debug("this is debug not error");
		   
		   
		  }

	@Test(priority = 1)
	
	public void verifyContactsLabelTest() throws InterruptedException{
		log.info("..............................Test case execution.............................");
	   Assert.assertTrue(ContactsPage.verifyContactsLabel()," label not match");
	   log.info("checking contact label ---->");
	   Thread.sleep(2000);

	}
	
//	@Test(priority = 2)
//	public void selectcontactsTest(){
//		ContactsPage.selectcontacts("poornima singh");
//	//	ContactsPage.selectcontacts();
//	   
//
//	}
	@Test(priority = 2)
	public void NewContactlinkTest(){
		ContactsPage.clickOnNewContactlink();
	   

	}
	
	@Test(priority = 3)
	public void CreateNewContactTest(){
	//	ContactsPage.clickOnNewContactlink();
		ContactsPage.CreateNewContact("tomy", "tac", "google");
		
	   
	}


	
	

	@AfterSuite
	public void TearDown() {
		driver.quit();
	}
	
	
}
