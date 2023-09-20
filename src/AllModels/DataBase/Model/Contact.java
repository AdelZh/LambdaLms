package AllModels.DataBase.Model;

public class Contact {


    public static int id;
    private int instanceId;

    private String name;

    private int phoneNumber;


    public Contact( String name, int phoneNumber) {
        this.instanceId = id++;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }



    public void setInstanceId(int instanceId) {
        this.instanceId = instanceId;
    }
    public String getName() {
        return name;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }



    @Override
    public String toString() {
        return "Contact{" +
                "instanceId=" + instanceId +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
