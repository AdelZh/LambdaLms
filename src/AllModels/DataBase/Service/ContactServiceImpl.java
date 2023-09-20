package AllModels.DataBase.Service;

import AllModels.DataBase.Database;
import AllModels.DataBase.Model.Contact;
import AllModels.DataBase.Model.Phone;

import java.util.*;
import java.util.stream.Collectors;

public class ContactServiceImpl implements ContactService {


    private Database dataBase;

    public ContactServiceImpl(Database dataBase) {
        this.dataBase = dataBase;
    }




    @Override
    public String addContactToPhone(int phoneId, Contact... contacts) {
        Optional<Phone> phone = dataBase.getPhoneList()
                .stream().filter(pp -> pp.getInstanceId() == phoneId)
                .findFirst();

        if (phone.isPresent()) {
            Phone phone1 = phone.get();
            phone1.getContacts().addAll(Arrays.asList(contacts));
            System.out.println(dataBase.getPhoneList());
            return "Added";
        } else {
            return "This phone by the ID not found";
        }
    }



    @Override
    public Contact findContactByName(int phoneId, String contactName) {
        Phone phone = dataBase.getPhoneList().get(phoneId);

        if (phone != null) {
            List<Contact> contacts = phone.getContacts();
            System.out.println(contacts.stream()
                    .filter(contact -> contact.getName().equals(contactName))
                    .findFirst());

        }
        return null;
    }


    @Override
    public Contact findContactByPhoneNumber(int phoneId, int phoneNumber) {
       Optional<Phone> phone=dataBase.getPhoneList().stream().filter(pp->pp.getInstanceId()==phoneId).findFirst();
        if (phone.isPresent()) {
            Phone phone1 = phone.get();

            System.out.println(phone1.getContacts().stream()
                    .filter(contact -> contact.getPhoneNumber() == phoneNumber)
                    .findFirst());
        }
        return null;
    }



    @Override
    public List<Contact> sortContactsByName(int phoneId) {
        return dataBase.getPhoneList().stream()
                .filter(phone -> phone.getInstanceId()==phoneId)
                .flatMap(phone -> phone.getContacts().stream())
                .sorted((x2, x1) -> x2.getName().compareTo(x1.getName())).collect(Collectors.toList());
    }



    @Override
    public void deleteContactByNameFromPhone(int phoneId, String contactName) {
        Phone phone=dataBase.getPhoneList().get(phoneId);
        if(phone!=null){
            System.out.println(phone.getContacts().removeIf(pp -> pp.getName().equals(contactName)));
            System.out.println(dataBase.getPhoneList());
        }
    }
}
