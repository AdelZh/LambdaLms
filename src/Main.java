import AllModels.DataBase.Database;
import AllModels.DataBase.Model.Contact;
import AllModels.DataBase.Model.Phone;
import AllModels.DataBase.Service.ContactServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
public class Main {
    public static void main(String[] args) {


        Database dataBase=new Database();
        PhoneServiceImpl phoneService=new PhoneServiceImpl(dataBase);
        ContactServiceImpl contactService=new ContactServiceImpl(dataBase);

        Scanner scanner=new Scanner(System.in);

        while (true) {
            System.out.println("1. Add phone");
            System.out.println("2. Get phone by Id");
            System.out.println("3. Update phone name by id");
            System.out.println("4. Get all phones");
            System.out.println("5. Get all phones by brand");
            System.out.println("6. Delete phone by id");
            System.out.println("7. Add contact to phone by id");
            System.out.println("8. Find contact by contact name ");
            System.out.println("9. Sort contacts by name");
            System.out.println("10. Delete contact By Name From Phone");
            System.out.println("11. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Put name of phone: ");
                    String name=scanner.next();
                    scanner.nextLine();
                    System.out.print("Put brand of the phone: ");
                    String brand=scanner.next();
                    System.out.print("Put name of phone: ");
                    String name2=scanner.next();
                    scanner.nextLine();
                    System.out.print("Put brand of the phone: ");
                    String brand2=scanner.next();
                   phoneService.addPhone(new Phone(name, brand, new ArrayList<>()), new Phone(name2, brand2, new ArrayList<>()));
                    break;
                case 2:
                    System.out.print("Put id to get the phone: ");
                    int num=scanner.nextInt();
                    phoneService.getPhoneById(num);
                    break;
                case 3:
                    System.out.print("Put id of phone to update the name: ");
                    int id=scanner.nextInt();
                    System.out.print("Write any new name: ");
                    String n=scanner.next();
                    System.out.println(phoneService.updatePhoneNameById(id,n));
                    break;
                case 4:
                    System.out.println(phoneService.getAllPhones());
                    break;
                case 5:
                    System.out.print("Write brand of the phone: ");
                    String bb=scanner.next();
                    System.out.println(phoneService.getAllPhonesByBrand(bb));
                    break;
                case 6:
                    System.out.print("Delete phone by id: ");
                    int id2=scanner.nextInt();
                    phoneService.deletePhoneById(id2);
                    break;
                case 7:
                    System.out.print("Write id of phone to add the contact: ");
                    int id3=scanner.nextInt();
                    System.out.print("Write any name: ");
                    String nn=scanner.next();
                    System.out.print("Put phone number: ");
                    int phoneNum=scanner.nextInt();
                    System.out.print("Write any name: ");
                    String name22=scanner.next();
                    System.out.print("Put phone number: ");
                    int phoneNum2=scanner.nextInt();
                    System.out.println(contactService.addContactToPhone(id3, new Contact(nn, phoneNum), new Contact(name22, phoneNum2)));
                    break;
                case 8:
                    System.out.print("Write id of phone: ");
                    int id4=scanner.nextInt();
                    System.out.print("Write contact name: ");
                    String name3=scanner.next();
                    System.out.println(contactService.findContactByName(id4, name3));
                    break;
                case 9:
                    System.out.println("Write id of phone to sort contacts name: ");
                    int id5=scanner.nextInt();
                    System.out.println(contactService.sortContactsByName(id5));
                    break;
                case 10:
                    System.out.print("Put id of phone to delete the contacts: ");
                    int id6=scanner.nextInt();
                    System.out.print("Write name of the deleting contacts: ");
                    String name5=scanner.next();
                    contactService.deleteContactByNameFromPhone(id6, name5);
                    break;
                case 11:
                    System.exit(0);
            }
        }
    }
}