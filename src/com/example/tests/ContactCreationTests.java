package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
  public void testNonEmptyContactCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    
    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    //actions
    app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData();
    contact.firstname = "Ivan";
    contact.lastname = "Ivanov";
    contact.address = "Kazan";
    contact.home = "111-11-11";
    contact.mobile = "8-222-222-22-22";
    contact.work = "333-33-33";
    contact.email = "ivanov@mail.ru";
    contact.email2 = "-";
    contact.bday = "14";
    contact.bmonth = "January";
    contact.byear = "1980";
    //contact.newgroup = "123";
    contact.address2 = "-";
    contact.phone2 = "-";
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    
 // save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    //compare state
    oldList.add(contact);
    Collections.sort(oldList);
    Collections.sort(newList);
    assertEquals(newList, oldList);
  }
}
