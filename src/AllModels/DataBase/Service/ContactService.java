package AllModels.DataBase.Service;

import AllModels.DataBase.Model.Contact;

import java.util.List;

public interface ContactService {

     String addContactToPhone(int phoneId, Contact... contacts);
     Contact findContactByName(int phoneId, String contactName);

     List<Contact> sortContactsByName(int phoneId);

     void deleteContactByNameFromPhone(int phoneId, String contactName);
}
