package org.automation.addressbook.tests;

import org.automation.addressbook.model.ContactData;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhonesTest extends TestBase {

    @Test
    public void TestContactPhones() {
        app.goTo().HomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getHomephone(), equalTo(contactInfoFromEditForm.getHomephone()));
        assertThat(contact.getWorkphone(), equalTo(contactInfoFromEditForm.getWorkphone()));
        assertThat(contact.getMobilephone(), equalTo(contactInfoFromEditForm.getMobilephone()));
    }
}
