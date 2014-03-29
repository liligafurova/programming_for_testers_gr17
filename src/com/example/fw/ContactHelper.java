package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
		
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstname);
		type(By.name("lastname"), contact.lastname);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.home);
		type(By.name("mobile"), contact.mobile);
		type(By.name("work"), contact.work);
		type(By.name("email"), contact.email);
		type(By.name("email2"), contact.email2);
		selectByText(By.name("bday"), contact.bday);
		selectByText(By.name("bmonth"), contact.bmonth);
		//selectByText(By.name("new_group"), contact.newgroup);
		type(By.name("address2"), contact.address2);
		type(By.name("phone2"), contact.phone2);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

	public void initContactSelecting(int index) {
		selectContactByIndex(index-1);
		click(By.xpath("//tr[" + index + "]/td[7]/a/img[@alt='Edit']"));

	}

	private void selectContactByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + index +"]"));
		
	}

	public void deleteContact(int index) {
		click(By.xpath("//input[@value='Delete']"));

	}

	public void submitContactModification() {
		click(By.xpath("//input[@value='Update']"));
		
	}

}