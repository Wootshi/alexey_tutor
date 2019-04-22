package org.automation.addressbook.tests;


import org.automation.addressbook.model.ContactData;
import org.automation.addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().HomePage();

        if (!app.contact().isThereAnEntry()) {
            app.contact().create(new ContactData().withFirstName("Basil").withLastName("Broketail"));
        }
        app.goTo().HomePage();
    }

    @Test
    public void testContactDeletion() throws Exception {
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.goTo().wait(2);
        app.goTo().HomePage();
        Contacts after = app.contact().all();
        before.remove(deletedContact);
        assertThat(before, equalTo(after));

    }
}