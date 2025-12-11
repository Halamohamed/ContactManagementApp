package se.lexicon;

import java.util.*;

public class ContactManagement {
    Scanner scanner = new Scanner(System.in);
    Contact contact = new Contact();
    Set<Contact> contactSet = new HashSet<>();

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
        String name = scanner.next();
        contact.setName(name);
        //scanner.nextLine();
        IO.println("Enter mobile: ");
        String mobile = scanner.next();
        if (mobileExists(mobile)) {
            IO.println("Number already exists.");
            return;
        }
        contact.setMobile(mobile);

        boolean added = addContact(new Contact(name, mobile));
        if (added) {
            IO.println("saved! ");
        } else {
            IO.println("doesn't save! ");
        }
    }

    boolean addContact(Contact contact) {
        if (contactSet.contains(contact)) {
            IO.println("This contact is already saved");
        } else {
            contactSet.add(contact);
            return true;

        }
        return false;
    }

    boolean mobileExists(String mobile) {
        ArrayList<Contact> contacts = new ArrayList<>(contactSet);
        for (Contact c : contacts) {
            if (c.getMobile().equalsIgnoreCase(mobile)) {
                return true;
            }
        }
        return false;
    }

    void getContacts() {

        contactSet.stream()
                .sorted(Comparator.comparing(Contact::getName))
                .forEach(IO::println);

    }

    void getContactByName() {
        IO.println("Search by name: ");
        String name = scanner.next();
        boolean found = false;
        //ArrayList<Contact> contacts = new ArrayList<>(contactSet);
        for (Contact c : contactSet) {
            if (c.getName().equalsIgnoreCase(name)) {

                IO.println(c.toString());
                found = true;
                return;
            }
        }
        if (!found) {
            IO.println("This contact: " + name + " not found!");
        }
    }

    void getContactByMobile() {
        //ArrayList<Contact> contactList = new ArrayList<>(contact.getContact());
        IO.println("Enter mobile number: ");
        String number = scanner.next();
        boolean found = false;
        for (Contact person : contactSet) {
            if (person.getMobile().equalsIgnoreCase(number)) {
                IO.println(person);
                found = true;
                return;
            }
        }
        if (!found) {
            IO.println("This mobile: " + number + " not exist!");
        }
    }

    public void deleteContact() {
        Iterator<Contact> iterator = contactSet.iterator();
        String contactName;
        boolean found = false;
        IO.println("Enter the contact name to delete: ");
        contactName = scanner.next();

        while (iterator.hasNext()) {
            Contact c = iterator.next();
            if (c.getName().equalsIgnoreCase(contactName)) {
                iterator.remove();
                IO.println(c + " deleted");
                found = true;
                return;
            }
        }
        if (!found) {
            IO.println("Contact " + contactName + " not exist!");
        }
    }

    public void updateContact() {

        IO.println("Enter the contact name to update: ");
        String searchContact = scanner.next();

        boolean found = false;

        for (Contact c : contactSet) {
            if (c.getName().equalsIgnoreCase(searchContact)) {
                IO.println("Write the new name:");
                String contactName = scanner.next();
                IO.println("Write the new mobile:");
                String mobile = scanner.next();
                contactSet.remove(c);
                contactSet.add(new Contact(contactName, mobile));
                found = true;
                IO.println("Updated!");
                break;
            }
        }
        if (!found) {
            IO.println("Contact: " + searchContact + " not found!");
        }
    }
}
