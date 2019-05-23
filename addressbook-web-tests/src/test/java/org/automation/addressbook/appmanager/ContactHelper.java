package org.automation.addressbook.appmanager;

import org.automation.addressbook.model.ContactData;
import org.automation.addressbook.model.Contacts;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ContactHelper extends BaseHelper {

    private Contacts contactCache = null;

    public ContactHelper(WebDriver driver) {
        super(driver);

    }

    public void submitContactCreation() {

        click(By.name("submit"));
    }


    public void fillContactForm(ContactData contactData, boolean creation) {


        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());


        if (creation) {
            String contactexists = driver.findElement(By.name("new_group")).getText();

            if (contactexists.equals(contactData.getGroup())) {
                new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
            } else if (!contactexists.equals(contactData.getGroup())) {
                new Select(driver.findElement(By.name("new_group"))).selectByVisibleText("[none]");
            }

        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void deleteSelectedContact() {

        click(By.xpath("/html/body/div/div[4]/form[2]/div[2]/input"));
        driver.switchTo().alert().accept();
    }

    public void selectContact(int index) {

        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void selectContactById(int id) {

        driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }


    public void initContactModification(int row) {
        click(By.xpath("//table/tbody/tr[" + row + "]/td[8]/a"));
        //click(By.xpath("//table/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitContactModification() {

        click(By.name("update"));
    }

    public int count() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public void modify(ContactData contact) {
        selectContactById(contact.getId());
        initContactModification(count() + 1);
        fillContactForm(contact, false);
        submitContactModification();
        contactCache = null;

    }

    public void create(ContactData contact) {
        initContactCreation();
        fillContactForm(contact, true);
        submitContactCreation();
        contactCache = null;

    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
        contactCache = null;
    }

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> rows = driver.findElements((By.name("entry")));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            String phoneCell = String.

            if (cells.get(5) != null) {
                String[] phones = cells.get(5).getText().split("\n");

                if (phones.length > 2) {
                    contactCache.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname).withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]));
                } else if (phones.length > 1) {
                    contactCache.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname).withHomePhone(phones[0]).withMobilePhone(phones[1]));

                } else if (phones.length == 1) {
                    contactCache.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname));
                } else {
                }
                contactCache.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname));
            }

            //if (phones.length > 2) {

            //} else if (phones.length > 1) {
            //contactCache.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname)
            //.withHomePhone(phones[0]).withMobilePhone(phones[1]));
            //} else if (phones.length == 1) {
            //contactCache.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname)
            //.withHomePhone(phones[0]));
            //} else {
            //7 contactCache.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname));

        }

        //}
        return new Contacts(contactCache);
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = driver.findElement(By.name("firstname")).getAttribute("value");
        String lastname = driver.findElement(By.name("lastname")).getAttribute("value");
        String home = driver.findElement(By.name("home")).getAttribute("value");
        String mobile = driver.findElement(By.name("mobile")).getAttribute("value");
        String work = driver.findElement(By.name("work")).getAttribute("value");
        driver.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);

    }

    private void initContactModificationById(int id) {
        WebElement checkbox = driver.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
    }
}
