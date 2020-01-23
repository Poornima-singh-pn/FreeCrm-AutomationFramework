package com.qa.crm.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.crm.base.Testbase;
import com.qa.crm.pages.ContactsPage;
import com.qa.crm.pages.DealPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.pages.TaskPage;

import junit.framework.Assert;

public class HomePageTest extends Testbase {
	LoginPage loginpage;
	HomePage HomePage;
	ContactsPage ContactsPage;
	DealPage DealPage;
	TaskPage TaskPage;
	static WebDriver driver;
	
	
	
	public HomePageTest() {
		super();
	}
	
	@BeforeSuite
    public void setUp() throws Exception {
		   intilization();
		   loginpage = new LoginPage();
		   HomePage = new HomePage(); 
		   ContactsPage = new ContactsPage();
//		   DealPage = new DealPage();
//		   TaskPage = new TaskPage();
		   loginpage.floginbtnclick();
		   Thread.sleep(5000);
		   loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
		   Thread.sleep(5000);
		  }

	@Test(priority = 1)
	public void HomepageTitleTest(){
	   String   hptitle = HomePage.verifyHomepageTitle();
		Assert.assertEquals(hptitle,"Cogmento CRM");
	}
	
	@Test(priority = 2)
		public void verifyHomepageUsername(){
		   boolean val = HomePage.verifyUserName();
		   Assert.assertTrue(val);
		
	}
	
	@Test(priority = 3)
	public void ContactsPageTest(){
		ContactsPage  = HomePage.clickOnContactsPage();	
}
//	
//	@Test(priority = 4)
//	public void DealPageTest(){
//		DealPage  = HomePage.clickOnDealsPage();
//	
//}
//	@Test(priority = 5)
//	public void TaskPageTest(){
//		TaskPage  = HomePage.clickOnTaskPage();
//	
//}
	
	@AfterSuite
	public void TearDown() {
		driver.quit();
	}
}
