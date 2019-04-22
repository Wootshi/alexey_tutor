package org.automation.addressbook.model;

public class ContactData {


    private int id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", secondname='" + lastname + '\'' +
                '}';
    }
}
