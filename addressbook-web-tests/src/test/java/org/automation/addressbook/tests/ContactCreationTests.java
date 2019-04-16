package org.automation.addressbook.tests;


import org.automation.addressbook.model.ContactData;
import org.automation.addressbook.model.Contacts;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        ContactData contact = new ContactData("Stan", "frroo", "[none]");

        app.goTo().HomePage();
        Contacts before = app.contact().all();

        app.contact().create(contact);
        app.goTo().HomePage();
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));

        before.add(contact);
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
        //Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        //before.sort(byId);
        //after.sort(byId);

        Assert.assertEquals(before, after);
    }
}
