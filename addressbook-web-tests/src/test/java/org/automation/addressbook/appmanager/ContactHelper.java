package org.automation.addressbook.appmanager;

import org.automation.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver driver) {
        super(driver);

    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public void submitContactCreation() {

        click(By.name("submit"));
    }


    public void fillContactForm(ContactData contactData) {


        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getSecondname());
        select(By.name("new_group"), contactData.getGroup());

    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void deleteSelectedContact() {

        click(By.name("delete"));
    }

    public void selectContact() {

        click(By.name("selected[]"));
    }

    public void initContactModification() {
        click(By.xpath("xpath=(.//*[normalize-space(text()) and normalize-space(.)='import'])[1]/following::input[1]"));
    }

    public void submitContactModification() {
        click(By.xpath("xpath=(.//*[normalize-space(text()) and normalize-space(.)='import'])[1]/following::img[2]"));
    }
}
