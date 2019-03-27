package org.automation.addressbook.tests;


import org.automation.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().createGroup(new GroupData("test", null, null));
        app.getNavigationHelper().gotoHomePage();
    }

}
