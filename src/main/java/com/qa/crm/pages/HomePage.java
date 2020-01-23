package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.Testbase;

public class HomePage extends Testbase {
	
	//page factory :OR

	//verify username
	@FindBy(xpath="//span[@class='user-display']")
	@CacheLookup
	WebElement username;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement Contactslink;
	
	@FindBy(xpath="//a[contains(text(),'deals')]")
	WebElement Dealslink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement Tasklink;
	
	//initilize the page object
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyUserName() {
		return username.isDisplayed();
		
	}
	
	public String verifyHomepageTitle() {
		return driver.getTitle();
		
	}
	public ContactsPage clickOnContactsPage() {
		Contactslink.click();
		return new ContactsPage();
		
	}
//
//	public DealPage clickOnDealsPage() {
//		Contactslink.click();
//		return new DealPage();
//		
//	}
//
//	public TaskPage clickOnTaskPage() {
//		Contactslink.click();
//		return new TaskPage();
//		
	}


