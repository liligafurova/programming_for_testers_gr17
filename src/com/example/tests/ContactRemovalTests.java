package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{

	@Test
	public void deleteSomeContact() {
		
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactSelecting(2);
		app.getContactHelper().deleteContact(2);
	    app.getContactHelper().returnToHomePage();
	}
}
