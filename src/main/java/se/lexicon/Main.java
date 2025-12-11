package se.lexicon;

import java.util.*;

public class Main {


     void main() {
        ContactManagement contactManagement = new ContactManagement();
         Scanner scanner = new Scanner(System.in);
        boolean isRun = true;
        int option;
        do {
            contactManagement.menu();

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    contactManagement.addContact();
                    break;
                case 2:
                    contactManagement.getContact();
                    break;
                case 3:
                    contactManagement.getContactByMobile();
                    break;
                case 4:
                    contactManagement.getContactByName();
                    break;
                case 5:
                    contactManagement.deleteContact();
                    break;
                case 6:
                    contactManagement.updateContact();
                    break;
                case 0:
                    IO.println("Exit the Contact Management");
                    isRun = false;
                    break;
                default:
                    IO.println("Wrong Input");
            }
        } while (isRun);
    }



}
