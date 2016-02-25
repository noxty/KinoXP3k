package Classes;

public abstract class Person
{
    private String fName;
    private String lName;
    private int phoneNo;

    public Person(String fName, String lName, int phoneNo)
    {
        this.fName = fName;
        this.lName = lName;
        this.phoneNo = phoneNo;
    }

    Person() {
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }
}
