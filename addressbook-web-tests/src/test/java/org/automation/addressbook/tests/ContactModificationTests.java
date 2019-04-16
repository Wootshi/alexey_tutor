package org.automation.addressbook.tests;


import org.automation.addressbook.model.ContactData;
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
        List<ContactData> before = app.contact().all();
        app.contact().initContactModification(before.size() + 1);
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Kirill", "Methodius", "Buddha");
        app.contact().fillContactForm(contact, false);
        app.contact().submitContactModification();
        app.goTo().HomePage();
        List<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after, before);
    }
}
