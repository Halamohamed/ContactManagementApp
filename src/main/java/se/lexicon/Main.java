package se.lexicon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Contact contact = new Contact();

    static void main() {

        boolean isRun = true;
        int option;
        do {
            menu();
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    addContact();
                    break;
                case 2:
                    getContact();
                    break;
                case 3:
                    contact.getContactByMobile();
                    break;
                case 4:
                    contact.getOneContact();
                    break;
                case 5:
                    isRun = false;
                    break;
                default:
                    IO.println("Wrong Input");
            }

        } while (isRun);
    }

    static void menu() {
        IO.println("=== Contact Management ===");
        IO.println(" 1- Add Contact: ");
        IO.println(" 2- Display All Contacts: ");
        IO.println(" 3- Search Contact by Mobile: ");
        IO.println(" 4- Search Contact by Name:");
        IO.println(" 5- Exit: ");
        IO.println(" Choose an option: ");
    }

    static void addContact() {
        IO.println("Enter name: ");
        String name = scanner.next();

        contact.setName(name);
        IO.println("Enter mobile: ");
        int mobile = scanner.nextInt();
        if (mobileExists(mobile)) {
            IO.println("Number already exists.");
            return;
        }
        contact.setMobile(mobile);
        IO.println("saved! ");
        int id = contact.getContact().size() + 1;
        contact.addContact(new Contact(id, name, mobile));
    }

    static boolean mobileExists(int mobile) {
        ArrayList<Contact> contacts = contact.getContact();
        for (Contact c : contacts) {
            if (c.getMobile() == mobile) {
                return true;
            }
        }
        return false;
    }

    static void getContact() {
        Set<Contact> contactSet = new HashSet<>(contact.getContact());
        for (Contact person : contactSet) {
            IO.println(person);
        }
    }
}
