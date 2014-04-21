package com.example.tests;

import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class GroupCreationTests extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> groupsFromFile(){
		return wrapGroupsForDataProvider(loadGroupsFromCsvFile("groups.txt")).iterator();
		}

	@Test(dataProvider = "groupsFromFile")
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