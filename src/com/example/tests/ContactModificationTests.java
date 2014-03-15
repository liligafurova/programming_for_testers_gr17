package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifySomeContact(){
		
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactSelecting(2);
		ContactData contact = new ContactData();
	    contact.firstname = "Ivan new";
	    contact.bday = "25";
	    app.getContactHelper().fillContactForm(contact);
	    app.getContactHelper().submitContactModification();
	    app.getContactHelper().returnToHomePage();
		
	}

}
