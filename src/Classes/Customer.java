package Classes;

/**
 * Created by oelsner on 22/02/16.
 */
public class Customer extends Person
{
    private int age;


    public Customer(String firstName, String lastName, int phoneNo, int age)
    {
        super(firstName, lastName, phoneNo);
        this.age = age;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}
