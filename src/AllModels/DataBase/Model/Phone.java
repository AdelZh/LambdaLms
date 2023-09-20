package AllModels.DataBase.Model;

import java.util.ArrayList;
import java.util.List;

public class Phone {

    public static int id;
    private int instanceId;
    private String name;
    private String brand;
    private List<Contact> contacts;


    public Phone( String name, String brand, List<Contact> contacts) {
        this.instanceId = id++;
        this.name = name;
        this.brand = brand;
        this.contacts = new ArrayList<>();
        for(int i=0; i<contacts.size(); i++){
            contacts.get(i).setInstanceId(i+1-1);
        }
    }


    public int getInstanceId() {
        return instanceId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBrand() {
        return brand;
    }
    public List<Contact> getContacts() {
        return contacts;
    }



    @Override
    public String toString() {
        return "Phone{" +
                "instanceId=" + instanceId +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}
