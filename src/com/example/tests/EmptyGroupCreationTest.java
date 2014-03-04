package com.example.tests;

import org.testng.annotations.Test;

public class EmptyGroupCreationTest extends TestBase {
	
    @Test
  public void testEmptyGroupCreation() throws Exception {
    openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    GroupData group = new GroupData();
    group.name = "";
    group.header = "";
    group.footer = "";
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupsPage();
  }
}
