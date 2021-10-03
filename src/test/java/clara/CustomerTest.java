package clara;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void customer() {
        Customer customer = new Customer();

        assertEquals("ID: null, Age: 0, First Name: null, Last Name: null", customer.toString());

        assertNull(customer.getId());
        UUID newId = UUID.randomUUID();
        customer.setId(newId);
        assertEquals(Customer.omitDashes(newId), customer.getId());

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
        UUID uuid = UUID.randomUUID();
        Customer customer = new Customer(uuid, 35, "Mary", "Smith");

        assertEquals("ID: " + customer.getId() + ", Age: 35, First Name: Mary, Last Name: Smith", customer.toString());

        assertEquals(35, customer.getAge());
        assertEquals("Mary", customer.getFirstName());
        assertEquals("Smith", customer.getLastName());

        assertEquals(Customer.omitDashes(uuid), customer.getId());

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
    @SuppressWarnings("all")
    public void equalsTest() {
        UUID uuid = UUID.randomUUID();
        Customer customer = new Customer();
        Customer customer1 = new Customer();
        Customer customer2 = new Customer(uuid, 13, "Ben", "Rogers");

        assertTrue(customer.equals(customer1));
        assertTrue(customer.equals(customer));
        assertFalse(customer.equals(null));
        assertFalse(customer.equals(customer2));
    }
}