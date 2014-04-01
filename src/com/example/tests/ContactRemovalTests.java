package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{

	@Test(dataProvider = "randomValidContactGenerator")
	public void deleteSomeContact(ContactData contact) {
				
		app.getNavigationHelper().openMainPage();
		
		//save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
		
		//actions
	    app.getContactHelper().initContactSelecting(index);
		app.getContactHelper().deleteContact(index);
	    app.getContactHelper().returnToHomePage();
	    
	    // save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare state
	    oldList.remove(index);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}
}
