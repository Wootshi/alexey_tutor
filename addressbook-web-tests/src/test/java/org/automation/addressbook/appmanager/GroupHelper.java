package org.automation.addressbook.appmanager;

import org.automation.addressbook.model.ContactData;
import org.automation.addressbook.model.GroupData;
import org.automation.addressbook.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GroupHelper extends BaseHelper {

    private Groups groupCache = null;

    public GroupHelper(WebDriver driver) {
        super(driver);

    }

    public void submitFormCreation() {

        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {

        click(By.name("delete"));
    }

    public void selectGroup(int index) {

        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void selectGroupById(int id) {

        driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void enterFirstLastName(ContactData contactData) {

        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getSecondname());

    }

    public void create(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitFormCreation();
        groupCache = null;

    }

    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        groupCache = null;

    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));

    }

    public int count() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public Groups all() {
        if (groupCache != null) {
            return new Groups(groupCache);
        }

        groupCache = new Groups();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupCache.add(new GroupData().withId(id).withName(name));
        }
        return new Groups(groupCache);
    }

    public void delete(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
        click(By.name("delete"));

    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteSelectedGroups();
        groupCache = null;

    }
}