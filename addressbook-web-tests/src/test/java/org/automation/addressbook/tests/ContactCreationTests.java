package org.automation.addressbook.tests;


import org.automation.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().createContact(new ContactData("Solmir", "Olegovich", "test1"));
        app.getNavigationHelper().gotoHomePage();
    }

}
