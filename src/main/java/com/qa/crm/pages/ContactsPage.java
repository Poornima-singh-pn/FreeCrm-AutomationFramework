package com.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.Testbase;

public class ContactsPage extends Testbase{

	
	@FindBy(xpath= "//div[@class='ui header item mb5 light-black']")
	WebElement contacts;
	
	@FindBy(xpath= "//button[contains(text(),'New')]")
	WebElement Newcontactbtn;
	
	@FindBy(xpath= "//input[@name='first_name']")
	WebElement FirstName;
	
	@FindBy(xpath= "//input[@name='last_name']")
	WebElement LastName;
	
	@FindBy(xpath= "//div[@name='company']//input[@class='search']")
	WebElement CompanyName;
	
	@FindBy(xpath= "//button[contains(text(),'Save')]")
	WebElement SaveBtn;
	
	
	//initilize the page object
		public ContactsPage() {
			PageFactory.initElements(driver, this);
		}
		
		public boolean verifyContactsLabel() {
			 return contacts.isDisplayed();
			
		}
		//public void selectcontacts() {
		public void selectcontacts(String name) {
		//	driver.findElement(By.xpath("/div[@class='ui checked fitted read-only checkbox']//label")).click();
			driver.findElement(By.xpath("//td[contains(text(),'poornima singh')]")).click();
			
		}
		
		public void clickOnNewContactlink() {
			Newcontactbtn.click();
			//return new  CreateNewContactPage;
			
			
		}
		
		public void CreateNewContact( String FName, String LName, String ComName){
			FirstName.sendKeys(FName);
			LastName.sendKeys(LName);
			CompanyName.sendKeys(ComName);
			SaveBtn.click();
			
			
		}
}

