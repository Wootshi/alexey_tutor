package org.automation.addressbook.appmanager;

import org.automation.addressbook.model.ContactData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class BaseHelper {
    protected WebDriver driver;
    boolean acceptNextAlert = true;
    private String text;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);

        if (text != null) {
            String existingText = driver.findElement(locator).getAttribute("value");
            if (!text.equals(existingText)) {
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }

        }
    }

//    public void selectFromDropdown(By locator, String menuValue) {
//
//        String existingGroup = driver.findElement(locator).getAttribute("value");
//
//        click(locator);
//
//        if (existingGroup != null) {
//            if (existingGroup.equals(menuValue)) {
//
//                driver.findElement(locator).sendKeys(menuValue);
//                driver.findElement(locator).click();
//
//            }
//        } else {
//
//            driver.findElement(locator).sendKeys("[none]");
//            driver.findElement(locator).click();
//
//        }
//
//    }


    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isThereAnEntry() {

        return isElementPresent(By.name("selected[]"));
    }
}
