package AllModels.DataBase;

import AllModels.DataBase.Model.Phone;

import java.util.ArrayList;
import java.util.List;

public class Database {


    private List<Phone> phoneList;


    public Database() {
        this.phoneList = new ArrayList<>();
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    @Override
    public String toString() {
        return "AllModels.Database{" +
                "phoneList=" + phoneList +
                '}';
    }
}
