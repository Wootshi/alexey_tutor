package org.automation.addressbook.model;

import com.google.common.base.Objects;

public class ContactData {


    private int id = Integer.MAX_VALUE;
    private String firstname;
    private String lastname;
    private String group;

    //public ContactData(String firstname, String lastname, String group) {
    //this.id = Integer.MAX_VALUE;
    //this.firstname = firstname;
    // this.lastname = lastname;
    //this.group = group;
    //}

    //public ContactData(int id, String firstname, String lastname, String group) {
    //this.id = id;
    // this.firstname = firstname;
    // this.lastname = lastname;
    //this.group = group;
    //}

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstName(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastName(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withGroup(String group) {

        this.group = group;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSecondname() {
        return lastname;
    }

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", secondname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        return group != null ? group.equals(that.group) : that.group == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        return result;
    }
}
