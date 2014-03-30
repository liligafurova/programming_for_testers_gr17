package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{

	@Test
	public void deleteSomeContact() {
		
		app.getNavigationHelper().openMainPage();
		
		//save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
		
		//actions
	    app.getContactHelper().initContactSelecting(2);
		app.getContactHelper().deleteContact(2);
	    app.getContactHelper().returnToHomePage();
	    
	    // save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare state
	    oldList.remove(0);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}
}
