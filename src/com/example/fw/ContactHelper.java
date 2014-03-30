package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		//List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		//for (WebElement checkbox : checkboxes) {
			//ContactData contact = new ContactData();
			//String title = checkbox.getAttribute("title");
			//contact.firstname = title.substring("Select (".length(), title.length() - ")".length());
		List<WebElement> tableRows = driver.findElements(By.xpath("//tr[@name='entry']"));
		for (WebElement row : tableRows) {
			ContactData contact = new ContactData();
		
			WebElement lastName = row.findElement(By.xpath("./td[3]"));
			contact.firstname = lastName.getText();
			
			WebElement firstName = row.findElement(By.xpath("./td[2]"));
			contact.lastname = firstName.getText();
			
			contacts.add(contact);
		}
		return contacts;
	}
}
