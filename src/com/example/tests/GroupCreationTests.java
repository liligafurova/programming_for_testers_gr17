package com.example.tests;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class GroupCreationTests extends TestBase {
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationWithValidData(GroupData group) throws Exception {
       
    // save old state
	SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
    
    //actions
    app.getGroupHelper().createGroup(group);
    
    // save new state
    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
    
    //compare state
    assertThat(newList, equalTo(oldList.withAdded(group)));
  }

}