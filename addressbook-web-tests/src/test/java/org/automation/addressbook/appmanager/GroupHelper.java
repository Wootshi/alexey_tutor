package org.automation.addressbook.appmanager;

import org.automation.addressbook.model.ContactData;
import org.automation.addressbook.model.GroupData;
import org.automation.addressbook.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends BaseHelper {

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

    }

    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();

    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));

    }

    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public Groups all() {
        Groups groups = new Groups();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groups.add(new GroupData().withId(id).withName(name));
        }
        return groups;
    }

    public void delete(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
        click(By.name("delete"));

    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        click(By.name("delete"));
    }
}