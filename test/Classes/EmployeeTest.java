package Classes;

import junit.framework.TestCase;
import org.junit.*;

/**
 * Created by oelsner on 25/02/16.
 */

public class EmployeeTest extends TestCase
{
    @Before
    public void setUp() throws Exception
    {

    }

    @org.junit.Test
    public final void testEmployeePhone()
    {
        Employee testEmp = new Employee("Casper", "Martinsen", 12345678);
        int expResult = 12345678;
        int result = testEmp.getPhone();
        assertEquals(expResult, result);
    }

    @org.junit.Test
    public final void testEmployeeFirstName()
    {
        Employee testEmp = new Employee("Casper", "Martinsen", 12345678);
        String expResult = "Casper";
        String result = testEmp.getFirstName();
        assertEquals(expResult, result);
    }

    @org.junit.Test
    public final void testEmployeeLastName()
    {
        Employee testEmp = new Employee("Casper", "Martinsen", 12345678);
        String expResult = "Martinsen";
        String result = testEmp.getLastName();
        assertEquals(expResult, result);
    }

    @org.junit.Test
    public final void testEmployeeSetPhone()
    {
        Employee testEmp = new Employee("Casper", "Martinsen", 12345678);
        testEmp.setPhone(87654321);
        int expResult = 87654321;
        int result = testEmp.getPhone();
        assertEquals(expResult, result);
    }

    @org.junit.Test
    public final void testEmployeeSetFirstName()
    {
        Employee testEmp = new Employee("Casper", "Martinsen", 12345678);
        testEmp.setFirstName("Christian");
        String expResult = "Christian";
        String result = testEmp.getFirstName();
        assertEquals(expResult, result);
    }

    @org.junit.Test
    public final void testEmployeeSetLastName()
    {
        Employee testEmp = new Employee("Casper", "Martinsen", 12345678);
        testEmp.setLastName("Oelsner");
        String expResult = "Oelsner";
        String result = testEmp.getLastName();
        assertEquals(expResult, result);
    }

}