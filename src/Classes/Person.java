package Classes;


public abstract class Person
{
    private String firstName;
    private String lastName;
    private int phoneNo;
    private int customerID;

    public Person(String firstName, String lastName, int phoneNo, int customerID)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.customerID = customerID;
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

    public int getCustomerID()
    {
        return customerID;
    }

    public void setCustomerID(int customerID)
    {
        this.customerID = customerID;
    }
}
