package org.automation.addressbook.tests;

import org.automation.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class TestContactPhones extends TestBase {

    @Test
    public void TestContactPhones() {
        app.goTo().HomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    }
}
