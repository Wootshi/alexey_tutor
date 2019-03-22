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

        click(By.xpath("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]"));
    }

    public void fillContactForm(ContactData contactData) {
        String existingGroupValue = driver.findElement(By.name("new_group")).getAttribute("value");

        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getSecondname());

        if (contactData.getGroup() != existingGroupValue) {
            click(By.name("new_group"));
        } else {
            if (contactData.getGroup() eq)
            click(By.name(groupValue));
        }
    }

} else{
        click(By.name(groupValue));
        }
        }
        }


public void initContactCreation(){
        click(By.linkText("add new"));
        }

public void deleteSelectedContact(){

        click(By.name("delete"));
        }

public void selectContact(){

        click(By.name("selected[]"));
        }

public void initContactModification(){
        click(By.xpath("xpath=(.//*[normalize-space(text()) and normalize-space(.)='import'])[1]/following::input[1]"));
        }

public void submitContactModification(){
        click(By.xpath("xpath=(.//*[normalize-space(text()) and normalize-space(.)='import'])[1]/following::img[2]"));
        }
        }
