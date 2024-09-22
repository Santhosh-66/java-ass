import java.util.Scanner;
interface AddressBookInterface {
    void addContact(Contact contact);       
    void viewAllContacts();          
    Contact searchContactByName(String name); 
}
class Contact {
    private String name;
    private String phoneNumber;
    private String email;
    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void displayContact() {
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
    }
}
class AddressBook implements AddressBookInterface {
    private Contact[] contacts; 
    private int count;        
    public AddressBook(int size) {
        contacts = new Contact[size];
        count = 0;
    }
    @Override
    public void addContact(Contact contact) {
        if (count < contacts.length) {
            contacts[count++] = contact;
            System.out.println("Contact added successfully!");
        } else {
            System.out.println("Address book is full!");
        }
    }
    @Override
    public void viewAllContacts() {
        if (count == 0) {
            System.out.println("No contacts found.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println("Contact " + (i + 1) + ":");
            contacts[i].displayContact();
            System.out.println();
        }
    }

    @Override
    public Contact searchContactByName(String name) {
        for (int i = 0; i < count; i++) {
            if (contacts[i].getName().equalsIgnoreCase(name)) {
                return contacts[i];
            }
        }
        return null;
    }
}
public class AddressBookApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook(100);

        int choice;
        do 
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add a new contact");
            System.out.println("2. View all contacts");
            System.out.println("3. Search for a contact by name");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    Contact newContact = new Contact(name, phoneNumber, email);
                    addressBook.addContact(newContact);
                    break;

                case 2: 
                    System.out.println("\nAll Contacts:");
                    addressBook.viewAllContacts();
                    break;

                case 3:
                    System.out.print("Enter the name to search: ");
                    String searchName = scanner.nextLine();
                    Contact foundContact = addressBook.searchContactByName(searchName);

                    if (foundContact != null) {
                        System.out.println("\nContact found:");
                        foundContact.displayContact();
                    } else {
                        System.out.println("No contact found with the name: " + searchName);
                    }
                    break;

                case 4:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
