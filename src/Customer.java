/**
 * Created by oelsner on 22/02/16.
 */
public class Customer extends Person
{
    private int age;


    public Customer(String firstName, String lastName, String phone, int age)
    {
        super(firstName, lastName, phone);
        this.age = age;
    }
}
