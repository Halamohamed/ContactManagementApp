package se.lexicon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContactManagement {
     Scanner scanner = new Scanner(System.in);
     Contact contact = new Contact();

     void menu() {
        IO.println("=== Contact Management ===");
        IO.println(" 1- Add Contact: ");
        IO.println(" 2- Display All Contacts: ");
        IO.println(" 3- Search Contact by Mobile: ");
        IO.println(" 4- Search Contact by Name:");
        IO.println(" 5- Delete contact: ");
        IO.println(" 6- Update contact: ");
        IO.println(" 0- Exit: ");
        IO.println(" Choose an option: ");
    }

     void addContact() {
        IO.println("Enter name: ");
        String name = scanner.nextLine();
        contact.setName(name);
        //scanner.nextLine();
        IO.println("Enter mobile: ");
        int mobile = scanner.nextInt();
        if (mobileExists(mobile)) {
            IO.println("Number already exists.");
            return;
        }
        contact.setMobile(mobile);
        IO.println("saved! ");

        contact.addContact(new Contact(name, mobile));
    }

     boolean mobileExists(int mobile) {
        ArrayList<Contact> contacts = contact.getContact();
        for (Contact c : contacts) {
            if (c.getMobile() == mobile) {
                return true;
            }
        }
        return false;
    }

     void getContact() {
        Set<Contact> contactSet = new HashSet<>(contact.getContact());
        //contactSet.stream().sorted(Comparator.comparing(Contact::getName));
        for (Contact person : contactSet) {
            IO.println(person);
        }
    }
    void getContactByName() {
        IO.println("Search by name: ");
        String name = scanner.next();
        ArrayList<Contact> contacts = new ArrayList<>(contact.getContact());
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                IO.println(c.toString());
                return;
            }
        }
        IO.println("Contact not found.");
    }
    void getContactByMobile(){
        ArrayList<Contact> contactList = new ArrayList<>(contact.getContact());
        IO.println("Enter mobile number: ");
        int number = scanner.nextInt();
        for (Contact person: contactList){
            if(person.getMobile() == number){
                IO.println(person);
                return;
            }
        }
    }
    public void deleteContact(){
        String contactName;
        IO.println("Enter the contact name to delete: ");
        contactName = scanner.next();
        for (Contact c : contact.getContact()){
            if(c.getName().equalsIgnoreCase(contactName)){
                IO.println(contact.getContact().remove(c));
                return;
            }
        }
    }

    public void updateContact(){
        String searchContact;
        IO.println("Enter the contact name to update: ");
        searchContact = scanner.next();
        IO.println("Write the name:" );
        String contactName = scanner.next();
        IO.println("Write the mobile:" );
        int mobile = scanner.nextInt();

        for (Contact c : contact.getContact()){
            if(c.getName().equalsIgnoreCase(searchContact) ){
                IO.println(contact.getContact().remove(c));
                contact.addContact(new Contact(contactName, mobile));
                return;
            }
        } IO.println("Updated!");
    }
}
