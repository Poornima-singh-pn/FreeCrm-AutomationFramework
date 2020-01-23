package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.Testbase;

public class LoginPage  extends Testbase{
	

	//page factory :OR
			@FindBy(xpath="//span[contains(text(),'Log In')]")
			WebElement FloginBtn;
			
			@FindBy(name ="email")
			WebElement email;
			
			@FindBy(name="password")
			WebElement password;
			
			@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
			WebElement login;
			
			@FindBy(xpath="//div[@class='rd-navbar-panel']//span[contains(text(),'free')]")
			WebElement crmlogo;
			
			
			public LoginPage( ) {
				
				PageFactory.initElements(driver, this);
				
			}
			
			public String validatePageTitle() {
				return driver.getTitle();
			}
//			public LoginPage() {
//				// this.driver = driver;
//				PageFactory.initElements(driver,LoginPage.class);
//				
//			}
			
//			public String validatePageTitle() {
//				 return driver.getTitle();
//				
//			}
//			
			public boolean validatecrmlogo() {
				return  crmlogo.isDisplayed();
			}
			
			public boolean validatefloginbtn() {
				return  FloginBtn.isDisplayed();
			}
			
			public void floginbtnclick() {
				 FloginBtn.click();
			}
			
			public HomePage login(String un, String pwd) {
				email.sendKeys(un);
				password.sendKeys(pwd);
				login.click();
				
				return new HomePage();
				
			}

			

		}




