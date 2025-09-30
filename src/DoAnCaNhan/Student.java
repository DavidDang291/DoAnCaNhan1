
package DoAnCaNhan;

public class Student {
    private int id;
    private String name;
    private String birthday;
    private String address;
    private String email;

    public Student(int id, String name, String birthday, String address, String email) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.email = email;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getBirthday() { return birthday; }
    public String getAddress() { return address; }
    public String getEmail() { return email; }

    public void setName(String name) { this.name = name; }
    public void setBirthday(String birthday) { this.birthday = birthday; }
    public void setAddress(String address) { this.address = address; }
    public void setEmail(String email) { this.email = email; }
}