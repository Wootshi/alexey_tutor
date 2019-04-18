package org.automation.addressbook.tests;


import org.automation.addressbook.model.ContactData;
import org.automation.addressbook.model.Contacts;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() throws Exception {
        app.goTo().HomePage();
        if (!app.contact().isThereAnEntry()) {
            app.contact().create(new ContactData("Basil", "Denisovich", "test1"));
        }
        app.goTo().HomePage();
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();

        app.contact().modify(modifiedContact);
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withName("ttesttt").withHeader("test2").withFooter("test3");

        app.contact().fillContactForm(contact, false);
        app.contact().submitContactModification();
        app.goTo().HomePage();
        //List<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after, before);
    }
}
