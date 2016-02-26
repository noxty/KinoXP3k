package Classes;


public abstract class Person
{
    private String firstName;
    private String lastName;
    private int phoneNo;

    public Person(String firstName, String lastName, int phoneNo)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getPhone()
    {
        return phoneNo;
    }

    public void setPhone(int phone)
    {
        this.phoneNo = phone;
    }
}
