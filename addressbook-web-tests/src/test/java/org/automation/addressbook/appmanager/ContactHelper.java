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
        type(By.name("lastname"), contactData.getSecondname());


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
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"maintable\"]/tbody/tr[@name=\"entry\"]"));
        for (WebElement element : elements) {

            String name = element.findElement(By.xpath("./td[3]")).getText();
            String lastname = element.findElement(By.xpath("./td[2]")).getText();

            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));

            contactCache.add(new ContactData().withId(id).withFirstName(name).withLastName(lastname));
        }
        return new Contacts(contactCache);
    }
}
