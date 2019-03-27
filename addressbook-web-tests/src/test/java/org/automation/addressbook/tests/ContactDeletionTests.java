package org.automation.addressbook.tests;


import org.automation.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() throws Exception {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAnEntry()) {
            app.getContactHelper().createContact(new ContactData("Vishnu", "Petrovich", null));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getNavigationHelper().gotoHomePage();
    }

}