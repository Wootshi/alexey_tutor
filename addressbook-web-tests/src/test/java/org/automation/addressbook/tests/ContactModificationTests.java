package org.automation.addressbook.tests;


import org.automation.addressbook.model.ContactData;
import org.automation.addressbook.model.Contacts;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() throws Exception {
        app.goTo().HomePage();
        if (!app.contact().isThereAnEntry()) {
            app.contact().create(new ContactData().withFirstName("Harry").withSecondName("Topor"));
        }

        ContactData contact = new ContactData().withFirstName("Barry").withSecondName("Test");

        app.goTo().HomePage();
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        app.contact().modify(modifiedContact);
        app.goTo().HomePage();
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size());

        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }
}
