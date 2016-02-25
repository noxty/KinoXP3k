package Classes;

import junit.framework.TestCase;

/**
 * Created by oelsner on 25/02/16.
 */
public class CustomerTest extends TestCase
{

    public final void testCustomerGetAge() throws Exception
    {
        Customer customer = new Customer("Casper", "Matinsen", "12345678", 29);
        int expResult = 29;
        int result = customer.getAge();
        assertEquals(expResult, result);
    }

    public void testCustomeSetAge() throws Exception
    {
        Customer customer = new Customer("Casper", "Matinsen", "12345678", 29);
        customer.setAge(30);
        int expResult = 30;
        int result = customer.getAge();
        assertEquals(expResult, result);
    }
}