package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupRemovalTests extends TestBase {
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void deleteSomeGroup(GroupData group) {
		
		// save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //actions
	    app.getGroupHelper().deleteGroup(index);
	    
	    // save new state
	    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    //compare state
	    assertThat(newList, equalTo(oldList.without(index)));
	  	}

}
