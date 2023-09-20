import AllModels.DataBase.Database;
import AllModels.DataBase.Model.Phone;
import AllModels.DataBase.Service.PhoneService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PhoneServiceImpl implements PhoneService {
    private Database database;

    public PhoneServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public String addPhone(Phone... phones) {
        List<Phone> phoneList = database.getPhoneList();

        for (Phone phone : phones) {
            boolean isExist = phoneList.stream().anyMatch(pp -> pp.equals(phone));
            if (!isExist) {
                phoneList.add(phone);
            }
        }

        System.out.println(database.getPhoneList());

        return "Added";
    }


    @Override
    public void getPhoneById(int phoneId) {
        Optional<Phone> foundPhone = database.getPhoneList()
                .stream()
                .filter(pp -> pp.getInstanceId() == phoneId)
                .findFirst();

        System.out.println(foundPhone);

    }


    @Override
    public Phone updatePhoneNameById(int phoneId, String newName) {
       Optional<Phone> updateName=database.getPhoneList()
               .stream()
               .filter(pp->pp.getInstanceId()==phoneId)
               .findFirst();
       updateName.ifPresent(phone -> phone.setName(newName));
       return updateName.orElse(null);
    }



    @Override
    public List<Phone> getAllPhones() {
        return database.getPhoneList().stream().toList();
    }




    @Override
    public List<Phone> getAllPhonesByBrand(String brand) {
        return database.getPhoneList().stream()
                .filter(pp -> pp.getBrand().equals(brand))
                .collect(Collectors.toList());
    }


    @Override
    public void deletePhoneById(int phoneId) {
        System.out.println(database.getPhoneList().removeIf(pp -> pp.getInstanceId() == phoneId));
        System.out.println(database.getPhoneList());
    }
}