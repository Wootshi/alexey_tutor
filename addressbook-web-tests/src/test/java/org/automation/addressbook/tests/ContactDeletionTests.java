package org.automation.addressbook.tests;


import org.automation.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() throws Exception {
        app.goTo().HomePage();

        if (!app.contact().isThereAnEntry()) {
            app.contact().create(new ContactData("Vishnu", "Petrovich", null));
        }
        app.goTo().HomePage();
        List<ContactData> before = app.contact().all();
        app.contact().selectContact(before.size() - 1);
        app.contact().deleteSelectedContact();
        app.goTo().wait(2);
        app.goTo().HomePage();
        List<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }
}