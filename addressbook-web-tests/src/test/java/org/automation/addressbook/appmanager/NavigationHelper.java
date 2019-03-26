package org.automation.addressbook.appmanager;

import org.automation.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper {

    public NavigationHelper(WebDriver driver) {

        super(driver);
    }

    public void gotoGroupPage() {

        click(By.linkText("groups"));
    }

    public void gotoHomePage() {

        click(By.linkText("home"));
    }

    public void enterFirstLastName(ContactData contactData) {

        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getSecondname());

    }
}
