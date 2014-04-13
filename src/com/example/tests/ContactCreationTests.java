package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import static com.example.fw.ContactHelper.CREATION;

public class ContactCreationTests extends TestBase {

    @Test(dataProvider = "randomValidContactGenerator")
  public void testNonEmptyContactCreation(ContactData contact) throws Exception {
    
    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    //actions
    app.getContactHelper().createContact(contact);
    
 // save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    //compare state
    oldList.add(contact);
    Collections.sort(oldList);
    Collections.sort(newList);
    assertEquals(newList, oldList);
  }
}
