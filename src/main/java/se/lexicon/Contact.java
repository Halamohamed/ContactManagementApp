package se.lexicon;

import java.util.ArrayList;
import java.util.Comparator;



public class Contact {

   // ArrayList<Contact> contacts = new ArrayList<>();
    Integer id;
    String name;
    String mobile;

    public Contact() {
    }

    public Contact(String name, String mobile) {
        //this.id++;
        this.name = name;
        this.mobile = mobile;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }



   /* ArrayList<Contact> getContact(){

        ArrayList<Contact> sortedContact = new ArrayList<>(contacts);
        sortedContact.sort(Comparator.comparing(Contact::getName, String.CASE_INSENSITIVE_ORDER));
        return sortedContact;
    }*/

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    @Override
    public String toString() {
        return "Contact{" +
                " name='" + getName() + '\'' +
                ", mobile=" + getMobile() +
                '}';
    }
}
