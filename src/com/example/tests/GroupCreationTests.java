package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationWithValidData(GroupData group) throws Exception {
       
    // save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    //actions
    app.getGroupHelper().createGroup(group);
    
    // save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    //compare state
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
    
  }

}