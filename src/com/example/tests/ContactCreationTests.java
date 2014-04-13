package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase {

    @Test(dataProvider = "randomValidContactGenerator")
  public void testNonEmptyContactCreation(ContactData contact) throws Exception {
    
    //save old state
    SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
    
    //actions
    app.getContactHelper().createContact(contact);
    
 // save new state
    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
    
    //compare state
    assertThat(newList, equalTo(oldList.withAdded(contact)));
    
    //oldList.add(contact);
    //Collections.sort(oldList);
    //Collections.sort(newList);
    //assertEquals(newList, oldList);
  }
}
