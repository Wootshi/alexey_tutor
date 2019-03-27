package org.automation.addressbook.tests;


import org.automation.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() throws Exception {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAnEntry()) {
            app.getContactHelper().createContact(new ContactData("Vishnu", "Petrovich", null));
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Satan", "Ivanovich", "aiaiaia"), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().gotoHomePage();
    }

}
