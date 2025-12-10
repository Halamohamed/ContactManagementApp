package se.lexicon;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner= new Scanner(System.in);
    static Contact contact = new Contact();
    static void main() {
         boolean isRun = true;
        int option;
        do{
            menu();
            option = scanner.nextInt();

            switch (option){
                case 1: addContact();
                    break;
                case 2: getContact();
                    break;
                case 3: isRun = false;
                break;
                default:
                    IO.println("Wrong Input");
            }



        }while (isRun);


    }

    static void menu(){
        IO.println("=== Contact Management ===");
        IO.println(" 1- Add Contact: ");
        IO.println(" 2- Display All Contacts: ");
        IO.println(" 3- Exit: ");
        IO.println(" Choose an option: ");
    }

    static void addContact(){
        //Scanner scanner= new Scanner(System.in);

        IO.println("Enter name: ");
        String name = scanner.next();

        contact.setName(name);
        IO.println("Enter mobile: ");
        int mobile = scanner.nextInt();
        contact.setMobile(mobile);
        IO.println("saved! ");
        int id = contact.getContact().size() +1;
        contact.addContact(new Contact(id,name,mobile));
    }

    static void getContact(){
        for (int i =0; i < contact.getContact().size(); i++){
            IO.println(i + contact.toString());
        }
    }
}
