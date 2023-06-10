import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

// This class represents a contact with a name and a phone number.
class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber;
    }
}

// This class manages a collection of contacts and provides methods to perform
// operations on the contacts.
class ContactBook {
    private ArrayList<Contact> contacts;

    public ContactBook() {
        contacts = new ArrayList<>();
    }

    // Allows users to add a new contact by entering a name and a phone number.
    public void addContact(String name, String phoneNumber) {
        if (isValidPhoneNumber(phoneNumber)) {
            Contact contact = new Contact(name, phoneNumber);
            contacts.add(contact);
            System.out.println("\nContact added: " + contact);
            System.out.println("Redirecting you to the main menu...");
        } else {
            System.out.println("\nInvalid phone number. Please try again.");
        }
    }

    /*
     * method is a private helper method in the ContactBook class.
     * It is used to validate a phone number based on a regular expression pattern.
     * 
     * The method takes a phoneNumber as input and returns a boolean value
     * indicating whether the phone number is valid or not.
     */
    private boolean isValidPhoneNumber(String phoneNumber) {
        String pattern = "^[+]?[0-9]{11}$";

        return phoneNumber.matches(pattern);
    }

    // Allows users to delete a contact by entering the name of the contact to be
    // deleted.
    public void deleteContact(String name) {
        boolean found = false;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equalsIgnoreCase(name)) {
                Contact removedContact = contacts.remove(i);
                System.out.println("\nContact deleted: " + removedContact);
                System.out.println("Redirecting you to main menu...");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    // Allows users to search for a contact by entering the name of the contact.
    public void searchContact(String name) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Contact found: " + contact);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    // Displays all the contacts in the contact book in alphabetical order.
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Contact book is empty.");
        } else {
            System.out.println("Contacts (Alphabetical Order):");
            Collections.sort(contacts, Comparator.comparing(Contact::getName));
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

}

// This is the main class that contains the main method to run the Contact Book
// application.
public class ContactBookApp {
    public static void main(String[] args) {
        ContactBook contactBook = new ContactBook();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Contact Book!");

        while (running) {
            System.out.println("\n1. Add contact");
            System.out.println("2. Delete contact");
            System.out.println("3. Search contact");
            System.out.println("4. Display contacts (Alphabetical Order)");
            System.out.println("5. Exit");

            System.out.print("\nSelect an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter the contact name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter the contact phone number: ");
                        String phoneNumber = scanner.nextLine();
                        wait(1000);
                        contactBook.addContact(name, phoneNumber);
                        wait(3000);
                        clearConsole();
                        break;
                    case 2:
                        System.out.print("Enter the contact name to delete: ");
                        String deleteName = scanner.nextLine();
                        wait(1000);
                        contactBook.deleteContact(deleteName);
                        wait(3000);
                        clearConsole();
                        break;
                    case 3:
                        System.out.print("Enter the contact name to search: ");
                        String searchName = scanner.nextLine();
                        wait(1000);
                        contactBook.searchContact(searchName);
                        wait(3000);
                        clearConsole();
                        break;
                    case 4:
                        clearConsole();
                        contactBook.displayContacts();
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        wait(1500);
                        clearConsole();
                        break;
                }

            } catch (InputMismatchException e) {
                scanner.nextLine(); // Consume invalid input
                System.out.println("Invalid choice. Please try again.");
                wait(1500);
                clearConsole();
            }
        }

        scanner.close();

        System.out.println("Thank you for using the Contact Book App. Goodbye!");
    }

    /*
     * clearConsole() method is a utility method used in the ContactBookApp_DeChavez
     * class
     * to clear the console output by printing a large number of empty lines
     */
    private static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    /*
     * The wait method is a utility method in the ContactBookApp_DeChavez class
     * used to pause the execution of the program for a specified number of
     * milliseconds
     */
    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}