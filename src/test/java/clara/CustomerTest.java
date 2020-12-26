package clara;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void customer() {
        Customer customer = new Customer();

        assertEquals("ID: null, Age: 0, First Name: null, Last Name: null", customer.toString());

        assertNull(customer.getId());
        String newId = "1234";
        customer.setId(newId);
        assertEquals(newId, customer.getId());

        assertEquals(0, customer.getAge());
        int newAge = 24;
        customer.setAge(newAge);
        assertEquals(newAge, customer.getAge());

        assertNull(customer.getFirstName());
        String newFirstName = "Alyssa";
        customer.setFirstName(newFirstName);
        assertEquals(newFirstName, customer.getFirstName());

        assertNull(customer.getLastName());
        String newLastName = "Johnson";
        customer.setLastName(newLastName);
        assertEquals(newLastName, customer.getLastName());
    }

    @Test
    public void customer1() {
        Customer customer = new Customer("3392", 35, "Mary", "Smith");

        assertEquals("ID: 3392, Age: 35, First Name: Mary, Last Name: Smith", customer.toString());

        assertEquals("3392", customer.getId());
        assertEquals(35, customer.getAge());
        assertEquals("Mary", customer.getFirstName());
        assertEquals("Smith", customer.getLastName());

        String newId = "9954";
        customer.setId(newId);
        assertEquals(newId, customer.getId());

        int newAge = 42;
        customer.setAge(newAge);
        assertEquals(newAge, customer.getAge());

        String newFirstName = "Ben";
        customer.setFirstName(newFirstName);
        assertEquals(newFirstName, customer.getFirstName());

        String newLastName = "Green";
        customer.setLastName(newLastName);
        assertEquals(newLastName, customer.getLastName());
    }

    @Test
    public void customer2() {
        Customer customer = new Customer();
        Customer customer1 = new Customer();
        Customer customer2 = new Customer("1234", 13, "Ben", "Rogers");

        assertTrue(customer.equals(customer1));
        assertFalse(customer.equals(customer2));
    }
}