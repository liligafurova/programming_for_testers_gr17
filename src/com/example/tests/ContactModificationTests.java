package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifySomeContact(){
		
		app.getNavigationHelper().openMainPage();
		
		 //save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
		
	    //actions
		app.getContactHelper().initContactSelecting(2);
		ContactData contact = new ContactData();
	    contact.firstname = "Ivan new";
	    contact.lastname = "Ivanov new";
	    app.getContactHelper().fillContactForm(contact);
	    app.getContactHelper().submitContactModification();
	    app.getContactHelper().returnToHomePage();
	    
	    // save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare state
	    oldList.remove(0);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList); 
		
	}

}
