package com.example.fw;

import static com.example.fw.ContactHelper.CREATION;
import static com.example.fw.ContactHelper.MODIFICATION;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.tests.GroupData;

public class ContactHelper extends HelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
		
	}
	
	private List<ContactData> cachedContacts;
	
	public List<ContactData> getContacts() {
		if (cachedContacts == null){
			rebuildCache();	
		}
		return cachedContacts;
	}
	
	private void rebuildCache()  {
		cachedContacts = new ArrayList<ContactData>();
		manager.navigateTo().mainPage();
		List<WebElement> tableRows = driver.findElements(By.xpath("//tr[@name='entry']"));
		for (WebElement row : tableRows) {
			ContactData contact = new ContactData();
		
			WebElement lastName = row.findElement(By.xpath("./td[3]"));
			contact.withFirstname(lastName.getText());
				
			WebElement firstName = row.findElement(By.xpath("./td[2]"));
			contact.withLastname(firstName.getText());
			
			cachedContacts.add(contact);
	
		}
	}
	
	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().mainPage();
		initContactCreation();
		fillContactForm(contact, CREATION);
		submitContactCreation();
		returnToHomePage();
		rebuildCache();
		return this;
	}
	
	public ContactHelper modifyContact(int index, ContactData contact,boolean mODIFICATION2) {
		initContactSelecting(index);
	    fillContactForm(contact, MODIFICATION);
	    submitContactModification();
	    returnToHomePage();
	    rebuildCache();
		return this;
	}
	
	public ContactHelper deleteContact(int index) {
		initContactSelecting(index);
		submitContactDeleting();
		returnToHomePage();
		rebuildCache();
		return this;
	}

	
	//-------------------------------------------------------------------
	
	public ContactHelper initContactCreation() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getFirstname());
		type(By.name("lastname"), contact.getLastname());
		type(By.name("address"), contact.getAddress());
		type(By.name("home"), contact.home);
		type(By.name("mobile"), contact.mobile);
		type(By.name("work"), contact.work);
		type(By.name("email"), contact.email);
		type(By.name("email2"), contact.email2);
		selectByText(By.name("bday"), contact.bday);
		selectByText(By.name("bmonth"), contact.bmonth);
		type(By.name("byear"), contact.byear);
		//selectByText(By.name("new_group"), "group_1");
		if (formType == CREATION){
			
		} else {
			if (driver.findElements(By.name("new_group")).size() != 0){
				throw new Error ();
			}
		}
		type(By.name("address2"), contact.address2);
		type(By.name("phone2"), contact.phone2);
		return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	public ContactHelper initContactSelecting(int index) {
		selectContactByIndex(index);
		click(By.xpath("//tr[@name='entry'][" + (index+1) + "]/td[7]/a/img[@alt='Edit']"));
		return this;
	}

	private ContactHelper selectContactByIndex(int index) {
		click(By.xpath("//tr[@name='entry'][" + (index+1) + "]/td[1]/input[@name='selected[]']"));
		return this;
	}

	public ContactHelper submitContactModification() {
		click(By.xpath("//input[@value='Update']"));
		cachedContacts = null;
		return this;
	}
	
	private void submitContactDeleting() {
		click(By.xpath("//input[@value='Delete']"));
	}
}
