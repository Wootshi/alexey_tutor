package org.automation.addressbook.tests;


import org.automation.addressbook.model.ContactData;
import org.automation.addressbook.model.Contacts;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() throws Exception {

        app.goTo().HomePage();

        if (!app.contact().isThereAnEntry()) {
            app.contact().create(new ContactData("Vishnu", "Petrovich", null));
        }
        app.goTo().HomePage();
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.goTo().wait(2);
        app.goTo().HomePage();
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.without(deletedContact)));
        before.remove(deletedContact);
        assertThat(before, equalTo(after));

    }
}